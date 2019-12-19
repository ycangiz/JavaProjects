package lab07;

import java.util.Iterator;

public interface IntIterator extends Iterator<Integer> {
    
	boolean hasNext();
    Integer next();

    /**
     * Wraps this IntIterator in an Iterable so that it may be used in a
     * for-each loop.
     * @return an Iterable iterating through this IntIterator
     */
    default Iterable<Integer> toIterable() {
        return () -> this;
    }
   
    
}