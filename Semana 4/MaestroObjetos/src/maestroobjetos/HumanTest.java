package maestroobjetos;

public class HumanTest {

    public static void main(String[] args) {
        Human wizard = new Human("Wizard");

        Human samurai = new Human("Samurai");

        Human ninja = new Human("Ninja");

        wizard.obtenerStats("Wizard");
        samurai.obtenerStats("Samurai");
        ninja.obtenerStats("Ninja");

        wizard.attack(samurai);

        samurai.attack(wizard);

        ninja.attack(wizard);
        ninja.attack(wizard);

    }

}
