package project.practice.pokemonlist.di.module

import dagger.Module
import dagger.Provides
import project.practice.pokemonlist.di.scope.AppScope
import project.practice.pokemonlist.network.PokemonAPI
import project.practice.pokemonlist.repository.PokemonRepository

@Module
class RepositoryModule {

    @AppScope
    @Provides
    fun provideFeedRepository(api: PokemonAPI): PokemonRepository {
        return PokemonRepository(api)
    }

}