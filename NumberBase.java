import java.util.Scanner;
public class NumberBase{

    public static final String digits = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static void main(String args[]){
    	System.out.println("Enter the number you want converted");
    	Scanner s = new Scanner(System.in);
    	String input = s.nextLine();
    	System.out.println("Enter the base the number is currently in");
    	int base_in = s.nextInt();
    	System.out.println("Enter the base you want the number converted to");
    	int base_out = s.nextInt();
        System.out.println("The answer is: " + convert(input, base_in, base_out)); 
    }
    public static String convert(String input, int base_in, int base_out){
    	int flag = 0;
    	for(int i = 0; i != input.length(); i++){
    		char c = input.charAt(i);
    		for(int j = base_in; j > 0; j--){
    			if(c != digits.charAt(j-1)){
    				flag++;
    			}
    			}
    		}
    	if(flag > (input.length()*base_in) - input.length()){
    		throw new IllegalArgumentException();
    	}
    	if(input == "0"){
    		return "0";
    	}
    	String decimal = toDecimal(input,base_in);
        String answer = toOther(decimal,base_out);
        return answer;
    }
    public static String toDecimal(String input, int base_in){
        int total = 0;
        int count = input.length();
        for(int i = 0 ; i != input.length(); i++){
        	char c = input.charAt(i);
        	count--;
            total += digits.indexOf(c)*Math.pow(base_in,count);
        }
        return String.valueOf(total);
    }
    public static String toOther(String input, int base_out){
        String total = "";
        int current = 0;
        while(Integer.valueOf(input) > 0){
            current = Integer.valueOf(input) % base_out;
            total = digits.charAt(current) + total;
            input = String.valueOf(Integer.valueOf(input)/base_out);
        }
    return total;
    }
}
