package project.practice.pokemonlist.di.module

import dagger.Module
import dagger.Provides
import project.practice.pokemonlist.di.scope.AppScope
import project.practice.pokemonlist.domain.PokemonUsecase
import project.practice.pokemonlist.repository.PokemonRepository

@Module
class PokemonUsecaseModule() {

    @AppScope
    @Provides
    fun provideFeedUseCase(repository: PokemonRepository): PokemonUsecase {
        return PokemonUsecase(repository)
    }

}