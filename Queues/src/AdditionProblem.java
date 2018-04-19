public class AdditionProblem {
    private int num1, num2, upper;
    private final int lower = 0;

    public AdditionProblem(int max) {
        upper = max;

        num1 = (int) (Math.random() * (upper - lower)) + lower;
        num2 = (int) (Math.random() * (upper - lower)) + lower;
    }

    public int solveForAnswer() {
        return (num1 + num2);
    }

    public String ToString() {
        String message = (num1 + "+" + num2);
        return message;
    }
}