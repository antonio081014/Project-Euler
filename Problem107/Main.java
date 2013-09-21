/**
 * This problem ask the maximum saves from cutting edges from a graph, 
 * which equals to the total weight of edges minus the minimum spanning 
 * tree's weight (MST)
 * 
 * The MST is implemented with Prim's Algorithm with total cost O(mn),
 * Here m represents # of edges, and n represents # of vertices.
 */
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author antonio081014
 * @time Sep 19, 2013, 10:54:40 PM
 */
public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
		System.exit(0);
	}

	private void run() {
		try {
			BufferedReader in = new BufferedReader(
					new FileReader("network.txt"));
			MSTGraph<Integer> g = new MSTGraph<Integer>();
			int nodes = 40;
			long total = 0;
			for (int i = 0; i < nodes; i++) {
				String[] str = in.readLine().split(",");
				for (int j = 0; j < nodes; j++) {
					if (str[j].compareTo("-") != 0) {
						int a = i;
						int b = j;
						int c = Integer.parseInt(str[j]);
						total += c;
						g.addVertex(new Vertex<Integer>(a, a));
						g.addVertex(new Vertex<Integer>(b, b));
						g.addEdge(new Vertex<Integer>(a, a),
								new Vertex<Integer>(b, b), c);
					}
				}
			}
			in.close();
			long start = System.currentTimeMillis();
			// g.printGraph();
			print_prims(g, total);
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 259679;
	 * */
	private void print_prims(MSTGraph<Integer> g, long total) {
		System.out.println(total / 2 - g.MST_PRIMs(new Vertex<Integer>(1, 1)));
	}
}
