/**
 * 
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author antonio081014
 * @time Sep 11, 2013, 11:14:39 PM
 */
public class MSTGraph<T extends Comparable<T>> implements Graph<T> {

	private HashMap<Vertex<T>, Vertex<T>> vertexes = new HashMap<Vertex<T>, Vertex<T>>();
	private HashMap<Edge<T>, Integer> edges = new HashMap<Edge<T>, Integer>();

	/**
	 * 
	 */
	public MSTGraph() {
		vertexes = new HashMap<Vertex<T>, Vertex<T>>();
	}

	@Override
	public void addVertex(Vertex<T> vertex) {
		if (vertexes.containsKey(vertex) == false) {
			vertexes.put(vertex, vertex);
		}
	}

	@Override
	public Vertex<T> getVertex(Vertex<T> vertex) {
		return vertexes.get(vertex);
	}

	@Override
	public void removeVertex(Vertex<T> vertex) {
		vertexes.remove(vertex);
	}

	@Override
	public void addEdge(Vertex<T> source, Vertex<T> destination, Integer cost) {
		Edge<T> edge = new Edge<T>(vertexes.get(source),
				vertexes.get(destination));
		edge.setWeight(cost);
		if (edges.containsKey(edge)) {
			return;
		}
		Edge<T> edge2 = new Edge<T>(vertexes.get(destination),
				vertexes.get(source));
		edge2.setWeight(cost);
		edges.put(edge, 1);
		edges.put(edge2, 1);
		vertexes.get(source).getEdges().add(edge);
		vertexes.get(destination).getEdges().add(edge2);
	}

	@Override
	public boolean isEdge(Vertex<T> source, Vertex<T> destination) {
		return edges.containsKey(new Edge<T>(vertexes.get(source), vertexes
				.get(destination)))
				|| edges.containsKey(new Edge<T>(vertexes.get(destination),
						vertexes.get(source)));
	}

	@Override
	public void removeEdge(Vertex<T> source, Vertex<T> destination) {
		Edge<T> edge = new Edge<T>(vertexes.get(source),
				vertexes.get(destination));
		edges.remove(edge);
		vertexes.get(source).getEdges().remove(edge);

		Edge<T> edge2 = new Edge<T>(vertexes.get(destination),
				vertexes.get(source));
		if (edges.containsKey(edge2))
			edges.remove(edge2);

		vertexes.get(destination).getEdges().remove(edge2);
	}

	@Override
	public Set<Vertex<T>> getVertices() {
		return vertexes.keySet();
	}

	@Override
	public List<Edge<T>> getEdges() {
		return new ArrayList<Edge<T>>(edges.keySet());
	}

	@Override
	public int numVertices() {
		return vertexes.size();
	}

	/**
	 * Prim's MST algorithms; O(mn), m is the number of edges, n is the nubmer
	 * of vertices;
	 * */
	public long MST_PRIMs(Vertex<T> source) {
		long sum = 0;
		int N = numVertices();
		HashSet<Vertex<T>> visited = new HashSet<Vertex<T>>();
		visited.add(vertexes.get(source));
		while (visited.size() < N) {
			Edge<T> minEdge = null;
			for (Vertex<T> v : visited) {
				for (Edge<T> edge : v.getEdges()) {
					if (visited.contains(edge.getVertexDST()) == false
							&& (minEdge == null || minEdge.getWeight() > edge
									.getWeight())) {
						minEdge = edge;
					}
				}
			}
			// System.out.println(minEdge);
			sum += minEdge.getWeight();
			visited.add(minEdge.getVertexDST());
		}
		return sum;
	}

	// Assume Vertex is integer labeled.
	public void printGraph() {
		for (Vertex<T> v : getVertices()) {
			System.out.print(v.getValue());
			System.out.print("-");
			for (Edge<T> edge : v.getEdges()) {
				System.out.print(String.format("->(%d,%d)", edge.getVertexDST()
						.getValue(), edge.getWeight()));
			}
			System.out.println();
		}
	}
}
