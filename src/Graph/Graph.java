package Graph;
import java.util.*;
import Algorithms.*;

public class Graph {
    public ArrayList<LinkedList<Node>> adjlist = new ArrayList<>();
    public HashMap<Character, Integer> ids = new HashMap<>();
    public HashMap<Integer, Character> idsInv = new HashMap<>();
    public HashMap<Integer, List<Edge>> edges = new HashMap<>();

    public Graph(List<Edge> edgesList){
        for (int i = 0; i < edgesList.size(); i++) {
            ids.put(edgesList.get(i).src, i);
            idsInv.put(i, edgesList.get(i).src);
            adjlist.add(i, new LinkedList<Node>());
        }

        for (Edge edge : edgesList) {
            int srcid = ids.get(edge.src);
            if (edges.get(srcid) != null){
                edges.get(srcid).add(edge);
            } else {
                edges.put(srcid, new ArrayList<Edge>());
                edges.get(srcid).add(edge);
            }
            adjlist.get(ids.get(edge.src)).add(new Node(edge.dest, ids.get(edge.dest), edge.weight));
        }
    }

    public void print(){
        int src_vertex = 0;
        int list_size = adjlist.size();

        System.out.println("The contents of the graph: ");
        while (src_vertex < list_size){
            for (Node edge : adjlist.get(src_vertex)) {
                System.out.print("Vertex: " + idsInv.get(src_vertex) + " -> " + edge.value + " (" + edge.weight + ")\t");
            }
            System.out.println();
            src_vertex++;
        }
    }

    public void djkSearch(Character pA, Character pB){
        new Dijkstra(ids.get(pA), ids.get(pB), this);
    }
}