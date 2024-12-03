package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.*;
import org.junit.Before;
import org.junit.Test;

public class IPokedexTest {
  private IPokedex pokedex;

  @Before
  public void setUp() {
    // Utilisation d'un mock pour l'interface
    pokedex = mock(IPokedex.class);
    // On simule la taille du Pokedex
    when(pokedex.size()).thenReturn(151);

    Pokemon Charmander = new Pokemon(1, "Charmander", 126, 126, 90, 613, 100, 2000, 3, 56.0);

    when(pokedex.addPokemon(Charmander)).thenReturn(1);

    try {
      when(pokedex.getPokemon(1)).thenReturn(Charmander);
    } catch (PokedexException e) {
      fail("PokedexException was thrown: " + e.getMessage());
    }

    List<Pokemon> pokemons = List.of(Charmander);

    when(pokedex.getPokemons()).thenReturn(pokemons);
  }

  @Test
  public void testPokedexMaxSize() {
    // Vérifie si le Pokedex contient 151 Pokémon (simulé)
    assertEquals(151, pokedex.size());
  }

  @Test
  public void testAddPokemon() {
    // Vérifie si le Pokémon ajouté retourne l'index 1
    Pokemon Charmander = new Pokemon(1, "Charmander", 126, 126, 90, 613, 100, 2000, 3, 56.0);
    assertEquals(0, pokedex.addPokemon(Charmander));
    verify(pokedex).addPokemon(Charmander); // Vérifie que addPokemon a été appelé avec Charmander
  }

  @Test
  public void testGetPokemon() throws PokedexException {
    // Test si getPokemon(1) retourne bien Charmander
    Pokemon Charmander = pokedex.getPokemon(1);
    assertNotNull(Charmander);
    assertEquals("Charmander", Charmander.getName());
    verify(pokedex).getPokemon(1); // Vérifie que getPokemon a été appelé avec 1
  }

  @Test
  public void testGetPokemonWrongIndex() throws PokedexException {
    Pokemon Charmander = pokedex.getPokemon(-1);
    assertNull(Charmander);
    verify(pokedex).getPokemon(-1); // Vérifie que getPokemon a été appelé avec 1
  }

  @Test
  public void testGetRightPokemon() throws PokedexException {
    // Test si getPokemon(1) retourne bien Charmander
    Pokemon Charmander = pokedex.getPokemon(1);
    assertNotNull(Charmander);
    assertEquals("Charmander", Charmander.getName());
  }
}
