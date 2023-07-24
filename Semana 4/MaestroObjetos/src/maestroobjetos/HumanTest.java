package maestroobjetos;

public class HumanTest {

    public static void main(String[] args) {
        /* 

      



        wizard.obtenerStats("Wizard");
        samurai.obtenerStats("Samurai");
        ninja.obtenerStats("Ninja");

        wizard.attack(samurai); */

        Human ninja = new Human("Ninja");

        //     Human wizard = new Human("Wizard");
        Human samurai = new Human("Samurai");

        //  samurai.attack(wizard);
        // ninja.attack(wizard);
        //  ninja.attack(wizard);
        Wizard wizer = new Wizard("Wizard");
        wizer.obtenerStats("Wizard");
        wizer.curar(ninja);

        while (samurai.getHealth() > 0) {
            wizer.fireBall(samurai);
            if (samurai.getHealth() <= 0) {
                break;
            }
        }
    }
}
