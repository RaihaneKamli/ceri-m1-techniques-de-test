package implementation;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

  /*
  * IPokemonMetadataProvider instance
  * */
  public IPokemonMetadataProvider pokemeta;

  /*
   * IPokemonFactory instance
   * */
  public IPokemonFactory pokefact;

  List<Pokemon> pokedex = new ArrayList<>();

  /*
   * Constructeur de la classe Pokemon
   * */
  public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
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
        return pokemon; // Retourne le Pokémon trouvé
      }
    }
    throw new PokedexException(
        "No Pokémon found with index: " + id); // Lance une exception si non trouvé
  }

  @Override
  public List<Pokemon> getPokemons() {
    return List.copyOf(pokedex); // Liste copiée et non modifiable
  }

  @Override
  public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
    pokedex.sort(order);
    return List.copyOf(pokedex); // Liste copiée et non modifiable
  }

  @Override
  public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
    PokemonFactory pokefact = new PokemonFactory();
    return pokefact.createPokemon(index, cp, hp, dust, candy);
  }

  @Override
  public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
    return PokemonMetadata.getPokemonMetadataByIndex(index);
  }
}
