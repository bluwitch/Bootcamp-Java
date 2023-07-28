
package pokemon;

public class Pokemon {

    private String name;
    private String type;
    private int health;
    private static int count;

    public Pokemon(String name, String type, int health) {
        this.name = name;
        this.type = type;
        this.health = health;
        count++;
    }
    
    public void scratch(Pokemon poke) {
        int vidaPoke = poke.getHealth() - 10;
        poke.setHealth(vidaPoke);
    }
    
      @Override
    public String toString() {
        return "Nombre: " + name + ", Tipo: " + type + ", PS: " + health;
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
