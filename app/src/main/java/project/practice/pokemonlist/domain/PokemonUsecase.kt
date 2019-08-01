package project.practice.pokemonlist.domain

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import project.practice.pokemonlist.data.PokemonDetails
import project.practice.pokemonlist.data.PokemonResponse
import project.practice.pokemonlist.repository.PokemonRepository

class PokemonUsecase(private val repository: PokemonRepository) {

    fun getPokemonList(offset: Int): Observable<PokemonResponse> {
        return repository.getPokemonList(offset)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getPokemonDetails(id: Int): Observable<PokemonDetails> {
        return repository.getPokemonDetails(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}