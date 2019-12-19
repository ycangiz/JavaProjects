package assignment04;

import java.util.ArrayList;
import java.util.Arrays;

import assignment04.House;
public class HouseTest {

	public static void main(String[] args) {
		ArrayList<Space> sp1 = new ArrayList<Space>(Arrays.asList(new Space("Kitchen", 50.0),new Space("Bedroom1",30.0),
				   new Space("Bedroom2",150.0),
				   new Space("Toilet",10.0),
				   new Space("SittingRoom", 100.0)));

				   ;
		ArrayList<Space> sp2 = new ArrayList<Space>(Arrays.asList(new Space("Kitchen", 60.0),
				   	   new Space("Bedroom1",40.0),
				   	   new Space("Bedroom2",100.0),
				   	   new Space("Toilet",20.0),
				   	   new Space("SittingRoom", 75.0)));
		ArrayList<Space> sp3 = null;
		ArrayList<Space> sp4 = new ArrayList<Space>(0);
		ArrayList<Space> sp5 = new ArrayList<Space>(Arrays.asList(null,null,null));
		ArrayList<Space> sp6 = new ArrayList<Space>(Arrays.asList(null,new Space("Bedroom1",40.0),
	   	   		new Space("Bedroom2",100.0),
	   	   		new Space("SittingRoom", 75.0)));
		
		for(int i=0; i<sp1.size(); i++){
			House.add1(sp1.get(i));
		}
		System.out.println(sp1);
		
		ArrayList<House> houses1 = new ArrayList<House>(Arrays.asList(new House(sp1),new House(sp2),new House(sp3),new House(sp4),new House(sp5),new House(sp6)));
		System.out.println(houses1.get(0).totalArea());
		
		System.out.println(House.biggestFloorSpace(houses1));
	}
	
}

