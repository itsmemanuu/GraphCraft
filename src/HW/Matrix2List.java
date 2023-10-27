package HW;

import java.util.ArrayList;

public class Matrix2List {

    public ArrayList<ArrayList<Integer>> convert(int[][] matrix) {
        int v = matrix[0].length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < v; i++){
            adjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < v; i++){
            for (int j = 0; j < v; j++){
                if (matrix[i][j] == 1){
                    adjList.get(i).add(j);
                }
            }
        }
        return adjList;
    }
    
    public void printArrayList(ArrayList<ArrayList<Integer>> 
                                                adjListArray)
    {
        for (int v = 0; v < adjListArray.size(); v++) {
            System.out.print(v);
            for (Integer u : adjListArray.get(v)) {
                System.out.print(" -> " + u);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 1, 0, 0, 0},
            {1, 0, 0, 1, 1, 0},
            {1, 0, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 1},
            {0, 1, 1, 1, 0, 1},
            {0, 0, 0, 1, 1, 0}
        };
        Matrix2List m2l = new Matrix2List();
        ArrayList<ArrayList<Integer>> adjList = m2l.convert(matrix);
        m2l.printArrayList(adjList);
    }
}