package HW;

import java.util.ArrayList;
import java.util.Arrays;

public class List2Matrix {

    public int[][] convert(ArrayList<ArrayList<Integer>> adjList){
        int v = adjList.size();
        int[][] matrix = new int[v][v];

        for (int[] row : matrix){
            Arrays.fill(row, 0);
        }

        for (int i = 0; i < v; i++){
            ArrayList<Integer> inList = adjList.get(i);
            for (int j = 0; j < inList.size(); j++){
                matrix[i][inList.get(j)] = 1;
            }
        }
        return matrix;
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        adjList.add(new ArrayList<>(Arrays.asList(1, 2)));
        adjList.add(new ArrayList<>(Arrays.asList(0, 3, 4)));
        adjList.add(new ArrayList<>(Arrays.asList(0, 4)));
        adjList.add(new ArrayList<>(Arrays.asList(1, 4, 5)));
        adjList.add(new ArrayList<>(Arrays.asList(1, 2, 3, 5)));
        adjList.add(new ArrayList<>(Arrays.asList(3, 4)));

        List2Matrix converter = new List2Matrix();
        int[][] matrix = converter.convert(adjList);
        converter.printMatrix(matrix);
    }
}