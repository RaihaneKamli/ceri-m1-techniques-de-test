package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;  // Mock de la fabrique de pokedex
    private IPokemonMetadataProvider metadataProvider;  // Mock du fournisseur de métadonnées
    private IPokemonFactory pokemonFactory;  // Mock de la fabrique de Pokémon

    @Before
    public void setUp() {
        // Création des mocks
        pokedexFactory = mock(IPokedexFactory.class);
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokedexValid() {
        // Simuler la création d'un Pokedex
        IPokedex pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        // Vérification de la création du Pokedex
        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(createdPokedex);
        assertEquals(pokedex, createdPokedex);
    }
    
    @Test
    public void testCreatePokedexWithNullMetadataProvider() {
    	IPokedex myPokedex = pokedexFactory.createPokedex(null, pokemonFactory);    
    	assertEquals(null, myPokedex);
        // Test avec un metadataProvider null, qui devrait lever une exception
    }
 
    @Test
    public void testCreatePokedexWithNullPokemonFactory() {
        // Test avec un pokemonFactory null, qui devrait lever une exception
    	IPokedex myPokedex = pokedexFactory.createPokedex(metadataProvider, null);    
        assertEquals(null, myPokedex);
    }
}
