package fr.univavignon.pokedex.api;

import implementation.PokemonFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokemonFactoryTest  {

    private PokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        // Initialisation de l'instance réelle de PokemonFactory
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreateValidPokemon() {
        // Création d'un Pokémon avec des valeurs valides
        Pokemon bulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        // Vérification des données du Pokémon
        assertNotNull(bulbizarre);
        assertEquals(0, bulbizarre.getIndex());
        assertEquals("Bulbizarre", bulbizarre.getName());
        assertEquals(613, bulbizarre.getCp());
        assertEquals(64, bulbizarre.getHp());
        assertEquals(4000, bulbizarre.getDust());
        assertEquals(4, bulbizarre.getCandy());
        assertEquals(126, bulbizarre.getAttack());
        assertEquals(126, bulbizarre.getDefense());
        assertEquals(90, bulbizarre.getStamina());

        // Vérification du calcul de l'IV (valeurs fictives pour l'exemple)
        double expectedIV = ((126 + 126 + 90) / 45.0) * 100;
        assertEquals(expectedIV, bulbizarre.getIv(), 0.01); // Tolérance de 0.01 pour les flottants
    }

    @Test
    public void testCreatePokemonExtremeValues() {
        // Test avec des valeurs extrêmes
        Pokemon extremePokemon = pokemonFactory.createPokemon(133, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

        // Vérification des données
        assertNotNull(extremePokemon);
        assertEquals(133, extremePokemon.getIndex());
        assertEquals("Aquali", extremePokemon.getName());
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
        assertEquals("Bulbizarre", negativePokemon.getName()); // Exemple, remplacer par les données réelles
        assertEquals(-500, negativePokemon.getCp());
        assertEquals(-200, negativePokemon.getHp());
        assertEquals(-1000, negativePokemon.getDust());
        assertEquals(-10, negativePokemon.getCandy());
    }

    @Test
    public void testCreatePokemonWithMaxValue() {
        Pokemon maxPokemon = pokemonFactory.createPokemon(0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

        // Vérifications
        assertNotNull(maxPokemon); // Vérifie que le retour n'est pas null
        assertEquals("Bulbizarre", maxPokemon.getName());
        assertEquals(Integer.MAX_VALUE, maxPokemon.getCp());
        assertEquals(Integer.MAX_VALUE, maxPokemon.getHp());
        assertEquals(Integer.MAX_VALUE, maxPokemon.getCandy());
        assertEquals(Integer.MAX_VALUE, maxPokemon.getDust());

    }

    @Test(expected = AssertionError.class)
    public void testCreatePokemonWithInvalidIndex() {
        pokemonFactory.createPokemon(999, 500, 200, 1000, 10);
    }

    @Test
    public void testCreatePokemonWithBoundaryIndex() {
        Pokemon firstPokemon = pokemonFactory.createPokemon(0, 500, 200, 1000, 10);
        assertNotNull(firstPokemon);
        assertEquals("Bulbizarre", firstPokemon.getName());

        Pokemon lastPokemon = pokemonFactory.createPokemon(133, 1500, 400, 2000, 20);
        assertNotNull(lastPokemon);
        assertEquals("Aquali", lastPokemon.getName());
    }

    @Test
    public void testIVCalculation() {
        Pokemon pokemon = pokemonFactory.createPokemon(0, 500, 200, 1000, 10);

        double expectedIV = ((126 + 126 + 90) / 45.0) * 100;
        assertEquals(expectedIV, pokemon.getIv(), 0.01);
    }

    @Test
    public void testPokemonMetadataIntegrity() {
        Pokemon bulbizarre = pokemonFactory.createPokemon(0, 500, 200, 1000, 10);
        assertEquals("Bulbizarre", bulbizarre.getName());
        assertEquals(126, bulbizarre.getAttack());
        assertEquals(126, bulbizarre.getDefense());
        assertEquals(90, bulbizarre.getStamina());
    }


    @Test
    public void testCreatePokemonWithMixedValues() {
        Pokemon mixedPokemon = pokemonFactory.createPokemon(0, Integer.MAX_VALUE, -50, 0, Integer.MIN_VALUE);

        assertNotNull(mixedPokemon);
        assertEquals("Bulbizarre", mixedPokemon.getName());
        assertEquals(Integer.MAX_VALUE, mixedPokemon.getCp());
        assertEquals(-50, mixedPokemon.getHp());
        assertEquals(0, mixedPokemon.getDust());
        assertEquals(Integer.MIN_VALUE, mixedPokemon.getCandy());
    }

    @Test(expected = AssertionError.class)
    public void testCreateNullPokemon() {
        Pokemon bulbizarre = pokemonFactory.createPokemon(-1, 500, 200, 1000, 10);
    }
}
