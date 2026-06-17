public static boolean isPalindrome(String str) {
    // Base Case
    if (str.length() <= 1) {
        return true;
    }
    
    // Check first and last characters
    if (str.charAt(0) != str.charAt(str.length() - 1)) {
        return false;
    }
    
    // Recursive Step: Check internal substring
    return isPalindrome(str.substring(1, str.length() - 1));
}