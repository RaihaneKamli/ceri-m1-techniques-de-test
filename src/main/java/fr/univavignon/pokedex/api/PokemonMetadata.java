package fr.univavignon.pokedex.api;

import java.util.List;

/**
 * Pokemon metadata POJO.
 *
 * @author fv
 */
public class PokemonMetadata {

  /** Pokemon index. * */
  private final int index;

  /** Pokemon name. * */
  private final String name;

  /** Pokemon attack level. * */
  private final int attack;

  /** Pokemon defense level. * */
  private final int defense;

  /** Pokemon stamina level. * */
  private final int stamina;

  /** Static list containing predefined PokemonMetadata instances. * */
  private static final List<PokemonMetadata> POKEMON_METADATA_LIST;

  static {
    // Initialisation des données statiques
    // Aquali
    POKEMON_METADATA_LIST =
        List.of(
            new PokemonMetadata(0, "Bulbizarre", 126, 126, 90), // Bulbizarre
            new PokemonMetadata(133, "Aquali", 186, 168, 260)); // Liste immuable
  }

  /**
   * Default constructor.
   *
   * @param index Pokemon index.
   * @param name Pokemon name.
   * @param attack Attack level.
   * @param defense Defense level.
   * @param stamina Stamina level.
   */
  public PokemonMetadata(
      final int index, final String name, final int attack, final int defense, final int stamina) {
    this.index = index;
    this.name = name;
    this.attack = attack;
    this.defense = defense;
    this.stamina = stamina;
  }

  /**
   * Retrieves the index of the Pokémon.
   *
   * @return the index of the Pokémon
   */
  public int getIndex() {
    return index;
  }

  /**
   * Retrieves the name of the Pokémon.
   *
   * @return the name of the Pokémon
   */
  public String getName() {
    return name;
  }

  /**
   * Retrieves the attack of the Pokémon.
   *
   * @return the attack of the Pokémon
   */
  public int getAttack() {
    return attack;
  }

  /**
   * Retrieves the defense of the Pokémon.
   *
   * @return the defense of the Pokémon
   */
  public int getDefense() {
    return defense;
  }

  /**
   * Retrieves the stamina of the Pokémon.
   *
   * @return the stamina of the Pokémon
   */
  public int getStamina() {
    return stamina;
  }

  /**
   * Retrieves a PokemonMetadata instance by its index.
   *
   * @param index The index of the desired Pokemon.
   * @return The corresponding PokemonMetadata, or null if not found.
   */
  public static PokemonMetadata getPokemonMetadataByIndex(int index) {
    for (PokemonMetadata metadata : POKEMON_METADATA_LIST) {
      if (metadata.getIndex() == index) {
        return metadata;
      }
    }
    return null; // Retourne null si aucun Pokémon ne correspond à l'index
  }
}
