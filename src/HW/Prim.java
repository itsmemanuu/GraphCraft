package HW;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Prim {
    ArrayList<Integer> vxMST = new ArrayList<Integer>();
    int vxSize;
    

    public void findMST(int[][] matrix, int vxSize){
        int[] mst = new int[matrix.length];
        this.vxSize = vxSize; 
        int[] costs = new int[matrix.length];
        Boolean[] included = new Boolean[matrix.length];

        for(int i = 0; i < matrix.length; i++){
            costs[i] = Integer.MAX_VALUE;
            included[i] = false;
        }

        costs[0] = 0;
        mst[0] = -1;

        for (int i = 0; i < matrix.length - 1; i++){
            int min = minW(costs, included);
            included[min] = true;

            for (int j = 0; j < matrix.length; j++){
                if (matrix[min][j] != 0 && included[j] == false && matrix[min][j] < costs[j]){
                    mst[j] = min;
                    costs[j] = matrix[min][j];
                }
            }
        }

        int total = 0;
        for (int i = 1; i < matrix.length; i++){
            System.out.println(mst[i] + " - " + i + "\t" + matrix[i][mst[i]]);
            total += matrix[i][mst[i]];
        }
        System.out.println("MC: " + total + "\n\n");
    }

    private int minW(int[] costs, Boolean[] included){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < costs.length; i++){
            if (included[i] == false && costs[i] < min){
                min = costs[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    public static void main(String[] args) throws IOException {
        Prim instancia = new Prim();
        try(InputStreamReader is = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(is);){
            String line = br.readLine();
            int casos = Integer.parseInt(line);
            for (int i = 0; i < casos && line != null && line.length() > 0 && !"0".equals(line); i++) {
                int numV = Integer.parseInt(br.readLine());
                int[][] graph = new int[numV][numV];
                for (int j = 0; j < numV; j++){
                    String[] dataStr = br.readLine().split(" ");
                    for (int k = 0; k < numV; k++){
                        if (dataStr[k].equals("x")){
                            graph[j][k] =  Integer.MAX_VALUE;
                        }
                        else{
                            graph[j][k] = Integer.parseInt(dataStr[k]);
                        }
                    }
                }
                instancia.findMST(graph, numV);
                br.readLine();
            }
        }
    }
}
