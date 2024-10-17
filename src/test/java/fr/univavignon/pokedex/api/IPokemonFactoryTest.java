package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {

    private IPokemonTrainerFactory trainerFactory;  // Mock de la fabrique de dresseur
    private IPokedexFactory pokedexFactory;  // Mock de la fabrique de pokedex

    @Before
    public void setUp() {
        // Création des mocks pour IPokemonTrainerFactory et IPokedexFactory
        trainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
    }

    @Test
    public void testCreateTrainerValid() {
        // Simuler le comportement d'un pokedex pour le trainer
        IPokedex pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(any(), any())).thenReturn(pokedex);

        // Créer un objet PokemonTrainer
        PokemonTrainer ash = new PokemonTrainer("Ash", Team.VALOR, pokedex);

        // Simuler la création du trainer
        when(trainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory)).thenReturn(ash);

        // Vérification du comportement
        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);
        assertNotNull(trainer);
        assertEquals("Ash", trainer.getName());
        assertEquals(Team.VALOR, trainer.getTeam());
        assertEquals(pokedex, trainer.getPokedex());
    }

    @Test
    public void testCreateTrainerWithNullName() {
        // Test avec un nom null
    	PokemonTrainer myTrainer = trainerFactory.createTrainer(null, Team.INSTINCT, pokedexFactory);
        assertEquals(null,myTrainer);
    }

    @Test
    public void testCreateTrainerWithNullTeam() {
        // Test avec une équipe null
    	PokemonTrainer myTrainer = trainerFactory.createTrainer("Brock", null, pokedexFactory);
        assertEquals(null,myTrainer);
    }

    @Test
    public void testCreateTrainerWithNullPokedexFactory() {
        // Test avec un pokedexFactory null
    	PokemonTrainer myTrainer= trainerFactory.createTrainer("Misty", Team.MYSTIC, null);
        assertEquals(null,myTrainer);
    }
}
