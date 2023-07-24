package maestroobjetos;

public class Ninja extends Human {

    public Ninja(String rol) {
        super(rol);
        this.setRol("Ninja");
        this.setStealth(10);
    }

    public void robar(Human human) {
        int puntosRobados = this.getStealth();
        int enemigoVida = human.getHealth() - puntosRobados;
        
        if (enemigoVida < 0) {
            enemigoVida = 0;
        }
        human.setHealth(enemigoVida);
        this.setHealth(this.getHealth() + puntosRobados);

        System.out.println("El " + this.getRol() + " roba a " + human.getRol() + " por " + puntosRobados
                + " puntos. Ahora sus puntos de vida son: " + this.getHealth());
    }
}
