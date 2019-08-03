package project.practice.pokemonlist.viewmodel

import androidx.lifecycle.MutableLiveData
import project.practice.pokemonlist.data.PokemonDetails
import project.practice.pokemonlist.domain.PokemonUsecase
import javax.inject.Inject

class PokemonDetailsViewModel @Inject constructor(private val usecase: PokemonUsecase) : BaseViewModel() {

    private val pokemonDetailsMutableLiveData = MutableLiveData<PokemonDetails>()

    fun getPokemonDetails(id: Int) {
        val disposable = usecase.getPokemonDetails(id)
            .subscribe({
                pokemonDetailsMutableLiveData.value = it
            }, { er ->
            })

        compositeDisposable.add(disposable)
    }

    fun getLivePokemonDetails() = pokemonDetailsMutableLiveData

}