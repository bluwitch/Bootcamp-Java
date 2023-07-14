public class StringManipulator {

    public static String manipulator(String str1, String str2) {
        String trimStr1 = str1.trim();
        String trimStr2 = str2.trim();
        String concatenatedString = trimStr1 + " " + trimStr2; // puse un espacio para que quede mas lindo el string
        return concatenatedString;
    }
}