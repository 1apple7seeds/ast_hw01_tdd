package development;

import java.util.Scanner;

public class Question4 {
	
    public double user_diameter_check(String user_diameter) {
    	boolean isNumeric = true;
        for (char c : user_diameter.toCharArray()) {
            if (!Character.isDigit(c) && c!=".".charAt(0)) {isNumeric=false; break;}
        }
        if (isNumeric) {
    		return Float.valueOf(user_diameter);
        } else {
        	System.out.println("The input must be a positive number!");
        	System.out.print("\n"); 
        }
        return -1;
    }
    
    public int user_precision_check(String user_precision) {
    	boolean isNumeric = true;
        for (char c : user_precision.toCharArray()) {
            if (!Character.isDigit(c)) {isNumeric=false; break;}
        }
        if (isNumeric) {
    		if (Integer.valueOf(user_precision)>15) {
    			return 15;
			} else {
				return Integer.valueOf(user_precision);
			}
        } else {
        	System.out.println("The input must be a positive integer!");
        	System.out.print("\n"); 
        }
        return -1;
    }
    
    public double pi_approx(int precision) {
    	String piString = "3.1415926535897932";
    	double pi_approx = Double.valueOf(piString.substring(0,precision+2));
    	return pi_approx;
    }

    public double circumference(double diameter, double pi) {   
    	double circumference = diameter * pi;
        return circumference;
    }
    
    public double area(double diameter, double pi) {
    	double area = pi * diameter * diameter / 4;
        return area;
    }

    public double[] percentage_increase_circumference(double diameter, int precision) {
    	double[] circumferenceList = new double[precision+1];
    	for (int precision_cnt = 0; precision_cnt <= precision; precision_cnt++) {
    		double pi_approx = new Question4().pi_approx(precision_cnt);
    		circumferenceList[precision_cnt] = new Question4().circumference(diameter, pi_approx);
    	}
    	double[] circumferenceIncrements = new double[precision];
    	for (int cnt = 0; cnt<precision; cnt++) {
    		circumferenceIncrements[cnt] = 100*(circumferenceList[cnt+1]-circumferenceList[cnt])/circumferenceList[cnt];
    	}
    	return circumferenceIncrements;
    }  
    
    public static void printarray(double[] array_to_print) {
    	int characters_printed = 0;
    	for (double element:array_to_print) {
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
    	Scanner scanner = new Scanner (System.in);
    	String user_diameter = null;
    	double validatedDiameter = 0;    	
    	boolean validDiameterReceived = false;
    	while (!validDiameterReceived) {
    		System.out.println("Enter diameter value:");
    		user_diameter = scanner.next();
    		validatedDiameter = new Question4().user_diameter_check(user_diameter);
    		if (validatedDiameter != -1) {validDiameterReceived = true;}
    	}
    	System.out.print("\n");
		
    	String user_precision = null;
    	int validatedPrecision = 0;    	
    	boolean validatedPrecisionReceived = false;
    	while (!validatedPrecisionReceived) {
    		System.out.println("Enter precision value:");
    		user_precision = scanner.next();
    		validatedPrecision = new Question4().user_precision_check(user_precision);
    		if (validatedPrecision != -1) {validatedPrecisionReceived = true;}
    	}
    	System.out.print("\n");
    	scanner.close();

    	double pi_approx = new Question4().pi_approx(validatedPrecision);
    	System.out.print("Approximated Pi value: ");
    	System.out.println(pi_approx);
    	
		double circumference = new Question4().circumference(validatedDiameter, pi_approx);
    	System.out.print("Circumference: ");
    	System.out.println(circumference);
    	
		double area = new Question4().area(validatedDiameter, pi_approx);
    	System.out.print("Area: ");
    	System.out.println(area);
    	System.out.print("\n"); 
    	
    	double[] circumferenceIncrements = new Question4().percentage_increase_circumference(validatedDiameter, validatedPrecision);
    	System.out.println("Percentage increments of the circumference:");
    	printarray(circumferenceIncrements);
    	System.out.print("\n");    	
    }
}