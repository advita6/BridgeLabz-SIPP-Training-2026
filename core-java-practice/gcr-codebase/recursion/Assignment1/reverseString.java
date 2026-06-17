public static String reverseString(String str) {
    // Base Case
    if (str == null || str.length() <= 1) {
        return str;
    }
    // Recursive Step: Last character + reverse of remaining substring
    return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
}