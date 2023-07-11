package Graph;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(
			// new Edge('A', 'C', 3),
			// new Edge('A', 'F', 2),
			// new Edge('B', 'D', 1),
			// new Edge('B', 'E', 2),
			// new Edge('B', 'F', 6),
			// new Edge('B', 'G', 2),
			// new Edge('C', 'A', 3),
			// new Edge('C', 'F', 2),
			// new Edge('C', 'E', 1),
			// new Edge('C', 'D', 4),
			// new Edge('D', 'C', 4),
			// new Edge('D', 'B', 1),
			// new Edge('E', 'C', 1),
			// new Edge('E', 'F', 3),
			// new Edge('E', 'B', 2),
			// new Edge('F', 'A', 2),
			// new Edge('F', 'C', 2),
			// new Edge('F', 'E', 3),
			// new Edge('F', 'B', 6),
			// new Edge('F', 'G', 5),
			// new Edge('G', 'F', 5),
			// new Edge('G', 'B', 2)
			new Edge('A', 'B', 2),
			new Edge('A', 'D', 8),
			new Edge('B', 'A', 2),
			new Edge('B', 'D', 5),
			new Edge('B', 'E', 6),
			new Edge('C', 'E', 9),
			new Edge('C', 'F', 3),
			new Edge('D', 'A', 8),
			new Edge('D', 'B', 5),
			new Edge('D', 'E', 3),
			new Edge('D', 'F', 2),
			new Edge('E', 'B', 6),
			new Edge('E', 'D', 3),
			new Edge('E', 'F', 1),
			new Edge('E', 'C', 9),
			new Edge('F', 'D', 2),
			new Edge('F', 'E', 1),
			new Edge('F', 'C', 3)
		);
		Graph graph = new Graph(edges);
		graph.print();
		graph.djkSearch('A', 'C');
	}
}
