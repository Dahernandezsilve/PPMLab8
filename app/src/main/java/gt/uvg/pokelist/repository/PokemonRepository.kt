package gt.uvg.pokelist.repository

import android.app.Activity
import android.content.Context
import android.os.Build.VERSION_CODES.P
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.model.PokemonResponse
import gt.uvg.pokelist.view.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory



private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl("https://pokeapi.co/api/v2/")
    .build()
object API {
    val retrofitService: PokemonService by lazy {
        retrofit.create(PokemonService::class.java)
    }
}
class PokemonRepository {

}