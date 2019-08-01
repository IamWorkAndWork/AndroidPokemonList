package project.practice.pokemonlist.di.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import project.practice.pokemonlist.BASE_URL
import project.practice.pokemonlist.TIMEOUT_REQUEST
import project.practice.pokemonlist.di.scope.AppScope
import project.practice.pokemonlist.network.PokemonAPI
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {


    @AppScope
    @Provides
    fun provideHttpLogging(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @AppScope
    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient? {
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(TIMEOUT_REQUEST, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_REQUEST, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_REQUEST, TimeUnit.SECONDS)
            .build()
        return client
    }

    @AppScope
    @Provides
    fun provideRetrofit(okHttp: OkHttpClient?): Retrofit.Builder {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        return retrofit
    }


    @AppScope
    @Provides
    fun provideFeedService(builder: Retrofit.Builder): PokemonAPI {
        return builder.baseUrl(BASE_URL).build().create(PokemonAPI::class.java)
    }


}