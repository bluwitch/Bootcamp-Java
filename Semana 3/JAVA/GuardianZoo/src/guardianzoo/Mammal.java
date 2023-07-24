package guardianzoo;

public class Mammal {

    private String mammal;
    private int energyLevel;

    public Mammal(String mammal) {
        this.mammal = mammal;
        this.energyLevel = 100;
    }

    public void displayEnergy() {
        System.out.println("El nivel de energia de " + mammal + " es: " + energyLevel);
    }
}
