package Controller;

/**
 * Role-Based Access Control Manager
 * Provides centralized role management and permission checking
 * Following DRY and KISS principles
 */
public class RoleManager {
    
    // Role constants, higher number = more privileges
    public static final int ADMIN = 5;
    public static final int MANAGER = 4;
    public static final int STAFF = 3;
    public static final int CLIENT = 2;
    

    public static boolean canAccess(int userRole, int requiredRole) {
        return userRole >= requiredRole;
    }
    

    public static String getRoleName(int role) {
        switch (role) {
            case ADMIN: return "Administrator";
            case MANAGER: return "Manager";
            case STAFF: return "Staff";
            case CLIENT: return "Client";
            default: return "Unknown";
        }
    }
    

    public static boolean isAdmin(int userRole) {
        return userRole == ADMIN;
    }
    

    public static boolean isManagerOrHigher(int userRole) {
        return userRole >= MANAGER;
    }
    

    public static boolean isStaffOrHigher(int userRole) {
        return userRole >= STAFF;
    }
    
    public static boolean canManageUsers(int userRole) {
        return userRole >= ADMIN;
    }
    

    public static boolean canManageProducts(int userRole) {
        return userRole >= MANAGER;
    }
    

    public static boolean canViewProducts(int userRole) {
        return userRole >= CLIENT;
    }
    

    public static boolean canViewLogs(int userRole) {
        return userRole >= STAFF;
    }
    

    public static boolean canViewHistory(int userRole) {
        return userRole >= CLIENT;
    }
    

    public static boolean canViewAllHistory(int userRole) {
        return userRole >= STAFF;
    }
    

    public static boolean canViewAdminLogs(int userRole) {
        return userRole >= MANAGER;
    }
}
