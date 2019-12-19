package assignment03;
import java.util.Arrays;
public class House {
	private static Space[] spaces = new Space[3];
	private static int nextIndex=0;
	public String toString(){
		return Arrays.toString(spaces);
	}
	public House(Space[] aSpaces){
		spaces=aSpaces;
	}
	public static void add(Space sp){
		spaces[nextIndex]=sp;
		nextIndex++;
		if(nextIndex==spaces.length){
			spaces = Arrays.copyOf(spaces, spaces.length*2);
		}
	}
	public double totalArea(){
		double sum=0.0;
		for(int i=0; i<spaces.length; i++){
			if(spaces[i]!=null && spaces[i].getArea()!=0.0){
				sum+=spaces[i].getArea();
			}
		}
		return sum;
	}
	public static House biggestFloorSpace(House[] houses){
		double maxArea= Integer.MIN_VALUE;
		int retval=0;
		if(houses!=null && houses.length>0){
			for(int i=0; i<houses.length; i++){
				if(houses[i]!=null && houses[i].totalArea()>0.0){
					if(houses[i].totalArea()>maxArea){
						maxArea=houses[i].totalArea();
						retval=i;
					}
				}
			}
		}
		return houses[retval];
	}
}
