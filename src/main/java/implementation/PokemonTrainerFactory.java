package implementation;


import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.IPokedex;


public class PokemonTrainerFactory implements IPokemonTrainerFactory {
  @Override
  public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
    IPokemonMetadataProvider pokemeta = new PokemonMetadataProvider();
    IPokemonFactory pokefact = new PokemonFactory();
    IPokedex pokedex = pokedexFactory.createPokedex(pokemeta, pokefact);
    return new PokemonTrainer(name, team, pokedex);
  }
}
