package Proyectos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;


public class P2 {

    HashMap<Integer, Integer[][]> map = new HashMap<>();
    HashMap<Integer, Set<Integer>> graph = new HashMap<>();

    public void decode(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                int id = matrix[i][j];
                Integer[] min = {i, j};
                Integer[] max = {i, j};
                if (map.containsKey(id)){
                    Integer[][] values = map.get(id);
                    min = values[0];
                    max = values[1];
                    if (i < min[0]) min[0] = i;
                    else if (i > max[0]) max[0] = i;

                    if (j < min[1]) min[1] = j;
                    else if (j > max[1]) max[1] = j;

                }
                else{
                    Integer[][] values = {min, max};
                    map.put(id, values);
                }
                
                for (Integer key : map.keySet()){
                    Integer[][] values2 = map.get(key);
                    Integer[] min2 = values2[0];
                    Integer[] max2 = values2[1];
                    if (id != key){
                        if (min[0] >= min2[0] && min[1] >= min2[1] && max[0] <= max2[0] && max[1] <= max2[1]){
                            Set<Integer> set;
                            if (graph.containsKey(key)){
                                set = graph.get(key);
                            }
                            else{
                                set = new HashSet<Integer>();
                            }
                            set.add(id);
                            graph.put(key, set);
                        }
                    }
                }
            }
        }

        for (Integer id : graph.keySet()){
            System.out.print(id);
            System.out.print(graph.get(id));
        }
    }

    public static void main(String[] args) throws IOException {
        P2 instancia = new P2();
        try(InputStreamReader is = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(is);){
            String line = br.readLine();
            int casos = Integer.parseInt(line);
            for (int i = 0; i < casos && line != null && line.length() > 0 && !"0".equals(line); i++) {
                Integer[] info = Stream.of(br.readLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
                int[][] m = new int[info[0]][info[1]];
                for (int j = 0; j < info[0]; j++){
                    String[] dataStr = br.readLine().split(" ");
                    for (int k = 0; k < info[1]; k++){
                        m[j][k] = Integer.parseInt(dataStr[k]);
                    }
                }
                instancia.decode(m);
                br.readLine();
            }
        }
    }
}
