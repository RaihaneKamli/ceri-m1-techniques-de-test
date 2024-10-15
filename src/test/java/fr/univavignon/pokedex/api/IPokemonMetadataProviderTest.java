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
	
}
