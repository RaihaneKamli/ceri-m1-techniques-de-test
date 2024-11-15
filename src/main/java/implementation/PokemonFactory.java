package implementation;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class PokemonFactory implements IPokemonFactory {
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadata metadata = PokemonMetadata.getPokemonMetadataByIndex(index);
        if (metadata != null) {
            var IV = ((metadata.getAttack() + metadata.getDefense() + metadata.getStamina()) / 45.0) * 100;
            return new Pokemon(index,metadata.getName(),metadata.getAttack(),metadata.getDefense(),metadata.getStamina(),cp,hp,dust,candy,IV);
        }
        return null;
    }
}
