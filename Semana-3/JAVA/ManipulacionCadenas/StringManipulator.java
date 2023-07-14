public class StringManipulator {

    public static String manipulator(String str1, String str2) {
        String trimmedStr1 = str1.trim();
        String trimmedStr2 = str2.trim();
        String concatenatedString = trimmedStr1 + trimmedStr2;
        return concatenatedString;
    }
}