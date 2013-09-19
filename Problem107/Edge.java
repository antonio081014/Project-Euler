/**
 * 
 */

/**
 * @author antonio081014
 * @time Aug 14, 2013, 10:18:39 PM
 */
public class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {

	private Vertex<T> vertexSRC;
	private Vertex<T> vertexDST;
	private Integer weight;

	public Edge(Vertex<T> vSRc, Vertex<T> vDST) {
		this.vertexSRC = vSRc;
		this.vertexDST = vDST;
	}

	public Edge(Vertex<T> vertex1, Vertex<T> vertex2, Integer weight) {
		this(vertex1, vertex2);
		this.weight = weight;
	}

	/**
	 * @return the vertexSRC
	 */
	public Vertex<T> getVertexSRC() {
		return vertexSRC;
	}

	/**
	 * @param vertexSRC
	 *            the vertexSRC to set
	 */
	public void setVertexSRC(Vertex<T> vertexSRC) {
		this.vertexSRC = vertexSRC;
	}

	/**
	 * @return the vertexDST
	 */
	public Vertex<T> getVertexDST() {
		return vertexDST;
	}

	/**
	 * @param vertexDST
	 *            the vertexDST to set
	 */
	public void setVertexDST(Vertex<T> vertexDST) {
		this.vertexDST = vertexDST;
	}

	/**
	 * @return the weight
	 */
	public Integer getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((vertexDST == null) ? 0 : vertexDST.hashCode());
		result = prime * result
				+ ((vertexSRC == null) ? 0 : vertexSRC.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Edge)) {
			return false;
		}
		Edge other = (Edge) obj;
		if (vertexDST == null) {
			if (other.vertexDST != null) {
				return false;
			}
		} else if (!vertexDST.equals(other.vertexDST)) {
			return false;
		}
		if (vertexSRC == null) {
			if (other.vertexSRC != null) {
				return false;
			}
		} else if (!vertexSRC.equals(other.vertexSRC)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "E{" + vertexSRC.getValue() + ", " + vertexDST.getValue() + "}";
	}

	public int compareTo(Edge<T> e) {
		if (vertexSRC.compareTo(e.getVertexSRC()) == 0)
			return vertexDST.compareTo(e.getVertexDST());
		return vertexSRC.compareTo(e.getVertexSRC());
	}
}
