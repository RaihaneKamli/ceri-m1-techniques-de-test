package fr.univavignon.pokedex.api;

import implementation.PokedexFactory;
import implementation.PokemonFactory;
import implementation.PokemonMetadataProvider;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PokedexFactoryTest {

    private PokedexFactory pokedexFactory; // Instance réelle de la fabrique
    private IPokemonMetadataProvider metadataProvider; // Instance réelle du fournisseur de métadonnées
    private IPokemonFactory pokemonFactory; // Instance réelle de la fabrique de Pokémon

    @Before
    public void setUp() {
        pokedexFactory = new PokedexFactory();
        metadataProvider = new PokemonMetadataProvider(); // Une classe concrète
        pokemonFactory = new PokemonFactory(); // Une classe concrète
    }

    @Test
    public void testCreatePokedex() {
        // Créer un Pokedex
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Vérifier que nous n'avons pas null
        assertNotNull(pokedex);
    }

    @Test
    public void testCreatePokedexWithNullMetadataProvider() {
        IPokedex pokedex = pokedexFactory.createPokedex(null, pokemonFactory);
        assertNull(pokedex);
        // Test avec un metadataProvider null, qui devrait lever une exception
    }

    @Test
    public void testCreatePokedexWithNullPokemonFactory() {
        // Test avec un pokemonFactory null, qui devrait lever une exception
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, null);
        assertNull(pokedex);
    }
}
