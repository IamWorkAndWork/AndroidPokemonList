package project.practice.pokemonlist.network

import io.reactivex.Observable
import project.practice.pokemonlist.data.PokemonDetails
import project.practice.pokemonlist.data.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonAPI {

    @GET("api/v2/pokemon")
    fun getPokemonList(@Query("offset") offset: Int, @Query("limit") limit: Int): Observable<PokemonResponse>

    @GET("api/v2/pokemon/{id}")
    fun getPokemonDetails(@Path("id") id: Int): Observable<PokemonDetails>


}