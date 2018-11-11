package development;

import java.util.Scanner;

public class Question2 {
	
    public int primes_int(int input, boolean print_check) {
		
		if(input == 0) {
			input = Integer.MAX_VALUE;
		}
		
		if(print_check) {
			System.out.println(2);
		}
		
    	int output = 1,count = 1;
    	boolean check_prime;
    	
    	while(count < input && output < Integer.MAX_VALUE) {
    		check_prime = true;
    		output+=2;
    		count++;
    		for(int i = (int)Math.sqrt(output);i>2;i--) {
    			if(output % i == 0) {
    				check_prime = false;
    				count--;
    				break;
    			}
    		}
    		if(check_prime & print_check) {
    			System.out.println(output);
    		}
    	}
        return output;
    }
	
	public long primes_long(long input, boolean print_check) {
		
		if(input == 0) {
			input = Long.MAX_VALUE;
		}
		
		if(print_check) {
			System.out.println(2);
		}
		
    	long output = 1,count = 1;
    	boolean check_prime;
    	
    	while(count < input && output < Long.MAX_VALUE) {
    		check_prime = true;
    		output+=2;
    		count++;
    		for(int i = (int)Math.sqrt(output);i>2;i--) {
    			if(output % i == 0) {
    				check_prime = false;
    				count--;
    				break;
    			}
    		}
    		if(check_prime & print_check) {
    			System.out.println(output);
    		}
    	}
        return output;
    }
    
    public double time_int() {
    	int integer = Integer.MIN_VALUE;
    	
    	long startTime= System.nanoTime();
    	do {
    		integer++;
    	}while(integer<Integer.MAX_VALUE);
    	long endTime = System.nanoTime();
    	
    	long timeElapsed = endTime-startTime;
    	double timeElapsedInSeconds = (double)timeElapsed/1_000_000_000.0;
        return timeElapsedInSeconds;
    }

    public double time_long() {   
    	int integer = Integer.MIN_VALUE;
    	
    	long startTime= System.nanoTime();
    	do {
    		integer++;
    	}while(integer<Integer.MAX_VALUE);
    	long endTime = System.nanoTime();
    	
    	long timeElapsed = endTime-startTime;
    	double timeElapsedInSeconds = (double)timeElapsed/1_000_000_000.0;
    	double longToIntFactor = Math.pow(2.0,32.0);
    	double estimatedTimeTaken = longToIntFactor * timeElapsedInSeconds;
        return estimatedTimeTaken;
    }
    
    public static void printarray(int[] array_to_print) {
    	int characters_printed = 0;
    	for (int element:array_to_print) {
    		if (characters_printed>100) {
    			System.out.println(" ");
    			characters_printed = 0;
    		}
    		System.out.print(element);
    		characters_printed += String.valueOf(element).length()+1;
    		System.out.print(" ");
    	}
    }
    
  
    public static void main(String []args) { 
    	
    	Question2 q2 = new Question2();
    	Scanner scanner = new Scanner (System.in);
    	
    	int th1 = 100;
    	int prime1 = q2.primes_int(th1,false);
    	System.out.println(th1+"-th integer prime number: "+prime1+"\n");
    	
    	long th2 = 10000;
    	long prime2 = q2.primes_long(th2,false);
    	System.out.println(th2+"-th long integer prime number: "+prime2+"\n");
    	
    	System.out.println("Time taken to count (increment with unit step) from smallest to largest integer:");
    	double integerCountingTime = q2.time_int();
    	System.out.println(integerCountingTime+" seconds\n");
    	
    	System.out.println("Estimated time taken to count (increment with unit step) from smallest to largest long integer:");
    	double longCountingTime = q2.time_long();
    	int longCountingDays = (int)(longCountingTime / (24.0*60.0*60.0));
    	longCountingTime -= (double)longCountingDays*24.0*60.0*60.0; 
    	System.out.println(String.format("%d days", longCountingDays));
    	int longCountingHours = (int)(longCountingTime / (60.0*60.0));
    	longCountingTime -= (double)longCountingHours*60.0*60.0; 
    	System.out.println(String.format("%d hours", longCountingHours));
    	int longCountingMinutes = (int)(longCountingTime / 60.0);
    	longCountingTime -= (double)longCountingMinutes*60.0; 
    	System.out.println(String.format("%d minutes", longCountingMinutes));
    	int longCountingSeconds = (int)longCountingTime;
    	System.out.println(String.format("%d seconds", longCountingSeconds));
    	
    	System.out.println("\nWARNING: This will be a looo..ooong ride.");
    	System.out.print("Do you want to take a look at all the integer prime numbers?[y/n] ");
    	String yn1 = scanner.next();
    	if(yn1.equals("y")) {
    		q2.primes_int(0,true);
    	}
    	
    	System.out.println("\nWARNING: This will be a looo..ooong ride.");
    	System.out.print("Do you want to take a look at all the long integer prime numbers?[y/n] ");
    	String yn2 = scanner.next();
    	if(yn2.equals("y")) {
    		q2.primes_long(0,true);
    	}
    	scanner.close();
    }
}
