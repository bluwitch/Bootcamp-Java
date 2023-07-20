import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PuzzleJava {
    public static int[] mayoresQue10() {
        int[] array = { 3, 5, 1, 2, 7, 9, 8, 13, 25, 32 };
        int suma = 0;
        ArrayList<Integer> mayores = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            suma += array[i];
            if (array[i] > 10) {
                mayores.add(array[i]);
            }
        }

        System.out.println("Suma de los elementos: " + suma);

        int[] resultado = new int[mayores.size()];
        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = mayores.get(i);
        }
        return resultado;
    }

    // -----------------------------------------

    public static void nombres() {
        List<String> listaNombres = new ArrayList<>();
        listaNombres.add("Nancy");
        listaNombres.add("Jinichi");
        listaNombres.add("Fujibayashi");
        listaNombres.add("Momochi");
        listaNombres.add("Ishikawa");
        Collections.shuffle(listaNombres);

        for (String nombre : listaNombres) {
            System.out.println(nombre);
        }

        List<String> masDe5Letras = new ArrayList<>();
        for (String nombre : listaNombres) {
            if (nombre.length() > 5) {
                masDe5Letras.add(nombre);
            }
        }
        String[] masDe5 = masDe5Letras.toArray(new String[0]);

        System.out.println("Nombres con más de 5 letras:");
        for (String nombre : masDe5) {
            System.out.println(nombre);
        }
    }

    // -----------------------------------------

    public static void alfabeto() {
        List<String> abc = new ArrayList<>();
        String[] arrayStr = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q",
                "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        abc.addAll(Arrays.asList(arrayStr));
        Collections.shuffle(abc);

        String ultimoElemento = abc.get(abc.size() - 1);
        System.out.println("Último elemento del alfabeto: " + ultimoElemento);

        if (ultimoElemento.equals("a") || ultimoElemento.equals("e") || ultimoElemento.equals("i")
                || ultimoElemento.equals("o") || ultimoElemento.equals("u")) {
            System.out.println("El último elemento es una vocal");
        }
    }

    // -----------------------------------------

    public static void random10() {
        int[] numerosAleatorios = numerosAleatorios();
        for (int numero : numerosAleatorios) {
            System.out.print(numero + " ");
        }
    }

    public static int[] numerosAleatorios() {
        int[] numeros = new int[10];
        Random random = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(46) + 55;
        }

        return numeros;
    }

    // -----------------------------------------

    public static void random10Ordenados() {
        int[] numerosAleatorios = numerosAleatorios2();
        Arrays.sort(numerosAleatorios);
        for (int numero : numerosAleatorios) {
            System.out.print(numero + " ");
        }
    }

    public static int[] numerosAleatorios2() {
        int[] numeros = new int[10];
        Random random = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(46) + 55;
        }

        return numeros;
    }
}