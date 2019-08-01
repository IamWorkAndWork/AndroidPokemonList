package project.practice.pokemonlist

import android.app.Application
import dagger.Component
import project.practice.pokemonlist.di.component.AppComponent
import project.practice.pokemonlist.di.component.DaggerAppComponent
import project.practice.pokemonlist.di.module.NetworkModule
import project.practice.pokemonlist.di.module.PokemonUsecaseModule
import project.practice.pokemonlist.di.module.RepositoryModule

class BaseApp : Application() {


    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = this.initDagger()
    }

    private fun initDagger(): AppComponent {

        return DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .repositoryModule(RepositoryModule())
            .pokemonUsecaseModule(PokemonUsecaseModule())
            .build()

    }

}