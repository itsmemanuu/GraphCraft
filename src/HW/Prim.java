import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prim {

    public void findMST(int[][] matrix){
        int vxSize = matrix.length;
        ArrayList<Integer[]> mst = new ArrayList<>();
        ArrayList<Integer> included = new ArrayList<>();

        PriorityQueue<Integer[]> heapEdges = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < vxSize; i++){
            if (matrix[0][i] != Integer.MAX_VALUE){
                heapEdges.add(new Integer[]{0, i, matrix[0][i]});
            }
        }
        
        included.add(0);
        Integer[] minEdge = {0, 0, 0};
        while(included.size() < vxSize){
            Boolean flag = false;
            while(!heapEdges.isEmpty() && !flag){
                minEdge = heapEdges.poll();
                flag = !included.contains(minEdge[1]) || !included.contains(minEdge[0]);
            }
            if (flag){
                mst.add(minEdge);
                included.add(minEdge[1]);
                for (int i = 0; i < vxSize; i++){
                    int[] act = matrix[minEdge[1]];
                    Integer[] edgeX = {minEdge[1], i, act[i]};
                    if (act[i] != Integer.MAX_VALUE && !mst.contains(edgeX)){
                        heapEdges.add(edgeX);
                    }
                }
            }   
        }
        
        if (mst.size() != vxSize-1){
            System.out.println("No se pudo encontrar un MST");
        }
        else{
            int total = 0;
            for (Integer[] edge : mst){
                System.out.println(edge[0] + " - " + edge[1] + "\t" + edge[2]);
                total += edge[2];
            }
            System.out.println("MC: " + total + "\n\n");
        }
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
                instancia.findMST(graph);
                br.readLine();
            }
        }
    }
}
