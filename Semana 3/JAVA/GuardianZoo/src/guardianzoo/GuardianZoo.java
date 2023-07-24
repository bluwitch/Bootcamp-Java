package guardianzoo;

public class GuardianZoo {

    public static void main(String[] args) {
        Gorilla mono = new Gorilla("Gorilla");
        mono.tirarBanana();
        mono.tirarBanana();
        mono.tirarBanana();
        mono.comerBanana();
        mono.comerBanana();
        mono.trepar();
        
        System.out.println();
        
        Mammal mono2 = new Mammal("Choclo");
        mono2.displayEnergy();
    }
}
