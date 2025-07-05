package Controller;
import java.util.regex.Pattern;

public final class ValidationUtils {
    private static final Pattern SAFE_USERNAME =
            Pattern.compile("^[A-Za-z0-9_]{4,30}$");

    private static final Pattern STRONG_PWD =
            Pattern.compile("^(?=.*[A-Z])(?=.*[^A-Za-z0-9]).{12,}$");

    public static String sanitizeUsername(String raw) throws IllegalArgumentException {
        String trimmed = raw == null ? "" : raw.trim();
        if (!SAFE_USERNAME.matcher(trimmed).matches())
            throw new IllegalArgumentException("Username must be 4-30 characters, letters, numbers, or underscores only.");
        return trimmed;
    }

    public static char[] sanitizePassword(char[] pwd, char[] confirm) {

        if (!java.util.Arrays.equals(pwd, confirm))
            throw new IllegalArgumentException("Passwords do not match");

        /* ---------- strength check ---------- */
        String pwStr = new String(pwd);           // temporary view for regex
        try {
            if (!STRONG_PWD.matcher(pwStr).matches()) {
                throw new IllegalArgumentException("Password must be at least 12 characters, include an uppercase letter and a special character.");
            }
        } finally {
            pwStr = null;                         // drop reference; GC can reclaim
        }
        return pwd;
    }

}
