import java.util.Scanner;

class FactorialClass {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Factorial f = new Factorial();

        System.out.println("Iterative : " + f.iterativeFactorial(s.nextInt()));
        System.out.println("Recursive : " + f.recursiveFactorial(s.nextInt()));

        s.close();
    }
}

class Factorial {
    public int recursiveFactorial(int num) {
        if (num == 1)
            return 1;
        else
            return num + recursiveFactorial(num - 1);
    }

    public int iterativeFactorial(int num) {
        int fact = 0;

        for (int i = num; i > 0; i--) {
            fact += i;
        }
        return fact;
    }
}