package implementation;

import fr.univavignon.pokedex.api.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    public IPokemonMetadataProvider pokemeta;
    public IPokemonFactory pokefact;

    List<Pokemon> pokedex = new ArrayList<>();


    public Pokedex (IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        pokemeta = metadataProvider;
        pokefact = pokemonFactory;
    }

    @Override
    public int size() {
        return pokedex.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokedex.add(pokemon);
        // On tri le pokedex
        return pokemon.getIndex();
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for (Pokemon pokemon : pokedex) {
            if (pokemon.getIndex() == id) {
                return pokemon;  // Retourne le Pokémon trouvé
            }
        }
        return null;  // Si aucun Pokémon avec cet index n'est trouvé
    }

    @Override
    public List<Pokemon> getPokemons() {
        return List.copyOf(pokedex);  // Liste copiée et non modifiable
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        pokedex.sort(order);
        return List.copyOf(pokedex);  // Liste copiée et non modifiable
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonFactory pokefact = new PokemonFactory();
        return pokefact.createPokemon(index,cp,hp,dust,candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return PokemonMetadata.getPokemonMetadataByIndex(index);
    }
}
