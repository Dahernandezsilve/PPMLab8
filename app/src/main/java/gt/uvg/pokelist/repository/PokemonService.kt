package gt.uvg.pokelist.repository

import com.squareup.moshi.Moshi
import gt.uvg.pokelist.model.PokemonResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

interface PokemonService {
    @GET("pokemon?limit=100")
    fun getFirst100Pokemon(): Call<PokemonResponse>
}
