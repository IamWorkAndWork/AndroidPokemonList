package project.practice.pokemonlist.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import project.practice.pokemonlist.viewmodel.PokeMonListViewModel
import project.practice.pokemonlist.viewmodel.ViewModelKey

@Module
abstract class PokemonListViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PokeMonListViewModel::class)
    internal abstract fun bindPokemonListViewModel(viewModel: PokeMonListViewModel): ViewModel
}