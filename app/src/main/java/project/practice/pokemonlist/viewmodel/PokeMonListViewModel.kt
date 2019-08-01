package project.practice.pokemonlist.viewmodel

import androidx.lifecycle.MutableLiveData
import project.practice.pokemonlist.data.Pokemon
import project.practice.pokemonlist.data.PokemonResponse
import project.practice.pokemonlist.domain.PokemonUsecase
import javax.inject.Inject

class PokeMonListViewModel @Inject constructor(private val usecase: PokemonUsecase) : BaseViewModel() {

    private val pokemonList = MutableLiveData<PokemonResponse>()

    fun getPokemonList() {
        if (pokemonList.value != null) {
            return
        }

        val disposable = usecase.getPokemonList(0)
            .subscribe {
                pokemonList.value = it
            }
        compositeDisposable.add(disposable)
    }


}