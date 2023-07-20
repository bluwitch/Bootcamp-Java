public class GreeterTest {
    public static void main(String[] args){
        Greeter gtt = new Greeter();
        String greeting = gtt.greeter();
        String greetingWithName = gtt.greeter("Eduardo");
        if (greeting.equals("Hola Mundo") || greetingWithName.equals("Hola Eduardo")){
            System.out.println("Prueba exitosa.");
        } else{
            System.out.println("La prueba fallo");
        }
    }
}
