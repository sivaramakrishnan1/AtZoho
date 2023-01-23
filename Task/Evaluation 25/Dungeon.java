import java.io.LineNumberInputStream;
import java.util.Scanner;

public class Dungeon {
    public static void main(String[] args) {
        Dungeon d = new Dungeon();
        // Scanner s = new Scanner(System.in);
        // int size = s.nextInt();
        // int[][] arr = new int[size][size];
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[0].length; j++) {
        //         arr[i][j] = s.nextInt();
        //     }
        // }
        // s.close();
        int[][] arr = {{-2,-3,3},{-5,-10,1},{10,30,5}};

        System.out.println(d.calculateMinimumHP(arr));
        ;
    }

    static int minHP = Integer.MAX_VALUE;
    static String path = "";

    
    
    // top-to-bottom approach

    
    // bottom-to-top approach
    /* public int calculateMinimumHP(int[][] dungeon) {
        fillMap(dungeon, dungeon.length - 1, dungeon[0].length - 1, 0, "");
        return minHP + 1;
    }
    
    public void fillMap(int[][] dungeon, int x, int y, int hp, String path) {
        if (x < 0 || y < 0)
            return;

        hp += dungeon[x][y];
        if (x == 0 && y == 0) {
            // System.out.println(path + " " + hp);
            if (Math.abs(hp) < minHP) {
                if(hp > 0) minHP = 0;
                else minHP = Math.abs(hp);
            }
        }

        // System.out.println(path + " " + hp);
        fillMap(dungeon, x - 1, y, hp, path + "->{" + (x - 1) + "," + y + "} ");
        fillMap(dungeon, x, y - 1, hp, path + "->{" + x + "," + (y - 1) + "} ");
    } */
}
