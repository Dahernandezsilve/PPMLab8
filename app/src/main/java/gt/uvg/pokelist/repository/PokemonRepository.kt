package gt.uvg.pokelist.repository

import gt.uvg.pokelist.model.Pokemon

class PokemonRepository {

    // Obtain pokemon list from https://pokeapi.co/
    fun getPokemonList(): List<Pokemon> {
        return listOf(
            Pokemon(834, "Drednaw"),
            Pokemon(345, "Lileep"),
            Pokemon(244, "Entei"),
            Pokemon(25, "Pikachu"),
            Pokemon(734, "Yungoos"),
            Pokemon(890, "Eternatus"),
            Pokemon(187, "Hoppip"),
            Pokemon(49 , "Venomoth"),
            Pokemon(732, "Trumbeak"),
            Pokemon(37,"Vulpix")
        )
    }

}