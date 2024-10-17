package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {

	private IPokemonFactory pokemonfact;

    @Before
    public void setUp() {
        pokemonfact = mock(IPokemonFactory.class);
    }

    
    @Test
    public void createValidPokemon () {
    	Pokemon Bulbasaur = pokemonfact.createPokemon(0, 613,64, 4000, 4);
    	Pokemon Aquali = pokemonfact.createPokemon(133, 2729,202, 5000,4);
    	
    	if (Bulbasaur.getAttack() < 126 || Bulbasaur.getAttack() > 126+15) {
            throw new PokedexException("attack need to be between 126 and 141");
    	}
    	
    	if (Aquali.getAttack() < 186 || Aquali.getAttack() > 186+15) {
            throw new PokedexException("attack need to be between 126 and 141");
    	}
    	
    	
    	
    }
    
    

}
