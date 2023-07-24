package maestroobjetos;

public class Samurai extends Human {

    public Samurai(String rol) {
        super(rol);
        this.setRol("Samurai");
        this.setHealth(200);
    }

    public void deathBlow(Human human) {
        this.setHealth(this.getHealth() / 2);
        human.setHealth(0);
        System.out.println("El " + this.getRol() + " asesina a " + human.getRol()
                + " con un Death Blow! Ahora la vida de " + this.getRol()
                + " es de: " + this.getHealth() + " puntos.");
    }

    public void meditate() {
        int meditacion = this.getHealth() / 2;
        this.setHealth(this.getHealth() + meditacion);
        System.out.println("El " + this.getRol() + " medita y restaura "
                + meditacion + " puntos de vida.");
    }
    
    public void howMany() {
        System.out.println("Ahora la vida de " + this.getRol()
                + " es igual a: " + this.getHealth());
    }
}
