package project.practice.pokemonlist.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                pokemonList.value = it
//                Log.e("print", "success pokemonList = " + it.toString())
            }, { er ->
//                Log.e("print", "Error pokemonList = " + er)
            })
        compositeDisposable.add(disposable)
    }

    fun getLivePokemonList() = pokemonList

}