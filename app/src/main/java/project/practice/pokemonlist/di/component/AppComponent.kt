package project.practice.pokemonlist.di.component

import dagger.Component
import project.practice.pokemonlist.di.module.NetworkModule
import project.practice.pokemonlist.di.module.PokemonUsecaseModule
import project.practice.pokemonlist.di.module.RepositoryModule
import project.practice.pokemonlist.di.scope.AppScope
import project.practice.pokemonlist.di.subcomponent.PokemonListComponent

@AppScope
@Component(
    modules = [
        NetworkModule::class,
        PokemonUsecaseModule::class,
        RepositoryModule::class]
)
interface AppComponent {

    fun newPokemonListComponent(): PokemonListComponent


}