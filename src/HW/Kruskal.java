import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Stream;


public class Kruskal {
    
    public void findMST(ArrayList<ArrayList<Integer[]>> graph){
        PriorityQueue<Integer[]> heapEdges;
        Integer[][] mst = new Integer[graph.size()][3];
        int mstSize = 0;
        Integer[] sets = new Integer[graph.size()];

        heapEdges = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < graph.size(); i++){
            sets[i] = i;
            for (int j = 0; j < graph.get(i).size(); j++){
                Integer[] edge = {i, graph.get(i).get(j)[0], graph.get(i).get(j)[1]};
                heapEdges.add(edge);
            }
        }

        while(mstSize<graph.size()-1 && heapEdges.size()!= 0){
            Integer[] edge = heapEdges.poll();
            if ((sets[edge[0]]!=sets[edge[1]])){
                mst[mstSize] = edge;
                mstSize++;
                int idSet = sets[edge[1]];
                for (int i = 0; i < sets.length; i++){
                    if (sets[i] == idSet){
                        sets[i] = sets[edge[0]];
                    }
                }            
            }
        }

        if (mstSize != graph.size()-1){
            System.out.println("No se pudo encontrar un MST");
        }
        else{
            int total = 0;
            for (int i = 0; i < mstSize; i++){
                System.out.println(mst[i][0] + " - " + mst[i][1] + "\t" + mst[i][2]);
                total += mst[i][2];
            }
            System.out.println("MC: " + total + "\n\n");
        }
    }


    public static void main(String[] args) throws IOException {
        Kruskal instancia = new Kruskal();
        try(InputStreamReader is = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(is);){
            String line = br.readLine();
            int casos = Integer.parseInt(line);
            for (int i = 0; i < casos && line != null && line.length() > 0 && !"0".equals(line); i++) {
                int numV = Integer.parseInt(br.readLine());
                ArrayList<ArrayList<Integer[]>> graph = new ArrayList<ArrayList<Integer[]>>();
                for (int j = 0; j < numV; j++){
                    String[] dataStr = br.readLine().split(" ");
                    ArrayList<Integer[]> inList = new ArrayList<Integer[]>();
                    for (String s : dataStr){
                        Integer[] x = Stream.of(s.split(":")).map(Integer::valueOf).toArray(Integer[]::new);
                        inList.add(x);
                    }
                    graph.add(inList);
                }
                instancia.findMST(graph);
                br.readLine();
            }
        }
    }
}
