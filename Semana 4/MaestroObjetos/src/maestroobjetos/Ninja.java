package maestroobjetos;

public class Ninja extends Human {

    public Ninja(String rol) {
        super(rol);
        this.getRol();
        this.setRol("Ninja");
        this.getHealth();
        this.getIntelligence();
        this.setIntelligence(8);

    }

    public void robar(Human human) {
        int puntosRobados = 0;
        if (this.getStealth() > 0) {
            puntosRobados += this.getStealth();
        }

        int enemigoVida = human.getHealth() - puntosRobados;

        this.setHealth(this.getHealth() + puntosRobados);
        human.setHealth(enemigoVida - puntosRobados);

        System.out.println("El " + this.getRol() + " robo a " + human.getRol() + " por " + puntosRobados
                + " puntos. Ahora sus puntos de vida son: " + this.getHealth()
                + ". Wizard ahora tiene " + human.getHealth() + " puntos de vida restantes.");
    }
}
