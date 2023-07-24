package guardianzoo;

public class Gorilla {

    private String gorilla;
    private int energyLevel;

    public Gorilla(String gorilla) {
        this.gorilla = gorilla;
        this.energyLevel = 100;
    }

    public int energyLevel() {
        return energyLevel;
    }

    public void tirarBanana() {
        energyLevel -= 5;
        System.out.println("El " + gorilla + " te revoleo una banana! Ahora su nivel de energia es: " + energyLevel);
    }
    
    public void comerBanana() {
        energyLevel += 10;
        System.out.println("El " + gorilla + " se comio una banana. Ahora su energia es:  " + energyLevel);
    }
    
    public void trepar() {
        energyLevel -= 10;
        System.out.println("El " + gorilla + " se trepo a la cima de un arbol. Ahora su energia es: " + energyLevel);
    }
}
