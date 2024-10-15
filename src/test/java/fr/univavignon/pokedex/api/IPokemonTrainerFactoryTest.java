package fr.univavignon.pokedex.api;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;  



public class IPokemonTrainerFactoryTest {
	private IPokemonTrainerFactory trainer;
	
	@Before
	public void setUp() {
	    // Utilisation d'un mock pour l'interface (ou une implémentation fictive)
		trainer = mock(IPokemonTrainerFactory.class);
	}
}