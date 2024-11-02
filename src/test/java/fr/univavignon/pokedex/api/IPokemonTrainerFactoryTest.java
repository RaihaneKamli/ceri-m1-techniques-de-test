package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;  // Mock de la fabrique de dresseur
    private IPokedexFactory pokedexFactory;  // Mock de la fabrique de pokedex
    private IPokedex pokedex;  // Mock du pokedex

    @Before
    public void setUp() {
        // Création des mocks
        trainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
        pokedex = mock(IPokedex.class);
    }

    @Test
    public void testCreateTrainerValid() {
        // Simuler la création d'un pokedex
        when(pokedexFactory.createPokedex(any(), any())).thenReturn(pokedex);

        // Créer un objet PokemonTrainer
        PokemonTrainer ash = new PokemonTrainer("Ash", Team.VALOR, pokedex);

        // Simuler la création du trainer
        when(trainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory)).thenReturn(ash);

        // Vérifier la création du trainer
        PokemonTrainer createdTrainer = trainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);
        assertNotNull(createdTrainer);
        assertEquals("Ash", createdTrainer.getName());
        assertEquals(Team.VALOR, createdTrainer.getTeam());
        assertEquals(pokedex, createdTrainer.getPokedex());
        verify(trainerFactory).createTrainer("Ash", Team.VALOR, pokedexFactory);

    }

    @Test
    public void testCreateTrainerWithNullName() {
        // Simuler la création avec un nom null, ce qui devrait lever une exception
        trainerFactory.createTrainer(null, Team.INSTINCT, pokedexFactory);
    }

    @Test
    public void testCreateTrainerWithNullTeam() {
        // Simuler la création avec une équipe null, ce qui devrait lever une exception
        trainerFactory.createTrainer("Brock", null, pokedexFactory);
    }

    @Test
    public void testCreateTrainerWithNullPokedexFactory() {
        // Simuler la création avec un pokedexFactory null, ce qui devrait lever une exception
        trainerFactory.createTrainer("Misty", Team.MYSTIC, null);
    }
}
