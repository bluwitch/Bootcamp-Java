public class Fizz {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.println(fizzBuzz(i));
        }
    }

    public static String fizzBuzz(int numero) {
            if (numero % 3 == 0 && numero % 5 == 0) {
                return "FizzBuzz";
            } else if (numero % 3 == 0) {
                return "Fizz";
            } else if (numero % 5 == 0) {
                return "Buzz";
            } else {
            return String.valueOf(numero);
        }
    }
}