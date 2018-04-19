import java.util.Scanner;
import java.io.*;

public class AnnouncingDancingPartners {
    public static void main(String[] args) throws IOException {
        String dancer;
        ABQueue<String> maleQueue = new ABQueue<>(20);
        ABQueue<String> femaleQueue = new ABQueue<>(20);
        Scanner infile = new Scanner("dancers.txt");

        while (infile.hasNextLine()) {
            dancer = infile.nextLine();
            if (dancer.charAt(0) == 'F')
                femaleQueue.enqueue( dancer.substring( 2));
            else
                maleQueue.enqueue( dancer.substring( 2));
        }

        System.out.println("Announcing Dancers;");

        while (!femaleQueue.isEmpty() && !maleQueue.isEmpty()) {
            System.out.print(femaleQueue.dequeue() + "will be dancing with" +
                    maleQueue.dequeue());
        }

        System.out.println("The followng dancers need to wait for partners...");

        while (!femaleQueue.isEmpty()) {
            System.out.println(femaleQueue.dequeue());
        }
        while (!maleQueue.isEmpty()) {
            System.out.println(maleQueue.dequeue());
        }

        infile.close();
        return;
    }
}
