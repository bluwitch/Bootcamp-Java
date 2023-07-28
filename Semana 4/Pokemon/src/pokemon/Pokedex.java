package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pokedex extends AbstractPokemon {

    private final List<Pokemon> pokemonList;

    public Pokedex() {
        pokemonList = new ArrayList<>();
    }

    public int getMyPokemons() {
        return pokemonList.size();
    }

    @Override
    public void listPokemon() {
        System.out.println("Pokemon en la Pokedex:");
        
        for (Pokemon pokemon : pokemonList) {
            System.out.println(pokemonInfo(pokemon));
        }
    }

    @Override
    public Pokemon createPokemon(String name, int health, String type) {
        Pokemon newPokemon = new Pokemon(name, type, health);
        pokemonList.add(newPokemon);
        return newPokemon;
    }
}