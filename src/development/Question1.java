package development;

import java.util.Scanner;

public class Question1 {
	
    public int user_input(String user_n, Scanner reader) {
    	
        if(user_n == null) {
        	System.out.print("Enter an integer number: ");
        	user_n = reader.next();
	    }
        
        for (char c : user_n.toCharArray()) {
            if (!Character.isDigit(c)) {
            	throw new NumberFormatException("The input must be a positive integer between 1 and 100!");
            }
        }
        
        int n = Integer.valueOf(user_n);
        
        if(n>100 | n<1) {
        	throw new NumberFormatException("Cannot accept values outside the desired range (1 to 100).");
        }
        
    	return n;
    }	
    
    public int[] list_integers(String[] list,int n, Scanner reader) {
    	
    	if(list == null) {
    		list = new String[n];
    		
    		System.out.print("Enter a list of integer numbers: \n");
    		
    		int j;
    		for(int i=0; i<n; i++) {
            	list[i] = reader.next();
            	j = -1;
            	for (char c : list[i].toCharArray()) {
            		j++;
                    if (!Character.isDigit(c) && (c != "-".charAt(0) | j>0)) {
                    	throw new NumberFormatException("The input must be an integer!");
                    }
                }
            	if(list[i].length()>String.valueOf(Integer.MAX_VALUE).length()) {
                	throw new NumberFormatException("Don't exaggerate!");
                }
    	    }
    	}else {
    		int j;
    		for(int i=0; i<n; i++) {
            	j = -1;
            	for (char c : list[i].toCharArray()) {
            		j++;
                    if (!Character.isDigit(c) && (c != "-".charAt(0) | j>0)) {
                    	throw new NumberFormatException("The input must be an integer!");
                    }
                }
            	if(list[i].length()>String.valueOf(Integer.MAX_VALUE).length()) {
                	throw new NumberFormatException("Don't exaggerate!");
                }
    		}
    	}
    	
    	int[] input_list = new int[n];
    	for(int i=0; i<n; i++) {
    		input_list[i] = Integer.valueOf(list[i]);
    	}
        return input_list;
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
    	Scanner reader = new Scanner(System.in);
    	
    	int n,sum,prod,small,big;
    	float ave,var;
    	int[] list;
    	
    	n = q1.user_input(null,reader);
    	
    	list = new int[n];
    	list = q1.list_integers(null, n,reader);
    	reader.close();
    	
    	sum = q1.summation(list);
    	prod = q1.product(list);
    	small = q1.smallest_int(list);
    	big = q1.largest_int(list);
    	ave = q1.average(list);
    	var = q1.variance(list);
    	
    	System.out.println("\nSummation: "+sum);
    	System.out.println("Product: "+prod);
    	System.out.println("Average: "+ave);
    	System.out.println("Variance: "+var);
    	System.out.println("Smallest value: "+small);
    	System.out.println("Biggest value: "+big);
    }
}
