package project.practice.pokemonlist.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import project.practice.pokemonlist.viewmodel.ViewModelFactory

@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}