package project.practice.pokemonlist.di.subcomponent

import dagger.Subcomponent
import project.practice.pokemonlist.di.module.PokemonListViewModelModule
import project.practice.pokemonlist.di.module.ViewModelFactoryModule
import project.practice.pokemonlist.di.scope.FragmentScope
import project.practice.pokemonlist.ui.PokemonListFragment
import project.practice.pokemonlist.viewmodel.ViewModelFactory

@FragmentScope
@Subcomponent(
    modules = [
        ViewModelFactoryModule::class,
        PokemonListViewModelModule::class]
)
interface PokemonListComponent {

    fun inject(pokemonListFragment: PokemonListFragment?)

}