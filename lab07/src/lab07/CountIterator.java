package lab07;

public class CountIterator implements IntIterator {
	private int start;
	private int step;
	private int stop=-1;
	public CountIterator(int start, int step) {
		
		this.start = start;
		this.step = step;
	}
	public CountIterator(int start, int step, int stop) {
		
		this.start = start;
		this.step = step;
		this.stop = stop;
	}
	public boolean hasNext(){
		if(stop==-1) return true;
		if(start>=stop) return false;
		return true;
	}
	public Integer next(){
		
		return start+=step;
	}
	
}
