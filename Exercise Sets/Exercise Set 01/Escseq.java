import java.util.Scanner;

public class Escseq {
    
    public static void main(String[] args){
        int value = 7;
        int product;
        for(int i = 1; i <= 5; i++){
            
            if (i%2==0){
                product = i*value;
                System.out.println("\t" + product);
            } else{
                product = i*value;
                System.out.println(product);
            }
        }
    }
}
