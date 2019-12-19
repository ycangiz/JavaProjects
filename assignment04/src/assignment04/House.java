package assignment04;

import java.util.ArrayList;
public class House {
	private static ArrayList<Space> spaces = new ArrayList<Space>(3);
	private static int nextIndex=0;
	
	public static String toString(ArrayList<Space> spaces) {
	    String result = "+";
	    for (int i = 0; i < spaces.size(); i++) {
	        result += " " + spaces.get(i);
	    }
	    return result;
	}
	public House(ArrayList<Space> aSpaces){
		spaces=aSpaces;
	}
	public static void add1(Space sp){
		if (sp == null)  throw new IllegalArgumentException("Rooms cannot be null"); 
		spaces.add(nextIndex,sp);
		nextIndex++;
		if(nextIndex==spaces.size()-1){
			spaces = new ArrayList<Space>(spaces.size()*2);
		}
	}
	public double totalArea(){
		double sum=0.0;
		for(int i=0; i<spaces.size(); i++){
			if(spaces.get(i)!=null && spaces.get(i).getArea()!=0.0){
				sum+=spaces.get(i).getArea();
			}
		}
		return sum;
	}
	public static House biggestFloorSpace(ArrayList<House> houses){
		double maxArea= Integer.MIN_VALUE;
		int retval=0;
		if(houses!=null && houses.size()>0){
			for(int i=0; i<houses.size(); i++){
				if(houses.get(i)!=null && houses.get(i).totalArea()>0.0){
					if(houses.get(i).totalArea()>maxArea){
						maxArea=houses.get(i).totalArea();
						retval=i;
					}
				}
			}
		}
		return houses.get(retval);
	}
}
