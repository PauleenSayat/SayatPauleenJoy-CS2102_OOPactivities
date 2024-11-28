import java.util.Scanner;

public class Tempconvert {
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Celsius value: ");
        double Celsius = input.nextFloat();
        double Fahrenheit = Celsius *(9/5) + 32;
        
        System.out.println(Celsius + " Celsius is " + Fahrenheit +" Fahrenheit.");
        input.close();
    }
}
