package maestroobjetos;

public class HumanTest {

    public static void main(String[] args) {

        Wizard wizer = new Wizard("Wizard");
        Ninja ninja = new Ninja("Ninja");
        Samurai samurai = new Samurai("Samurai");

        wizer.obtenerStats("Wizard");

     /*   while (samurai.getHealth() > 0) {
            wizer.fireBall(samurai);
            if (samurai.getHealth() <= 0) {
                break;
            }
        } */

        ninja.robar(wizer);
        System.out.println(wizer.getHealth());

        samurai.deathBlow(ninja);
        System.out.println(ninja.getHealth());
        samurai.deathBlow(wizer);
        samurai.meditate();
        samurai.howMany();
    }
}
