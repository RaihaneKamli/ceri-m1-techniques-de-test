package implementation;

import static fr.univavignon.pokedex.api.PokemonMetadata.getPokemonMetadataByIndex;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
  @Override
  public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
    return getPokemonMetadataByIndex(index);
  }
}
