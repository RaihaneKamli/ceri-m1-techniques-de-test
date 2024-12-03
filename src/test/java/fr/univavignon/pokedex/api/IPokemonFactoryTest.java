package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {

  private IPokemonFactory pokemonfact;
  // private IPokemonFactory realPokemonFactory;
  Pokemon Bulbasaur;
  Pokemon Aquali;
  Pokemon Charmander;
  Pokemon Mew;

  @Before
  public void setUp() {
    // Mock
    pokemonfact = mock(IPokemonFactory.class);

    // Vraie instance
    Bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 2000, 3, 56.0);
    Aquali  = new Pokemon(133, "Aquali", 186, 168, 90, 613, 202, 2000, 3, 56.0);
    Charmander = new Pokemon(-5, "Charmander", -100, -613, -1, -613, -100, -2000, -3, -56.0);
    Mew =
        new Pokemon(
            Integer.MAX_VALUE,
            "Mew",
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Float.MAX_VALUE);
  }

  @Test
  public void MockCreateValidPokemon() {
    when(pokemonfact.createPokemon(0, 613, 64, 4000, 4)).thenReturn(Bulbasaur);
    when(pokemonfact.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(Aquali);

    // Appeler la méthode createPokemon sur le mock
    Pokemon createdBulbasaur = pokemonfact.createPokemon(0, 613, 64, 4000, 4);
    Pokemon createdAquali = pokemonfact.createPokemon(133, 2729, 202, 5000, 4);

    // Vérifie que les HP du Pokémon créé correspondent bien à 100
    assertEquals(
        64,
        createdBulbasaur
            .getHp()); // Ceci garantit que la méthode a bien pris en compte les HP fournis
    assertEquals(
        202,
        createdAquali.getHp()); // Ceci garantit que la méthode a bien pris en compte les HP fournis

    assertTrue(createdBulbasaur.getHp() > 0); // Les HP doivent être strictement positifs
    assertTrue(createdAquali.getHp() > 0); // Les HP doivent être strictement positifs

    assertTrue(createdBulbasaur.getAttack() >= 126 || createdBulbasaur.getAttack() >= 126 + 15);
    assertTrue(createdAquali.getAttack() >= 186 || createdAquali.getAttack() >= 186 + 15);

    assertTrue(createdBulbasaur.getDefense() >= 126 || createdBulbasaur.getDefense() >= 126 + 15);
    assertTrue(createdAquali.getDefense() >= 168 || createdAquali.getDefense() >= 168 + 15);

    assertTrue(createdBulbasaur.getStamina() >= 90 || createdBulbasaur.getStamina() <= 90 + 15);
    assertTrue(createdAquali.getStamina() >= 260 || createdAquali.getStamina() <= 260 + 15);

    assertTrue(createdBulbasaur.getCandy() > 0);
    assertTrue(createdAquali.getCandy() > 0);

    assertTrue(createdBulbasaur.getDust() > 0);
    assertTrue(createdAquali.getDust() > 0);

    assertTrue(createdBulbasaur.getIv() > 0);
    assertTrue(createdAquali.getIv() > 0);

    verify(pokemonfact).createPokemon(0, 613, 64, 4000, 4); // Vérifie l'appel pour Bulbasaur
    verify(pokemonfact).createPokemon(133, 2729, 202, 5000, 4); // Vérifie l'appel pour Aquali    }
  }

  @Test
  public void MockCreatePokemonInvalidIndex() {
    // Test de la création avec des valeurs négatives

    when(pokemonfact.createPokemon(-5, -613, -100, -2000, -3)).thenReturn(Charmander);

    assertNotNull(Charmander);
    assertEquals(-5, Charmander.getIndex());
    assertEquals(-613, Charmander.getCp());
    assertEquals(-2000, Charmander.getDust());
    assertEquals(-100, Charmander.getHp());
    assertEquals(-3, Charmander.getCandy());
  }

  @Test
  public void testCreateMaxValuePokemonWithMock() {
    // Configuration du mock pour retourner un objet Pokemon spécifique
    when(pokemonfact.createPokemon(
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE))
        .thenReturn(Mew);

    // Vérifications
    assertNotNull(Mew); // Vérifie que le retour n'est pas null
    assertEquals("Mew", Mew.getName());
    assertEquals(Integer.MAX_VALUE, Mew.getCp());
    assertEquals(Integer.MAX_VALUE, Mew.getHp());
    assertEquals(Integer.MAX_VALUE, Mew.getIndex());
    assertEquals(Integer.MAX_VALUE, Mew.getCandy());
    assertEquals(Integer.MAX_VALUE, Mew.getDust());
  }
}
