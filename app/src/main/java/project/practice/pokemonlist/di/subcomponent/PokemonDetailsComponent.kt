package project.practice.pokemonlist.di.subcomponent

import dagger.Subcomponent
import project.practice.pokemonlist.di.module.PokemonDetailsViewModelModule
import project.practice.pokemonlist.di.module.ViewModelFactoryModule
import project.practice.pokemonlist.di.scope.FragmentScope
import project.practice.pokemonlist.ui.PokemonDetailsFragment
import project.practice.pokemonlist.viewmodel.ViewModelFactory

@FragmentScope
@Subcomponent(
    modules = [
        ViewModelFactoryModule::class,
        PokemonDetailsViewModelModule::class
    ]
)
interface PokemonDetailsComponent {

    fun inject(pokemonDetailsFragment: PokemonDetailsFragment)

}