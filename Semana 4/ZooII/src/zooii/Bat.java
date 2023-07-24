package zooii;

public class Bat {

    private String bat;
    private int energyLevel;

    public Bat(){
        this.bat = "Murcielago Gigante";
        this.energyLevel = 300;
    }

    public void fly() {
        energyLevel -= 50;
        System.out.println("flap flap flap... El " + bat + " paso volando encima tuyo! Su energia ahora es: " + energyLevel);
    }
    
    public void eatHumans(){
        energyLevel += 25;
        System.out.println("Bueno, no importa... La energia de " + bat + " ahora es " + energyLevel);
    }
    
    public void attackTown(){
        energyLevel -= 100;
        System.out.println("AAAAAAAAAaaAAAAAAAAAAa grita la gente porque el " + bat + " esta atacando la ciudad :/ su energia ahora es: " + energyLevel);
    }

}
