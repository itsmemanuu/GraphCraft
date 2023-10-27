package HW;

import java.util.ArrayList;

public class Testing {
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 1, 0, 0, 1},
            {1, 1, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 0},
            {0, 1, 1, 0, 1, 1},
            {0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 1, 0}
        };
        Matrix2List m2l = new Matrix2List();
        ArrayList<ArrayList<Integer>> adjList = m2l.convert(matrix);
        List2Matrix l2m = new List2Matrix();
        int[][] matrix2 = l2m.convert(adjList);

        boolean areEqual = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix2[i][j]) {
                    areEqual = false;
                    break;
                }
            }
            if (!areEqual) {
                break;
            }
        }
        System.out.println("The matrices are " + (areEqual ? "" : "not ") + "equal.");
    }
}
