package lab07;

public class RepeatIterator implements IntIterator{
	private int int1;

	public RepeatIterator(int int1) {
		this.int1 = int1;
	}
	
	public boolean hasNext(){
		return true;
	}
	
	public Integer next(){
		return int1;
	}

}
