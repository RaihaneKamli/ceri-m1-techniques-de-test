package fr.univavignon.pokedex.api;

/**
 * Trainer POJO.
 *
 * @author fv
 */
public class PokemonTrainer {

  /** Trainer name. * */
  private final String name;

  /** Trainer team. * */
  private final Team team;

  /** Trainer pokedex. * */
  private final IPokedex pokedex;

  /**
   * Default constructor.
   *
   * @param name Trainer name.
   * @param team Trainer team.
   * @param pokedex Trainer pokedex.
   */
  public PokemonTrainer(final String name, final Team team, final IPokedex pokedex) {
    this.name = name;
    this.team = team;
    this.pokedex = pokedex;
  }

  /**
   * Retrieves the name of the trainer.
   *
   * @return the name of the trainer
   */  public String getName() {
    return name;
  }

  /**
   * Retrieves the team of the trainer.
   *
   * @return the index of the trainer
   */  public Team getTeam() {
    return team;
  }

  /**
   * Retrieves the pokedex of the trainer.
   *
   * @return the pokedex of the trainer
   */  public IPokedex getPokedex() {
    return pokedex;
  }
}
