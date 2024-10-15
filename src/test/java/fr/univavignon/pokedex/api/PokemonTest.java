package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import java.util.*; 

import org.junit.Before;
import org.junit.Test;
public class PokemonTest {
	private Pokemon poke;
	
	
	public static List<String> getFirstGenPokemon() {
        return Arrays.asList(
            "Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard",
            "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree",
            "Weedle", "Kakuna", "Beedrill", "Pidgey", "Pidgeotto", "Pidgeot", "Rattata",
            "Raticate", "Spearow", "Fearow", "Ekans", "Arbok", "Pikachu", "Raichu",
            "Sandshrew", "Sandslash", "Nidoran♀", "Nidorina", "Nidoqueen", "Nidoran♂",
            "Nidorino", "Nidoking", "Clefairy", "Clefable", "Vulpix", "Ninetales", "Jigglypuff",
            "Wigglytuff", "Zubat", "Golbat", "Oddish", "Gloom", "Vileplume", "Paras", "Parasect",
            "Venonat", "Venomoth", "Diglett", "Dugtrio", "Meowth", "Persian", "Psyduck", "Golduck",
            "Mankey", "Primeape", "Growlithe", "Arcanine", "Poliwag", "Poliwhirl", "Poliwrath",
            "Abra", "Kadabra", "Alakazam", "Machop", "Machoke", "Machamp", "Bellsprout",
            "Weepinbell", "Victreebel", "Tentacool", "Tentacruel", "Geodude", "Graveler",
            "Golem", "Ponyta", "Rapidash", "Slowpoke", "Slowbro", "Magnemite", "Magneton",
            "Farfetch’d", "Doduo", "Dodrio", "Seel", "Dewgong", "Grimer", "Muk", "Shellder",
            "Cloyster", "Gastly", "Haunter", "Gengar", "Onix", "Drowzee", "Hypno", "Krabby",
            "Kingler", "Voltorb", "Electrode", "Exeggcute", "Exeggutor", "Cubone", "Marowak",
            "Hitmonlee", "Hitmonchan", "Lickitung", "Koffing", "Weezing", "Rhyhorn", "Rhydon",
            "Chansey", "Tangela", "Kangaskhan", "Horsea", "Seadra", "Goldeen", "Seaking",
            "Staryu", "Starmie", "Mr. Mime", "Scyther", "Jynx", "Electabuzz", "Magmar",
            "Pinsir", "Tauros", "Magikarp", "Gyarados", "Lapras", "Ditto", "Eevee", "Vaporeon",
            "Jolteon", "Flareon", "Porygon", "Omanyte", "Omastar", "Kabuto", "Kabutops",
            "Aerodactyl", "Snorlax", "Articuno", "Zapdos", "Moltres", "Dratini", "Dragonair",
            "Dragonite", "Mewtwo", "Mew"
        );
    };
	
	private List<String> firstGenPokemon = getFirstGenPokemon();
	
	@Before 
	public void setUp() {
	    // Utilisation d'un mock pour l'interface (ou une implémentation fictive)
		poke = new Pokemon(
	            1,          // index
	            "Bulbasaur", // name
	            126,        // attack
	            126,        // defense
	            90,         // stamina
	            613,        // cp
	            100,        // hp
	            2000,       // dust
	            3,          // candy
	            56.0        // iv (perfection)
	        );
		
	};
	
	@Test
    public void testCreatePokemon() {
		
	};

}