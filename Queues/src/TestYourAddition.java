import java.util.Scanner;

public class TestYourAddition {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        LinkedQueue<AdditionProblem> wrongAnswers = new LinkedQueue<>();
        AdditionProblem problem;
        int numOfQuestions, rangeOfNumbers, incorrect = 0, answer;

        System.out.print("Enter the number of desired questions: ");
        numOfQuestions = keyboard.nextInt();

        System.out.print("Enter the desired range of numbers: ");
        rangeOfNumbers = keyboard.nextInt();
        System.out.println("---------------------------------------------");

        for (int i = 0; i < numOfQuestions; i++) {
            problem = new AdditionProblem(rangeOfNumbers);
            incorrect = 0;

            while (incorrect != 3) {
                System.out.print(problem.ToString());
                System.out.print("\t\tYour Answer: ");
                answer = keyboard.nextInt();

                if (answer == problem.solveForAnswer()) {
                    System.out.println("You got it correct!");
                    System.out.println();
                    break;
                } else {
                    System.out.println("You got it wrong, but you have " +
                            "another try!");
                    System.out.println();
                    incorrect++;
                }

                if (incorrect == 3) {
                    wrongAnswers.enqueue(problem);
                    System.out.println("Problem added to queue for later " +
                            "practice.");
                    System.out.println("Don't worry, you'll get another " +
                            "crack at this problem!");
                    System.out.println();
                }
            }
        }

        System.out.println("Now for the problems you struggled with!");
        System.out.println("Good luck!");
        System.out.println();

        while (!wrongAnswers.isEmpty()) {
            problem = wrongAnswers.dequeue();
            incorrect = 0;

            while (incorrect != 3) {
                System.out.print(problem.ToString());
                System.out.print("\t\tYour Answer: ");
                answer = keyboard.nextInt();

                if (answer == problem.solveForAnswer()) {
                    System.out.println("You got it correct!");
                    System.out.println();
                    break;
                } else {
                    System.out.println("You got it wrong, but you have " +
                            "another try!");
                    System.out.println();
                    incorrect++;
                }

                if (incorrect == 3) {
                    System.out.println("That's okay, you need to " +
                            "work on this problem");
                    System.out.println("The correct answer is "
                            + problem.solveForAnswer());
                    System.out.println();
                }
            }
        }

        System.out.println("This is the end of your practice.\n" +
                "Have a nice day!");
        keyboard.close();
    }
}