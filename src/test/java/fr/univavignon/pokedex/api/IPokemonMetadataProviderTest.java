package fr.univavignon.pokedex.api;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;  


public class IPokemonMetadataProviderTest {
	private IPokemonMetadataProvider metadataProvider;
	
    @Before
    public void setUp() {
        // Création d'un mock pour l'interface IPokemonMetadataProvider
        metadataProvider = mock(IPokemonMetadataProvider.class);
    }
	
	
	@Test
    public void testGetPokemonMetadataValidIndex() throws PokedexException {
        // Simuler une réponse pour un index valide
        PokemonMetadata bulbasaurMetadata = new PokemonMetadata(1, "Bulbasaur", 126, 126, 90);
        when(metadataProvider.getPokemonMetadata(1)).thenReturn(bulbasaurMetadata);

        // Appel de la méthode et vérification
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(1);
        assertNotNull(metadata);
        assertEquals(1, metadata.getIndex());
        assertEquals("Bulbasaur", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }
	
	@Test
	public void testGetPokemonMetadataWrongIndex() throws PokedexException {
	    // Simuler une réponse pour un index valide (par exemple, Bulbasaur)
	    when(metadataProvider.getPokemonMetadata(anyInt())).thenAnswer(invocation -> {
	        int index = invocation.getArgument(0);
	        if (index > 151) {
	            throw new PokedexException("Index cannot be greater than 151");
	        } else if (index < 0) {
	            throw new PokedexException("Index cannot be lesser than 0");
	        }
	        // Sinon, retourner un objet PokemonMetadata valide
	        return new PokemonMetadata(index, "ValidPokemon", 100, 100, 100);
	    });

	    // Vérification que l'exception est levée pour un index > 151
	    try {
	        metadataProvider.getPokemonMetadata(155);  // Cela devrait lever une PokedexException
	        fail("Expected PokedexException to be thrown for index > 151");
	    } catch (PokedexException e) {
	        assertEquals("Index cannot be greater than 151", e.getMessage());
	    }

	    // Vérification que l'exception est levée pour un index < 0
	    try {
	        metadataProvider.getPokemonMetadata(-5);  // Cela devrait lever une PokedexException
	        fail("Expected PokedexException to be thrown for index < 0");
	    } catch (PokedexException e) {
	        assertEquals("Index cannot be lesser than 0", e.getMessage());
	    }

	    // Vérification qu'aucune exception n'est levée pour un index valide
	    PokemonMetadata metadata = metadataProvider.getPokemonMetadata(1);
	    assertNotNull(metadata);
	    assertEquals(1, metadata.getIndex());
	    assertEquals("ValidPokemon", metadata.getName());
	}

	

}
