import java.util.Collection;
import java.util.LinkedList;

/**
 * 
 */

/**
 * @author antonio081014
 * @time Aug 14, 2013, 10:00:33 PM
 */
public class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>> {
	private T value;
	private int label;

	protected Collection<Edge<T>> edges = new LinkedList<Edge<T>>();

	public Vertex(T value, int seq) {
		this.value = value;
		this.label = seq;
	}

	public T getValue() {
		return value;
	}

	public Collection<Edge<T>> getEdges() {
		return edges;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Vertex)) {
			return false;
		}
		Vertex<T> other = (Vertex<T>) obj;
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public String toString() {
		return "V{" + value + ", " + label + "}";
	}

	/**
	 * @return the label
	 */
	public int getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(int label) {
		this.label = label;
	}

	public int compareTo(Vertex<T> a) {
		return a.getLabel() - this.label;
	}
}
