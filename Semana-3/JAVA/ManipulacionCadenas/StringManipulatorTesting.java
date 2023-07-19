public class StringManipulatorTesting {
    public static void main(String[] args) {
        String str = StringManipulator.manipulator("  hola  ", "  diablo  ");
        System.out.println(str);

        char letter = 'n';
        Integer a = StringManipulator.getIndexOrNull("Coding", letter);
        Integer b = StringManipulator.getIndexOrNull("Hola Mundo", letter);
        Integer c = StringManipulator.getIndexOrNull("Saludar", letter);
        System.out.println(a); // 4
        System.out.println(b); // 7
        System.out.println(c); // -1

        String word = "Hola";
        String subString = "la";
        String notSubString = "mundo";

        Integer d = StringManipulator.getIndexSub(word, subString);
        Integer e = StringManipulator.getIndexSub(word, notSubString);

        System.out.println(d); // 2
        System.out.println(e); // -1

        String palabra = StringManipulator.concatSubstring("Hola", 1, 3, "mundo");
        System.out.println(palabra); // olmundo
    }
}
