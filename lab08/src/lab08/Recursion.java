package lab08;

import java.util.ArrayList;

public class Recursion {
	private static final double DELTA = 1e-6;
	
	public static int factorial(int n){
		if(n == 1 || n == 0){
            return 1;
        }
        return n * (factorial(n-1));
    }
	
	public static double squareRoot(double n){
		if(n==0) return 0;
		return squareRootHelper(n,n);
	}
	
	private static double squareRootHelper(double n, double approx){
		if(Math.abs(approx*approx-n)>DELTA){
			if(approx*approx > n) return squareRootHelper(n,(approx + n/approx) / 2);
			if(approx*approx < n) return squareRootHelper(n, (approx + n/approx) / 2);
		}
		
		return approx;
	}
	
	public static int sum(ArrayList<Integer> nums){
		return sumHelper(nums,0);
	}
	private static int sumHelper(ArrayList<Integer> nums, int index){
		if (index==nums.size()) return 0;
		
		return nums.get(index)+sumHelper(nums,index+1);
		
	}
	
	public static int sum(int[] nums){
		return sumHelper(nums,0);
	}
	
	private static int sumHelper(int[] nums, int index){
		if (index==nums.length) return 0;
		
		return nums[index]+sumHelper(nums,index+1);
	}
	
	public static int binomialCoefficient(int n, int k){
		if (k==n || k==0) return 1;
	        
	    else return binomialCoefficient(n-1,k-1) + binomialCoefficient(n-1, k);
	}
}

