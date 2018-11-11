package development;

public class Question3 {
	
    public int[] func_2n() {
    	int[] output = new int[101];
    	for(int i=0; i<101; i++) {
    		output[i] = 2*i;
    	}
        return output;
    }		

    public int[] func_sqrt() {
    	int[] output = new int[101];
    	for(int i=0; i<101; i++) {
    		output[i] = (int) Math.sqrt(i);
    	}
        return output;
    }    
    
    public int[] func_cubed() {
    	int[] output = new int[101];
    	for(int i=0; i<101; i++) {
    		output[i] = (int) Math.pow(i,3);
    	}
        return output;
    }
    
    public String[] func_2_pow_1_over_n() {
    	String[] output = new String[101];
    	output[0] = "Inf";
    	for(int i=1; i<101; i++) {
    		output[i] = String.valueOf((int) Math.pow(2,1/i));
    	}
        return output;
    }
    
    public String[] func_e_pow_n() {
    	int i = 0;
    	long number;
    	String[] output = new String[101];
    	
    	do {
    		output[i] = String.valueOf((int) Math.exp(i));
    		i++;
    		number = (long) Math.exp(i);
    	}while(number<Integer.MAX_VALUE);
    	
    	do {
    		output[i] = "e^" + i;
    		i++;
    	}while(i<101);

        return output;
    }
    
    public String[] func_10_pow_n() {
    	int i = 0;
    	long number;
    	String[] output = new String[101];
    	
    	do {
    		output[i] = String.valueOf((int) Math.pow(10,i));
    		i++;
    		number = (long) Math.pow(10,i);
    	}while(number<Integer.MAX_VALUE);
    	
    	do {
    		output[i] = "10...0 (" + i +" zeros)";
    		i++;
    	}while(i<101);

        return output;
    }
    
    public static void main(String []args) {
    	Question3 q3 = new Question3();
    	
    	int[] f1 = new int[101];
    	int[] f2 = new int[101];
    	int[] f3 = new int[101];
    	f1 = q3.func_2n();
    	f2 = q3.func_sqrt();
    	f3 = q3.func_cubed();
    	
    	String[] f4 = new String[101];
    	String[] f5 = new String[101];
    	String[] f6 = new String[101];
    	f4 = q3.func_2_pow_1_over_n();
    	f5 = q3.func_e_pow_n();
    	f6 = q3.func_10_pow_n();
    	
    	System.out.format("|%5s|%25s|%25s|%25s|%25s|%25s|%25s|\n", "n", "f1(n) = 2n", "f2(n) = sqrt(n)", "f3(n) = n^3", "f4(n) = 2^(1/n)", "f5(n) = e^n", "f6(n) = 10^n");
    	for(int i=0; i<101; i++) {
    		System.out.format("|%5d|%25d|%25d|%25d|%25s|%25s|%25s|\n", i, f1[i], f2[i], f3[i], f4[i], f5[i], f6[i]);
    	}
    }
    
}
