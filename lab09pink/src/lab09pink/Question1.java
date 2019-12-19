package lab09pink;
import java.util.ArrayList;
public class Question1 {
	private int n;
	
	public Question1(int n1){
		n=Math.abs(n1);
	}
	
	public int smallestNumber(){
		if(n==0) return 0;
		if(n==1) return 1;
		else{
			for(int i=2; i<=n; i++){
				if(n%i==0) return i;
			}
		}
		return 0;
	}
	
	public ArrayList<Integer> factorize(){
		int tempNum=n;
		ArrayList<Integer> tempArray = new ArrayList<Integer>();
		
		if(n==0) return tempArray;
		if(n==1) return tempArray;
		
		while(n>1){
			tempArray.add(smallestNumber());
			n/=(smallestNumber());
		}
		n=tempNum;
		return tempArray;
	}
	
	@Override
	public String toString(){
		if(n==0) return 0+" = "+0;
		if(n==1) return 1+" = "+1;
		
		String s;
		s=factorize().toString().replace(","," x");
		s=s.replace("[", "");
		s=s.replace("]", "");
		
		return n+" = "+s;
	}

}
