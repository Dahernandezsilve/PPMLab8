package gt.uvg.pokelist.view

import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.R
import gt.uvg.pokelist.databinding.ItemPokemonViewBinding
import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.model.PokemonResponse
import gt.uvg.pokelist.repository.PokemonRepository
import gt.uvg.pokelist.repository.API
import kotlinx.coroutines.NonDisposableHandle.parent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment: Fragment() {

     fun getPokemonList(recyclerView: RecyclerView, view: View) {
        API.retrofitService.getFirst100Pokemon().enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {
                val pokemonListAdapter: PokemonListAdapter = PokemonListAdapter(response.body()!!.results)
                recyclerView.layoutManager = LinearLayoutManager(activity)
                view.visibility = View.GONE
                recyclerView.adapter = pokemonListAdapter
                recyclerView.setHasFixedSize(true)

            //Toast.makeText(context, "FETCHED: " + response.body()!!.results, Toast.LENGTH_LONG).show()


            }
            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                Toast.makeText(context, "ERROR", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        getPokemonList(recyclerView, progressBar)
        return view
    }

}

