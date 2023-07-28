package pokemon;

public abstract class AbstractPokemon implements PokemonInterface {

    public Pokemon createPokemon(String name, int health, String type) {
        Pokemon pokemon = new Pokemon(name, type, health);
        return pokemon;
    }
    
    @Override
    public String pokemonInfo(Pokemon pokemon){
        return pokemon.toString();
    }
}
