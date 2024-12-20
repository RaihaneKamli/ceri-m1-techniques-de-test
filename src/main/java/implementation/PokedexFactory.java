package implementation;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;

public class PokedexFactory implements IPokedexFactory {
  @Override
  public IPokedex createPokedex(
      IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
    if (metadataProvider == null || pokemonFactory == null) {
      return null;
    }
    return new Pokedex(metadataProvider, pokemonFactory);
  }
}
