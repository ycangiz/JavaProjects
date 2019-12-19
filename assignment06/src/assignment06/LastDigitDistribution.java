package assignment06;

/**
This class analyzes the distribution of the last digit of values
from a sequence.
*/
public class LastDigitDistribution{
	private int[] counters;

/**
   Constructs a distribution whose counters are set to zero.
*/
	public LastDigitDistribution(){
		counters = new int[10];
	}

/**
   Processes values from this sequence.
   @param seq the sequence from which to obtain the values
   @param valuesToProcess the number of values to process
*/
	public void process(Sequence seq, int valuesToProcess){
		for (int i = 1; i <= valuesToProcess; i++){
			int value = seq.next();
			int lastDigit = value % 10;
			counters[lastDigit]++;
		}
	}

/**
   Displays the counter values of this distribution.
*/
	public void display(){
		int[] temp = new int[10];
		for (int i = 0; i < counters.length; i++){
			System.out.println(i + ": " + counters[i]);
		}
		System.out.println("-------The histogram type----------");
		for(int i = 0; i<counters.length; i++){
			if(i!=max()) temp[i] = 40*counters[i]/counters[max()];
			else temp[i] = 40;
		}
		for(int i = 0; i<temp.length; i++){
			System.out.printf(i + ": ");
			for(int j = 0; j<temp[i]; j++){
				System.out.printf("*");
			}
			System.out.println();
		}
		for(int i = 0; i<temp.length; i++) temp[i]=0;

	}
	
	public int max(){
		int max=Integer.MIN_VALUE;
		int maxIndex=0;
		for(int i = 0; i<counters.length; i++){
			if(max<counters[i]){
				maxIndex = i;
				max=counters[i];
			}
		}
		return maxIndex;
	}
		
}

