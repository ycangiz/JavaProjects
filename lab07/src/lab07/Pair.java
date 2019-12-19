package lab07;
public class Pair<K, V> {
	public final K first; // allow direct access since final
    public final V second; // allow direct access since final
    /**
     * Pair constructor with two type parameters will allow us to create Pairs containing Objects of arbitrary types.
     * @param first initializes the "public final K first" field
     * @param second initializes the "public final V second" field
     */
    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
    

    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}