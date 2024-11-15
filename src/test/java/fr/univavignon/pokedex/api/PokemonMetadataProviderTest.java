package fr.univavignon.pokedex.api;

import implementation.PokemonMetadataProvider;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokemonMetadataProviderTest {

    private PokemonMetadataProvider provider;

    @Before
    public void setUp() {
        provider = new PokemonMetadataProvider();
    }


    @Test
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        assertNull(provider.getPokemonMetadata(999)); // Doit lever une PokedexException
    }


    @Test
    public void testGetPokemonMetadataNegativeIndex() throws PokedexException {
        assertNull(provider.getPokemonMetadata(-1)); // Doit lever une PokedexException
    }

    @Test
    public void testPerformanceForValidIndexes() throws PokedexException {
        for (int i = 0; i < 2; i++) { // On a que 2 pokemon sinon on parcourirait les 151
            PokemonMetadata metadata = provider.getPokemonMetadata(i == 0 ? 0 : 133);
            assertNotNull(metadata);
        }
    }
}
