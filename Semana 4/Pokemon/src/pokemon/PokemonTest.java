package pokemon;

public class PokemonTest {

    public static void main(String[] args) {
        Pokedex pokedex = new Pokedex();
        Pokemon o07 = pokedex.createPokemon("Squirtle", 44, "Agua");
        Pokemon o04 = pokedex.createPokemon("Charmander", 39, "Fuego");
        Pokemon o01 = pokedex.createPokemon("Bulbasaur", 45, "Hierva");
        
        Pokemon bulbasaur = new Pokemon("Bulbasaur", "Grass", 45);
        Pokemon charmander = new Pokemon("Charmander", "Fire", 39);
        Pokemon squirtle = new Pokemon("Squirtle", "Water", 44);

        int myPokemons = pokedex.getMyPokemons();
        System.out.println("Cantidad de Pokemon en la Pokedex: " + myPokemons);
        
        pokedex.listPokemon();
        bulbasaur.scratch(charmander);
        System.out.println(charmander.getHealth());
    }
}