package project.practice.pokemonlist.data

import java.io.Serializable

data class PokemonDetails(val id:Int,val height:Int,val weight:Int,val sprites: Sprites): Serializable {
}