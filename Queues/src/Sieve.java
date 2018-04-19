import java.util.Scanner;

public class Sieve {

    public static void main(String[] args) {

        int n,count;
        Scanner keyboard = new Scanner( System.in);

        System.out.print( "I can generate all prime numbers ");
        System.out.println( "between 2 and an integer n > 2 ...");
        for( count = 1 ; count <= 5 ; count++) {
            System.out.println( "Enter a positive integer n: ");
            n = keyboard.nextInt();
            generatePrimes( n);
        }

        keyboard.close();
        return;
    }

    public static void generatePrimes( int n) {

        double sqrt = Math.sqrt( n);
        int number, prime, count, size;
        LinkedQueue<Integer> primes = new LinkedQueue<Integer>();
        LinkedQueue<Integer> numbers = new LinkedQueue<Integer>();


        System.out.println( "Prime integers between 2 and " + n + " are: " + primes);
        return;
    }
}