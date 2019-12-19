package assignment07;

public class Price {
	private long dollars;
	private int cents;
	double temp;
	public Price(long aDollars, int aCents){
		if(aDollars<0 || aCents<0 || aCents>100) throw new IllegalArgumentException("You shouldn't enter negative value or cents>100");
		dollars = aDollars;
		cents = aCents;
	}
	public void changeUp(double percent){
		if(percent<0) throw new IllegalArgumentException("Percentage of change must be positive");
		cents+=dollars*100;
		cents+= ((double)cents/100*percent);
		while(cents>100){
			dollars+=cents/100;
		}
	}
	public void changeDown(double percent){
		if(percent<0) throw new IllegalArgumentException("Percentage of change must be positive");
		cents+=dollars*100;
		cents-=((double) cents/100*percent);
		while(cents>100){
			dollars+=cents/100;
		}
	}
	@Override
	public String toString(){
		return "$" + dollars + "." + cents;
	}

}
