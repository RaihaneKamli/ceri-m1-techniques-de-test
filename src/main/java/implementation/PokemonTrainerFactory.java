package implementation;


import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.IPokedex;


/**
 * Classe PokemonTrainerFactory qui implémente IPokemonTrainerFactory
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

  /**
   * Crée un nouvel entraîneur Pokémon avec un nom, une équipe et un Pokédex.
   *
   * Cette méthode utilise les services de la fabrique de Pokédex et d'autres
   * composants pour initialiser un Pokédex pour l'entraîneur. Un objet
   * {@link PokemonTrainer} est ensuite créé et renvoyé.
   *
   * @param name Le nom de l'entraîneur Pokémon.
   * @param team L'équipe du Pokémon de l'entraîneur (par exemple, Mystic, Valor, Instinct).
   * @param pokedexFactory La fabrique utilisée pour créer un Pokédex pour l'entraîneur.
   * @return Un nouvel objet {@link PokemonTrainer} avec le nom, l'équipe et le Pokédex initialisés.
   */

  @Override
  public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
    IPokemonMetadataProvider pokemeta = new PokemonMetadataProvider();
    IPokemonFactory pokefact = new PokemonFactory();
    IPokedex pokedex = pokedexFactory.createPokedex(pokemeta, pokefact);
    return new PokemonTrainer(name, team, pokedex);
  }
}
