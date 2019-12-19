package assignment03;
import java.util.Arrays;

import assignment03.House;
public class Test3 {

	public static void main(String[] args) {
		Space[] sp1 = {new Space("Kitchen", 50.0),
				   new Space("Bedroom1",30.0),
				   new Space("Bedroom2",150.0),
				   new Space("Toilet",10.0),
				   new Space("SittingRoom", 100.0)};
		Space[] sp2 = {new Space("Kitchen", 60.0),
				   	   new Space("Bedroom1",40.0),
				   	   new Space("Bedroom2",100.0),
				   	   new Space("Toilet",20.0),
				   	   new Space("SittingRoom", 75.0)};
		Space[] sp3 = {null};
		Space[] sp4 = {};
		Space[] sp5 = {null,null,null};
		Space[] sp6 = {null,new Space("Bedroom1",40.0),
	   	   		new Space("Bedroom2",100.0),
	   	   		new Space("SittingRoom", 75.0)};
		
		for(int i=0; i<sp1.length; i++){
			House.add(sp1[i]);
		}
		System.out.println(Arrays.toString(sp1));
		
		House[] houses1 = {new House(sp1),new House(sp2),new House(sp3),new House(sp4),new House(sp5),new House(sp6)};
		System.out.println(houses1[0].totalArea());
		
		System.out.println(House.biggestFloorSpace(houses1));
	}
	
}
