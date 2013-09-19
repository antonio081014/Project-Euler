/**
 * 
 */
import java.util.List;
import java.util.Set;

/**
 * @author antonio081014
 * @time Aug 14, 2013, 11:03:22 PM
 */
public interface Graph<T extends Comparable<T>> {
	public void addVertex(Vertex<T> vertex);

	public Vertex<T> getVertex(Vertex<T> vertex);

	public void removeVertex(Vertex<T> vertex);

	public void addEdge(Vertex<T> source, Vertex<T> destination, Integer cost);

	public boolean isEdge(Vertex<T> source, Vertex<T> destination);

	public void removeEdge(Vertex<T> source, Vertex<T> destination);

	public Set<Vertex<T>> getVertices();

	public List<Edge<T>> getEdges();

	public int numVertices();
}
