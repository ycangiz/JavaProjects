package assignment03;

public class Space {
	private String name;
	private double area;
	public Space(String aName, double anArea){
		name=aName;
		area=anArea;
	}
	public String getName(){
		return name;
	}
	public double getArea(){
		return area;
	}
	@Override
	public String toString() {
		return name + " of area " + area ;
	}
	
}
