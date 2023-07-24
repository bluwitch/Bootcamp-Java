package maestroobjetos;

public class HumanTest {

    public static void main(String[] args) {

        //    Human ninja = new Human("Ninja");
        //     Human wizard = new Human("Wizard");
        Human samurai = new Human("Samurai");
        Wizard wizer = new Wizard("Wizard");

        wizer.obtenerStats("Wizard");

        while (samurai.getHealth() > 0) {
            wizer.fireBall(samurai);
            if (samurai.getHealth() <= 0) {
                break;
            }
        }
        Ninja ninja = new Ninja("Ninja");
        ninja.robar(wizer);

    }
}
