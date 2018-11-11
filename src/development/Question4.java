package development;

import java.util.Scanner;

public class Question4 {
	
    public int user_diameter_check(String user_diameter, Scanner scanner) {
    	
    	if(user_diameter == null) {
        	System.out.print("Enter an integer number: ");
        	user_diameter = scanner.next();
	    }
    	
        for (char c : user_diameter.toCharArray()) {
            if (!Character.isDigit(c)) {
            	throw new NumberFormatException("The input must be a positive integer!");
            }
        }
        if (Integer.valueOf(user_diameter)==0) {
        	throw new NumberFormatException("The input must be greater than zero (0)!");
        }else if(user_diameter.length()>String.valueOf(Integer.MAX_VALUE).length()) {
        	throw new NumberFormatException("The input must be greater than zero (0), but don't exaggerate!");
        }
    	return Integer.valueOf(user_diameter);
    }
    
    public int user_precision_check(String user_precision, Scanner scanner) {
    	
    	if(user_precision == null) {
    		System.out.print("Enter precision: ");
        	user_precision = scanner.next();
	    }
    	
    	for (char c : user_precision.toCharArray()) {
            if (!Character.isDigit(c)) {
            	throw new NumberFormatException("The input must be zero (0) or a positive integer!");
            }
        }
    	if(user_precision.length()>String.valueOf(Integer.MAX_VALUE).length()) {
        	throw new NumberFormatException("The input must be zero (0) or larger, but don't exaggerate!");
        }
		if (Integer.valueOf(user_precision)>15) {
			return 15;
		} else {
			return Integer.valueOf(user_precision);
		}
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
    
    public double[] percentage_increase_area(double diameter, int precision) {
    	double[] areaList = new double[precision+1];
    	for (int precision_cnt = 0; precision_cnt <= precision; precision_cnt++) {
    		double pi_approx = new Question4().pi_approx(precision_cnt);
    		areaList[precision_cnt] = new Question4().area(diameter, pi_approx);
    	}
    	double[] areaIncrements = new double[precision];
    	for (int cnt = 0; cnt<precision; cnt++) {
    		areaIncrements[cnt] = 100*(areaList[cnt+1]-areaList[cnt])/areaList[cnt];
    	}
    	return areaIncrements;
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
    	Question4 q4 = new Question4();
    	Scanner scanner = new Scanner (System.in);
    	
		int validatedDiameter = q4.user_diameter_check(null,scanner);
		int validatedPrecision = q4.user_precision_check(null,scanner);
		
    	scanner.close();
    	System.out.print("\n\n");

    	double pi_approx = q4.pi_approx(validatedPrecision);
    	System.out.print("Approximated Pi value: ");
    	System.out.println(pi_approx);
    	
		double circumference = q4.circumference(validatedDiameter, pi_approx);
    	System.out.print("Circumference: ");
    	System.out.println(circumference);
    	
		double area = q4.area(validatedDiameter, pi_approx);
    	System.out.print("Area: ");
    	System.out.println(area);
    	System.out.print("\n"); 
    	
    	double[] circumferenceIncrements = q4.percentage_increase_circumference(validatedDiameter, validatedPrecision);
    	System.out.println("Percentage increments of the circumference:");
    	printarray(circumferenceIncrements);
    	System.out.print("\n");    	
    	
    	double[] areaIncrements = q4.percentage_increase_area(validatedDiameter, validatedPrecision);
    	System.out.println("\nPercentage increments of the area:");
    	printarray(areaIncrements);
    	System.out.print("\n");
    }
}