import java.util.Arrays;
import java.util.ArrayList;

public class BasicJava {
    public static void contador() {
        for (int i = 0; i <= 255; i++) {
            System.out.println(i);
        }
    }

    public static void impares() {
        for (int i = 0; i <= 255; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public static void suma() {
        int suma = 0;
        for (int i = 0; i <= 255; i++) {
            suma += i;
            System.out.println("Nuevo numero: " + i + " Suma: " + suma);
        }
    }

    public static void recorrerArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void maximoArray(int[] array) {
        int maximo = Arrays.stream(array).max().getAsInt();
        System.out.println("Máximo del array: " + maximo);
    }

    public static void promedioArray(int[] array) {
        int promedio = 0;
        for (int i = 0; i < array.length; i++) {
            promedio += array[i];
        }
        double promedioDec = (double) promedio / array.length;
        System.out.println(promedioDec);
    }

    public static void arrayImpar() {
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i = 0; i <= 255; i++) {
            if (i % 2 != 0) {
                y.add(i);
            }
        }
        System.out.println(y);
    }

    public static void mayorQueY(int[] array, int y) {
        int contador1 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > y) {
                contador1++;
            }
        }
        System.out.println(contador1);
    }

    public static void cuadrado(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] * array[i]);
        }
    }

    public static void negativoAPositivo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = 0;

            }
            System.out.println(array[i]);
        }
    }

    public static void minMaxPro(int[] array) {
        int max = array[0];
        int min = array[0];
        int pro = 0;
        for (int i = 0; i < array.length; i++) {
            pro += array[i];
            if (array[i] > max) {
                max = array[i];
            } else if (array[i] < min) {
                min = array[i];
            }
        }
        double proDecimal = (double) pro / array.length;
        System.out.println(proDecimal);
        System.out.println(max);
        System.out.println(min);
    }

    public static void swapearValores(int[] array){ /*me llevó 1 hora hacer este */
        int ultimo = array[array.length -1];
        for (int i = 0; i < array.length -1; i++){
            array[i] = array[i + 1];
        }
        array[array.length - 1] = ultimo;
        System.out.println(Arrays.toString(array));
    }

}