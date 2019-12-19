package lab07;

public class Driver {
	public static void printFor(IntIterator itr, int limit){
		int counter=0;
		for(int i : itr.toIterable()){
			System.out.print(i);
			counter++;
			
			if(counter == limit) break;
			else System.out.print(", ");
		}
		System.out.println();
	}
	public static void printZip(ZipIterator<Character, Integer> zipIt, int limit){
		int counter=0;
		for(Pair<Character , Integer> i : zipIt.toIterable()){
			System.out.print(i);
			counter++;
			if (counter==limit) break;
			else System.out.print(", ");
		}
		System.out.println();
	}
	public static <K, V> void main(String[] args) {
		int[] arr1 = {1,2,3,4,5};
		
		Character[] arrK={'a','b','c','d','e'};
		Integer[] arrV={1,2,3,4,5};
		
		
		
		RepeatIterator ri = new RepeatIterator(8);
		printFor(ri,10);
		
		CyclicIterator ci = new CyclicIterator(arr1);
		printFor(ci,4);
		
		CountIterator countI = new CountIterator(1,2,8);
		printFor(countI,3);
		
		ZipIterator<Character, Integer> zip1= new ZipIterator<>(arrK,arrV);
		printZip(zip1,5);
		

	}

}
