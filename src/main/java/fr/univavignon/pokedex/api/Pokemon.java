package fr.univavignon.pokedex.api;

/**
 * Pokemon POJO.
 *
 * @author fv
 */
public final class Pokemon extends PokemonMetadata {

  /** Combat Point of the pokemon. * */
  private final int cp;

  /** HP of the pokemon. * */
  private final int hp;

  /** Required dust for upgrading this pokemon. * */
  private final int dust;

  /** Required candy for upgrading this pokemon. * */
  private final int candy;

  /** IV perfection percentage. * */
  private final double iv;

  /**
   * Default constructor.
   *
   * @param index Pokemon index.
   * @param name Pokemon name.
   * @param attack Attack level.
   * @param defense Defense level.
   * @param stamina Stamina level.
   * @param initCp Pokemon cp.
   * @param initHpp Pokemon hp.
   * @param initDust Required dust for upgrading this pokemon.
   * @param initCandy Required candy for upgrading this pokemon.
   * @param initIv IV perfection percentage.
   */
  public Pokemon(
      final int index,
      final String name,
      final int attack,
      final int defense,
      final int stamina,
      final int initCp,
      final int initHpp,
      final int initDust,
      final int initCandy,
      final double initIv) {
    super(index, name, attack, defense, stamina);
    this.cp = initCp;
    this.hp = initHpp;
    this.dust = initDust;
    this.candy = initCandy;
    this.iv = initIv;
  }

  /**
   * Retrieves the points of the Pokémon.
   *
   * @return the points of the Pokémon
   */
  public int getCp() {
    return cp;
  }

  /**
   * Retrieves the hp of the Pokémon.
   *
   * @return the hp of the Pokémon
   */
  public int getHp() {
    return hp;
  }

  /**
   * Retrieves the dust of the Pokémon.
   *
   * @return the dust of the Pokémon
   */
  public int getDust() {
    return dust;
  }

  /**
   * Retrieves the candy of the Pokémon.
   *
   * @return the candy of the Pokémon
   */
  public int getCandy() {
    return candy;
  }

  /**
   * Retrieves the iv of the Pokémon.
   *
   * @return the iv of the Pokémon
   */
  public double getIv() {
    return iv;
  }
}
