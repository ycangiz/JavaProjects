package lab07;

import java.util.Iterator;

public class ZipIterator<K, V> implements Iterator<Pair<K, V>>{
	private K[] arrK;
	private V[] arrV;
	int pos;
	
	public ZipIterator(K[] arrK1, V[] arrV1){
		arrK = arrK1;
		arrV = arrV1;
	}
	public boolean hasNext(){
		if(pos>=arrK.length || pos>=arrV.length) return false;
		return true;
	}
	public Pair<K, V> next(){
		Pair<K, V> pair1 = new Pair<K, V>(arrK[pos], arrV[pos]);
		pos++;
		
		return pair1;
	}
	public Iterable<Pair<K, V>> toIterable() {
        return () -> this;
    }

}
