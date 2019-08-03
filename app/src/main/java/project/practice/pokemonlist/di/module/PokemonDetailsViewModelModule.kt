package project.practice.pokemonlist.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import project.practice.pokemonlist.viewmodel.PokemonDetailsViewModel
import project.practice.pokemonlist.viewmodel.ViewModelKey

@Module
abstract class PokemonDetailsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PokemonDetailsViewModel::class)
    internal abstract fun bindPokemonDetailsViewModel(viewModel: PokemonDetailsViewModel): ViewModel

}