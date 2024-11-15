package fr.univavignon.pokedex.api;

import implementation.PokedexFactory;
import implementation.PokemonFactory;
import implementation.PokemonMetadataProvider;
import org.junit.Before;

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

   /* @Test
    public void testCreatePokedexValid() {
        // Simuler la création d'un Pokedex
        IPokedex pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        // Vérification de la création du Pokedex
        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(createdPokedex);
        assertEquals(pokedex, createdPokedex);
        verify(pokedexFactory).createPokedex(metadataProvider, pokemonFactory);

    }

    @Test
    public void testCreatePokedexWithNullMetadataProvider() {
        IPokedex myPokedex = pokedexFactory.createPokedex(null, pokemonFactory);
        assertNull(myPokedex);
        // Test avec un metadataProvider null, qui devrait lever une exception
    }

    @Test
    public void testCreatePokedexWithNullPokemonFactory() {
        // Test avec un pokemonFactory null, qui devrait lever une exception
        IPokedex myPokedex = pokedexFactory.createPokedex(metadataProvider, null);
        assertNull(myPokedex);
    }*/
}
