package project.practice.pokemonlist.repository

import io.reactivex.Observable
import project.practice.pokemonlist.LIMIT
import project.practice.pokemonlist.data.PokemonDetails
import project.practice.pokemonlist.data.PokemonResponse
import project.practice.pokemonlist.network.PokemonAPI

class PokemonRepository(val pokemonAPI: PokemonAPI) {

    fun getPokemonList(offset: Int): Observable<PokemonResponse> {
        return pokemonAPI.getPokemonList(offset, LIMIT)
    }

    fun getPokemonDetails(id: Int): Observable<PokemonDetails> {
        return pokemonAPI.getPokemonDetails(id)
    }

}