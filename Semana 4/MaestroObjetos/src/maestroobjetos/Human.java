package maestroobjetos;

public class Human {

    private int health = 100;
    private int stealth;
    private int intelligence;
    private int strength;
    private String rol;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStealth() {
        return stealth;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public Human(String rol) {
        this.rol = rol;
        switch (rol) {
            case "Wizard":
                this.stealth = 1;
                this.intelligence = 5;
                this.strength = 2;
                break;
            case "Ninja":
                this.stealth = 4;
                this.intelligence = 1;
                this.strength = 3;
                break;
            case "Samurai":
                this.stealth = 1;
                this.intelligence = 2;
                this.strength = 5;
                break;
            default:
                break;
        }
    }

    public void obtenerStats(String rol) {
        if ("Wizard".equals(rol)) {
            System.out.println("Los stats iniciales del Wizard son... " + "Salud: " + getHealth() + ", Stealth: " + getStealth() + ", Intelligence: " + getIntelligence() + ", Strength: " + getStrength());
        }
        if ("Ninja".equals(rol)) {
            System.out.println("Los stats iniciales del Ninja son..." + " Salud: " + getHealth() + ", Stealth: " + getStealth() + ", Intelligence: " + getIntelligence() + ", Strength: " + getStrength());
        }
        if ("Samurai".equals(rol)) {
            System.out.println("Los stats iniciales del Samurai son..." + " Salud: " + getHealth() + ", Stealth: " + getStealth() + ", Intelligence: " + getIntelligence() + ", Strength: " + getStrength());
        }
    }

    public void attack(Human enemigo) {
        int daño = 0;
        if (this.getIntelligence() > 3) {
            daño = this.getIntelligence();
        } else if (this.getStealth() > 3) {
            daño = this.getStealth();
        } else if (this.getStrength() > 3) {
            daño = this.getStrength();
        }

        int enemigoVida = enemigo.getHealth() - daño;

        if (enemigoVida < 0) {
            enemigoVida = 0;
        }
        enemigo.setHealth(enemigoVida);

        System.out.println("El " + rol + " ataca al " + enemigo.rol + "! " + enemigo.rol + " salud restante: " + enemigo.getHealth());
    }
}
