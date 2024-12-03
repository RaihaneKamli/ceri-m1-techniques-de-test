package implementation;


import fr.univavignon.pokedex.api.*;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {
  @Override
  public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
    IPokemonMetadataProvider pokemeta = new PokemonMetadataProvider();
    IPokemonFactory pokefact = new PokemonFactory();
    IPokedex pokedex = pokedexFactory.createPokedex(pokemeta, pokefact);
    return new PokemonTrainer(name, team, pokedex);
  }
}
