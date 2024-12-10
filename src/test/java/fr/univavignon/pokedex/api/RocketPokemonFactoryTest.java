package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test pour vérifier la class RocketPokemonFactoryTest de la team Rocket
 * */

public class RocketPokemonFactoryTest {

    private RocketPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        // Initialisation de l'instance réelle de PokemonFactory
        pokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void indexOut() {
        Pokemon pokemon = pokemonFactory.createPokemon(999, 500, 120, 2000, 50);

        assertEquals("MISSINGNO", pokemon.getName());
    }


    @Test
    public void testValidPokemonCreation() {
        Pokemon pokemon = pokemonFactory.createPokemon(1, 500, 120, 2000, 50);

        assertEquals("Bulbasaur", pokemon.getName());
        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 100);
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 100);
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 100);
        assertEquals(1.0, pokemon.getIv(), 0.01);
    }

    @Test
    public void testExtremeIndexValues() {

        // Index très grand
        Pokemon highIndexPokemon = pokemonFactory.createPokemon(Integer.MAX_VALUE, 500, 120, 2000, 50);
        assertEquals("MISSINGNO", highIndexPokemon.getName());

        // Index très petit
        Pokemon lowIndexPokemon = pokemonFactory.createPokemon(Integer.MIN_VALUE, 500, 120, 2000, 50);
        assertEquals("MISSINGNO", lowIndexPokemon.getName());
    }

    @Test(timeout = 100) // Limite à 100ms
    public void testRandomStatPerformance() {
        int stat = RocketPokemonFactory.randomStat();
        assertTrue(stat >= 0 && stat <= 100); // Vérifiez que le résultat est dans une plage valide
    }

    @Test
    public void testCreateValidPokemon() {
        // Création d'un Pokémon avec des valeurs valides
        Pokemon bulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        // Vérification des données du Pokémon
        assertNotNull(bulbizarre);
        assertEquals(0, bulbizarre.getIndex());
        assertEquals("MISSINGNO", bulbizarre.getName());
        assertEquals(613, bulbizarre.getCp());
        assertEquals(64, bulbizarre.getHp());
        assertEquals(4000, bulbizarre.getDust());
        assertEquals(4, bulbizarre.getCandy());

        // Impossible à connaitre la valeur exact vu que c'est généré aléatoirement


        assertTrue( bulbizarre.getAttack() > 0);
        assertTrue( bulbizarre.getDefense() > 0);
        assertTrue( bulbizarre.getStamina() > 0);
        double expectedIV = ((bulbizarre.getAttack() + bulbizarre.getDefense() + bulbizarre.getStamina()) / 45.0) * 100;
    }

    @Test
    public void testCreatePokemonExtremeValues() {
        // Test avec des valeurs extrêmes
        Pokemon extremePokemon =
                pokemonFactory.createPokemon(
                        133, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

        // Vérification des données
        assertNotNull(extremePokemon);
        assertEquals(133, extremePokemon.getIndex());
        assertEquals("MISSINGNO", extremePokemon.getName());
        assertEquals(Integer.MAX_VALUE, extremePokemon.getCp());
        assertEquals(Integer.MAX_VALUE, extremePokemon.getHp());
        assertEquals(Integer.MAX_VALUE, extremePokemon.getDust());
        assertEquals(Integer.MAX_VALUE, extremePokemon.getCandy());
    }

    @Test
    public void testCreatePokemonNegativeValues() {
        // Test avec des valeurs négatives
        Pokemon negativePokemon = pokemonFactory.createPokemon(0, -500, -200, -1000, -10);

        assertNotNull(negativePokemon);
        assertEquals(0, negativePokemon.getIndex());
        assertEquals("MISSINGNO", negativePokemon.getName());
        assertEquals(-500, negativePokemon.getCp());
        assertEquals(-200, negativePokemon.getHp());
        assertEquals(-1000, negativePokemon.getDust());
        assertEquals(-10, negativePokemon.getCandy());
    }

    @Test
    public void testCreatePokemonWithMaxValue() {
        Pokemon maxPokemon =
                pokemonFactory.createPokemon(
                        0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

        // Vérifications
        assertNotNull(maxPokemon); // Vérifie que le retour n'est pas null
        assertEquals("MISSINGNO", maxPokemon.getName());
        assertEquals(Integer.MAX_VALUE, maxPokemon.getCp());
        assertEquals(Integer.MAX_VALUE, maxPokemon.getHp());
        assertEquals(Integer.MAX_VALUE, maxPokemon.getCandy());
        assertEquals(Integer.MAX_VALUE, maxPokemon.getDust());
    }

    @Test
    public void testCreatePokemonWithBoundaryIndex() {
        Pokemon firstPokemon = pokemonFactory.createPokemon(0, 500, 200, 1000, 10);
        assertNotNull(firstPokemon);
        assertEquals("MISSINGNO", firstPokemon.getName());

        Pokemon lastPokemon = pokemonFactory.createPokemon(133, 1500, 400, 2000, 20);
        assertNotNull(lastPokemon);
        assertEquals("MISSINGNO", lastPokemon.getName());
    }

    @Test
    public void testCreatePokemonWithMixedValues() {
        Pokemon mixedPokemon =
                pokemonFactory.createPokemon(0, Integer.MAX_VALUE, -50, 0, Integer.MIN_VALUE);

        assertNotNull(mixedPokemon);
        assertEquals("MISSINGNO", mixedPokemon.getName());
        assertEquals(Integer.MAX_VALUE, mixedPokemon.getCp());
        assertEquals(-50, mixedPokemon.getHp());
        assertEquals(0, mixedPokemon.getDust());
        assertEquals(Integer.MIN_VALUE, mixedPokemon.getCandy());
    }

}
