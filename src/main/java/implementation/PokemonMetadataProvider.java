package implementation;

import static fr.univavignon.pokedex.api.PokemonMetadata.getPokemonMetadataByIndex;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;


/**
 * Class PokemonMetadataProvider qui implémente IPokemonMetadataProvider
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

  /**
   * Récupère les métadonnées d'un Pokémon en fonction de son index.
   * Cette méthode interroge les données disponibles pour obtenir les informations
   * associées à un Pokémon spécifique, identifiées par son index. Si l'index
   * fourni est valide, les métadonnées du Pokémon sont retournées. Sinon,
   * une exception de type {@link PokedexException} est lancée.
   *
   * @param index L'index du Pokémon pour lequel les métadonnées sont demandées.
   * @return Un objet {@link PokemonMetadata} contenant les informations du Pokémon.
   * @throws PokedexException Si l'index est invalide ou si les métadonnées ne peuvent pas être récupérées.
   */

  @Override
  public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
    return getPokemonMetadataByIndex(index);
  }
}
