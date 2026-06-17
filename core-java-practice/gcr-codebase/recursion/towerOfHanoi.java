public class TowerOfHanoi {

    static int moveCount = 0;

    public static void solve(int n, char source,
                             char auxiliary,
                             char destination) {

        if (n == 1) {
            System.out.println("Move Disk 1 from "
                    + source + " to " + destination);
            moveCount++;
            return;
        }

        solve(n - 1, source, destination, auxiliary);

        System.out.println("Move Disk " + n + " from "
                + source + " to " + destination);

        moveCount++;

        solve(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {

        int n = 3;

        solve(n, 'A', 'B', 'C');

        System.out.println("Total Moves = " + moveCount);
    }
}