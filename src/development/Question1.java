package development;

import java.util.Scanner;

public class Question1 {
	
    public int user_input(int n) {
    	
        if(n == 0) {
        	Scanner reader = new Scanner(System.in);
        	System.out.print("Enter an integer number: ");
        	n = reader.nextInt();
	    }
        
        if(n>100 | n<1) {
        	throw new NumberFormatException("Cannot accept values outside the desired range (1 to 100).");
        }
        
    	return n;
    }	
    
    public int[] list_integers(int[] list,int n) {

    	if(list == null) {
    		list = new int[n];
    		Scanner reader = new Scanner(System.in);
    		System.out.print("Enter a list of integer numbers: \n");
    		for(int i=0; i<n; i++) {
            	list[i] = reader.nextInt();
    	    }
    	}
    	
        return list;
    }
    
    public int summation(int[] list) {
    	int output = 0;
    	for(int i : list) {
    		  output = i + output;
    	} 
    	return output;
    }
    
    public int product(int[] list) {
    	int output = 1;
    	for(int i : list) {
    		  output = i*output;
    	} 
    	return output;
    }
   
    public int smallest_int(int[] list) {
    	int output = 100;
    	for(int i : list) {
    		if (i < output) {
    			output = i;
    		}
    	}
    	return output;
    }  
    
    public int largest_int(int[] list) {
    	int output = 1;
    	for(int i : list) {
    		if (i > output) {
    			output = i;
    		}
    	}
    	return output;
    }
    
    public float average(int[] list) {
    	int sum = 0;
    	for(int i : list) {
    		  sum = i + sum;
    	}
    	
    	int len = list.length;
    	float output = sum/len;
    	return output;
    }
   
    public float variance(int[] list) {
    	int sum = 0;
    	for(int i : list) {
    		  sum = i + sum;
    	}
    	
    	int len = list.length;
    	float sumSquares = 0;
    	for(int i : list) {
    		sumSquares = (float) Math.pow(i-sum/len,2) + sumSquares;
    	}
    	
    	float output = sumSquares/len;
    	return output;
    }
    
    public static void main(String []args) {   
    	Question1 q1 = new Question1();
    	
    	int n,sum,prod,small,big;
    	float ave,var;
    	int[] list;
    	
    	n = q1.user_input(0);
    	
    	list = new int[n];
    	list = q1.list_integers(null, n);
    	
    	sum = q1.summation(list);
    	prod = q1.product(list);
    	small = q1.smallest_int(list);
    	big = q1.largest_int(list);
    	ave = q1.average(list);
    	var = q1.variance(list);
    	
    	System.out.println("Summation: "+sum);
    	System.out.println("Product: "+prod);
    	System.out.println("Average: "+ave);
    	System.out.println("Variance: "+var);
    	System.out.println("Smallest value: "+small);
    	System.out.println("Biggest value: "+big);
    }
}
