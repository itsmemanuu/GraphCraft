package Algorithms;

import java.util.*;
import Graph.*;

public class Dijkstra {
    int src, dest;
    Graph graph;
    List<Integer> visited = new ArrayList<>();
    HashMap<Integer, List<Edge>> edges;
    HashMap<Character, Integer> ids = new HashMap<>();
    HashMap<Integer, int[]> table = new HashMap<>();

    public Dijkstra(int src, int dest, Graph graph) {
        this.src = src;
        this.dest = dest;
        this.graph = graph;
        this.edges = graph.edges;
        this.ids = graph.ids;
        for (int i : ids.values()) {
            int[] x = {Integer.MAX_VALUE, -1}; //dist, previous
            table.put(i, x);

        }
        int[] x = {0, -1};
        table.put(src, x);
        search();
    }    

    private void search(){
        visited.add(src);
        int nextid = nextTown(src, 0);

        while (nextid != dest){
            visited.add(nextid);
            nextid = nextTown(nextid, table.get(nextid)[0]);
        }

        for (String i : getPath()){
            System.out.print(" -> " + i);
        }

        System.out.println("\n" + table.get(nextid)[0]);
    }

    private int nextTown(int from, int val){
        int min = Integer.MAX_VALUE;
        int minid = 0;
        for (Edge edge : edges.get(from)){
            int id = ids.get(edge.dest);
            int[] x = table.get(id);
            int dst = edge.weight + val;
            if (dst < x[0]){
                x = new int[] {dst, from};
                table.put(id, x);
            }
            
            if (x[0] < min && !visited.contains(id)){
                min = x[0];
                minid = id;
            }
        }

        return minid;
    }

    private String[] getPath(){
        int act = dest;
        String x = "" + graph.idsInv.get(act);
        while (act != src){
            act = table.get(act)[1];
            x = graph.idsInv.get(act) + ", " + x;
        }
        return x.split(", ");
    }
}