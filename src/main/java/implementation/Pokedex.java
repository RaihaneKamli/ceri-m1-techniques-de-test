package implementation;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;

import java.util.Comparator;
import java.util.List;

public abstract class Pokedex implements IPokedex {
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


}
