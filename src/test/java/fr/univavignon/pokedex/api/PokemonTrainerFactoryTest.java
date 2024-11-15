package fr.univavignon.pokedex.api;

import implementation.PokedexFactory;
import implementation.PokemonTrainerFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokemonTrainerFactoryTest {

    private PokemonTrainerFactory trainerFactory;
    private PokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        trainerFactory = new PokemonTrainerFactory();
        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void testCreateTrainerValidInput() {
        String trainerName = "Ash";
        Team team = Team.MYSTIC;
        PokemonTrainer trainer = trainerFactory.createTrainer(trainerName, team, pokedexFactory);

        // Vérifications informations du trainer
        assertNotNull(trainer);
        assertEquals(trainerName, trainer.getName());
        assertEquals(team, trainer.getTeam());
        assertNotNull(trainer.getPokedex());
    }

    @Test
    public void testTrainerHasEmptyPokedexAtStart() {
        PokemonTrainer trainer = trainerFactory.createTrainer("Misty", Team.VALOR, pokedexFactory);

        // Vérification que le pokedex est vide
        assertNotNull(trainer.getPokedex());
        assertEquals(0, trainer.getPokedex().size());
    }

    @Test
    public void testTrainerAddsPokemonToPokedex() throws PokedexException {
        PokemonTrainer trainer = trainerFactory.createTrainer("Sacha", Team.INSTINCT, pokedexFactory);
        IPokedex trainerPokedex = trainer.getPokedex();

        PokemonMetadata metadata = new PokemonMetadata(1, "Bulbizarre", 126, 126, 90);
        Pokemon pokemon = new Pokemon(1, metadata.getName(), metadata.getAttack(), metadata.getDefense(), metadata.getStamina(), 613, 64, 4000, 4, 56.0);

        //Ajout du Pokemon
        trainerPokedex.addPokemon(pokemon);

        // Vérification que le Pokémon a bien été ajouté
        assertEquals(1, trainerPokedex.size());
        assertEquals(pokemon, trainerPokedex.getPokemon(1));
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonWithInvalidIndexThrowsException() throws PokedexException {
        PokemonTrainer trainer = trainerFactory.createTrainer("Red", Team.MYSTIC, pokedexFactory);
        IPokedex pokedex = trainer.getPokedex();

        // retourne une exception car index non valide
        pokedex.getPokemon(999);
    }

    @Test
    public void testTrainerWithDifferentTeams() {
        PokemonTrainer trainer1 = trainerFactory.createTrainer("Red", Team.MYSTIC, pokedexFactory);
        PokemonTrainer trainer2 = trainerFactory.createTrainer("Blue", Team.VALOR, pokedexFactory);

        // On vérifie les équipes
        assertEquals(Team.MYSTIC, trainer1.getTeam());
        assertEquals(Team.VALOR, trainer2.getTeam());
    }
}
