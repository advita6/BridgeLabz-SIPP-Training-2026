public static void printNto1(int n) {
    // Base Case
    if (n < 1) {
        return;
    }
    // Print current number
    System.out.print(n + " ");
    // Recursive Call
    printNto1(n - 1);
}