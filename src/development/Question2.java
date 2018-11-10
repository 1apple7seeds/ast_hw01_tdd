package development;

import java.util.ArrayList;

public class Question2 {
	
    public int[] prime_numbers(int integer_limit) {
    	ArrayList<Integer> primeNumbersList = new ArrayList<Integer>();
    	primeNumbersList.add(2);
    	for (int integer=3; integer<integer_limit; integer+=2) {
    		boolean isPrime = true;
    		for (int prime_number:primeNumbersList) {
    			if (integer % prime_number == 0) {
    				isPrime = false;
    				break;
    			}
    		}
    		if (isPrime == true) {
    			primeNumbersList.add(integer);
			}
    	}
    	int[] primeNumberArray = new int[primeNumbersList.size()];
    	for (int cnt=0; cnt<primeNumbersList.size(); cnt++) {
    		primeNumberArray[cnt] = primeNumbersList.get(cnt);
    	}
        return primeNumberArray;
    }
    
    public float time_int() {
    	int integer = 1;
    	while(integer>0) {
    		integer++;
		}
    	int largestInteger = integer-1;
    	long startTime= System.nanoTime();
    	while(integer != largestInteger) {
    		integer++;
    	}
    	long endTime = System.nanoTime();
    	float timeElapsed = endTime-startTime;
    	float timeElapsedInSeconds = timeElapsed/1000000000;
        return timeElapsedInSeconds;
    }

    public float time_long() {   
    	int integer = 1;
    	while(integer>0) {
    		integer++;
		}
    	int largestInteger = integer-1;
    	long startTime= System.nanoTime();
    	while(integer != largestInteger) {
    		integer++;
    	}
    	long endTime = System.nanoTime();
    	float timeElapsed = endTime-startTime;
    	float timeElapsedInSeconds = timeElapsed/1000000000;
    	float longToIntFactor = (float) Math.pow(2,32);
    	float estimatedTimeTaken = longToIntFactor * timeElapsedInSeconds;
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
    	int integer_limit = 1000;
    	int[] prime_numbers = new Question2().prime_numbers(integer_limit);
    	System.out.println("Prime numbers from 0 to " + String.valueOf(integer_limit) + ":");
    	printarray(prime_numbers);
    	System.out.print("\n\n");
    	
    	System.out.println("Time taken to count (increment with unit step) from smallest to largest integer:");
    	float integerCountingTime = new Question2().time_int();
    	System.out.println(String.format("%.4f seconds", integerCountingTime));
    	System.out.print("\n\n");
    	
    	System.out.println("Estimated time taken to count (increment with unit step) from smallest to largest long integer:");
    	float longCountingTime = new Question2().time_long();
    	int longCountingDays = (int) (longCountingTime / (24*60*60));
    	longCountingTime -= (float) longCountingDays*24*60*60; 
    	System.out.println(String.format("%d days", longCountingDays));
    	int longCountingHours = (int) (longCountingTime / (60*60));
    	longCountingTime -= (float) longCountingHours*60*60; 
    	System.out.println(String.format("%d hours", longCountingHours));
    	int longCountingMinutes = (int) (longCountingTime / (60));
    	longCountingTime -= (float) longCountingMinutes*60; 
    	System.out.println(String.format("%d minutes", longCountingMinutes));
    	int longCountingSeconds = (int) (longCountingTime);
    	System.out.println(String.format("%d seconds", longCountingSeconds));    	
    }
}
