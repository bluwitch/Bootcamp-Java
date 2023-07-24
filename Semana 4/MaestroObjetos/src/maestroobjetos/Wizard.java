package maestroobjetos;

public class Wizard extends Human {

    public Wizard(String rol) {
        super(rol);
        this.setRol("Wizard");
        this.setHealth(50);
        this.setIntelligence(8);
    }

    public void curar(Human human) {
        int curacion = 0;
        if (this.getIntelligence() > 3) {
            curacion += this.getIntelligence();
        }

        int enemigoVida = human.getHealth() + curacion;

        if (enemigoVida < 0) {
            enemigoVida = 0;
        }
        human.setHealth(enemigoVida);

        System.out.println("El " + this.getRol() + " curo a " + human.getRol() + " por " 
                + curacion + " puntos. Ahora sus puntos de vida son: " + human.getHealth());
    }

    public void fireBall(Human enemigo) {
        int dañoMagico = 0;
        if (this.getIntelligence() > 0) {
            dañoMagico = this.getIntelligence() * 3;
        }

        int enemigoVida = enemigo.getHealth() - dañoMagico;

        if (enemigoVida < 0) {
            enemigoVida = 0;
        }
        enemigo.setHealth(enemigoVida);

        System.out.println("El " + this.getRol() + " ataca al " + enemigo.getRol()
                + " con una bola de fuego por " + dañoMagico + " puntos! "
                + enemigo.getRol() + " salud restante: " + enemigo.getHealth());

        if (enemigoVida <= 0) {
            System.out.println("EL " + enemigo.getRol() + " cae muerto!");
        }
    }
}
