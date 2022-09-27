package gt.uvg.pokelist.view

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.R
import gt.uvg.pokelist.databinding.ItemPokemonViewBinding
import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.model.PokemonResponse


class PokemonListAdapter(
    private var pokemonList: List<Pokemon>
) : RecyclerView.Adapter<PokemonListAdapter.PokemonListHolder>() {



    inner class PokemonListHolder(val binding: ItemPokemonViewBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListHolder {
        val binding = ItemPokemonViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonListHolder(binding)
    }

    override fun getItemCount() = pokemonList.size;

    override fun onBindViewHolder(holder: PokemonListHolder, position: Int) {
        val item = pokemonList[position]
        item.id = position+1
        holder.binding.pokemonName.text = item.name
        Picasso.get()
            .load(item.imageUrlFront)
            //.placeholder(R.drawable.ic_launcher_background)
            //.error(R.drawable.ic_launcher_background)
            .into(holder.binding.pokemonPhoto)
        holder.itemView.setOnClickListener {
            val bundle = bundleOf("pokemonId" to item.id)
            holder.itemView.findNavController().navigate(R.id.action_mainFragment_to_detailFragment, bundle)
        }
    }

    fun setResponse(pokemonResponse: PokemonResponse){
        this.pokemonList = pokemonResponse.results
    }
}
