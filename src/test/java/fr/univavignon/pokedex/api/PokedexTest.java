package fr.univavignon.pokedex.api;

import implementation.Pokedex;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class PokedexTest {

    private IPokedexFactory pokedexFactory;  // Mock de la fabrique de pokedex
    private IPokemonMetadataProvider metadataProvider;  // Mock du fournisseur de métadonnées
    private IPokemonFactory pokemonFactory;  // Mock de la fabrique de Pokémon

    @Before
    public void setUp() {
        // Création des mocks
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testSize() {
        IPokedex pokedex = new Pokedex( metadataProvider, pokemonFactory);
        assertEquals(0, pokedex.size()); // Vérifie que le Pokédex est vide

        pokedex.addPokemon(new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 1.0));
        assertEquals(1, pokedex.size()); // Taille après ajout d'un Pokémon

        pokedex.addPokemon(new Pokemon(1, "Ivysaur", 150, 150, 110, 800, 80, 5000, 6, 0.9));
        assertEquals(2, pokedex.size()); // Taille après ajout d'un autre Pokémon
    }

    @Test
    public void testAddPokemon() throws PokedexException {
        IPokedex pokedex = new Pokedex( metadataProvider, pokemonFactory);

        Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 1.0);
        assertEquals(0, pokedex.addPokemon(bulbasaur)); // Ajout valide

        Pokemon ivysaur = new Pokemon(1, "Ivysaur", 150, 150, 110, 800, 80, 5000, 6, 0.9);
        assertEquals(1, pokedex.addPokemon(ivysaur)); // Ajout valide

    }

    @Test
    public void testGetPokemon() throws PokedexException {
        IPokedex pokedex = new Pokedex( metadataProvider, pokemonFactory);

        Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 1.0);
        pokedex.addPokemon(bulbasaur);

        // ID valide
        assertEquals(bulbasaur, pokedex.getPokemon(0));
        // ID non valide
        Pokemon Charmander = pokedex.getPokemon(-1);
        assertNull(Charmander);
    }

    @Test
    public void testGetPokemons() {
        IPokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);

        Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 1.0);
        pokedex.addPokemon(bulbasaur);

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(1, pokemons.size());
        assertEquals(bulbasaur, pokemons.get(0));

        try {
            pokemons.clear();
            fail("Expected UnsupportedOperationException for add()");
        }
        catch (UnsupportedOperationException E) {
            // Exeception attendu
        }
    }

    @Test
    public void testGetPokemonsWithOrder() {
        IPokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);

        Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 1.0);
        Pokemon ivysaur = new Pokemon(1, "Ivysaur", 150, 150, 110, 800, 80, 5000, 6, 0.9);
        pokedex.addPokemon(bulbasaur);
        pokedex.addPokemon(ivysaur);

        // Tri par CP
        List<Pokemon> sortedByCp = pokedex.getPokemons(Comparator.comparingInt(Pokemon::getCp));
        assertEquals(bulbasaur, sortedByCp.get(0));
        assertEquals(ivysaur, sortedByCp.get(1));

        // Tri par nom
        List<Pokemon> sortedByName = pokedex.getPokemons(Comparator.comparing(Pokemon::getName));
        assertEquals(bulbasaur, sortedByName.get(0));
        assertEquals(ivysaur, sortedByName.get(1));
    }

    @Test
    public void testCreatePokemon() {
        IPokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);

        Pokemon createdPokemon = pokedex.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(createdPokemon);
        assertEquals(0, createdPokemon.getIndex());
        assertEquals(613, createdPokemon.getCp());
        assertEquals(64, createdPokemon.getHp());
        assertEquals(4000, createdPokemon.getDust());
        assertEquals(4, createdPokemon.getCandy());
    }



}
