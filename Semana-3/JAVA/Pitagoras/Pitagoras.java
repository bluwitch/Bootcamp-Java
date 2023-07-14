import java.lang.Math;
public class Pitagoras {
    public double calcularHipotenusa(int catetoA, int catetoB) {
        double i = catetoA;
        double j = catetoB;
        double hipotenusaResult = Math.sqrt(i * i + j * j);
        return hipotenusaResult;
    }
}