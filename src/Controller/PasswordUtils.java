package Controller;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Arrays;

/**
 * Password hashing & verification helper.
 *
 * Format stored in DB:  saltBase64$hashBase64
 * Example: zD1Nv7o4q6QL1w==$bAGypoT45hWZzmK1xGpFh+J0...
 */
public final class PasswordUtils {
    private static final String  ALGORITHM     = "PBKDF2WithHmacSHA256";
    private static final int     ITERATIONS    = 120_000;      // OWASP ≥ 100k for SHA-256 (2025)
    private static final int     KEY_LENGTH    = 256;          // bits
    private static final int     SALT_BYTES    = 16;           // 128-bit salt

    private static final SecureRandom RNG = new SecureRandom();
    private static final Base64.Encoder B64ENC = Base64.getEncoder();
    private static final Base64.Decoder B64DEC = Base64.getDecoder();

    private PasswordUtils() { }  // utility class

    /** Generates a salted PBKDF2 hash: salt$hash (Base64). */
    public static String createHash(char[] password) {
        byte[] salt = new byte[SALT_BYTES];
        RNG.nextBytes(salt);

        byte[] hash = pbkdf2(password, salt, ITERATIONS);
        try {
            return String.join("$",
                    B64ENC.encodeToString(salt),
                    B64ENC.encodeToString(hash));
        } finally {
            wipe(hash);
            wipe(password);
        }
    }

    /** Verifies a password against the stored record. */
    public static boolean verifyPassword(char[] candidate, String stored) {
        try {
            String[] parts = stored.split("\\$");
            if (parts.length != 4 || !parts[0].equals("pbkdf2_sha256"))
                throw new IllegalArgumentException("Bad hash format");

            int     iter = Integer.parseInt(parts[1]);
            byte[]  salt = B64DEC.decode(parts[2]);
            byte[]  hash = B64DEC.decode(parts[3]);

            byte[] test = pbkdf2(candidate, salt, iter);
            return slowEquals(test, hash);
        } finally {
            wipe(candidate);
        }
    }


    private static byte[] pbkdf2(char[] pwd, byte[] salt, int iter) {
        try {
            PBEKeySpec spec = new PBEKeySpec(pwd, salt, iter, KEY_LENGTH);
            SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
            return skf.generateSecret(spec).getEncoded();
        } catch (Exception e) {
            throw new IllegalStateException("PBKDF2 failure", e);
        }
    }

    /** Constant-time comparison to avoid timing attacks. */
    private static boolean slowEquals(byte[] a, byte[] b) {
        if (a.length != b.length) return false;
        int diff = 0;
        for (int i = 0; i < a.length; i++)
            diff |= a[i] ^ b[i];
        return diff == 0;
    }

    /** Zero-out a byte[] / char[] quickly. */
    private static void wipe(byte[] data) { if (data != null) Arrays.fill(data, (byte) 0); }
    private static void wipe(char[]  data) { if (data != null) Arrays.fill(data, '\0');    }
}
