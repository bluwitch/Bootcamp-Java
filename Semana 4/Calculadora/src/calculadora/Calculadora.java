package calculadora;

public class Calculadora {

    public static void main(String[] args) {
        Operaciones operacion = new Operaciones();
        operacion.setOperand1(10);
        operacion.setOperand2(9);
        operacion.setOperation("+");
        String resultado = operacion.performOperation();
        System.out.println("El resultado es: " + resultado);

    }

}
