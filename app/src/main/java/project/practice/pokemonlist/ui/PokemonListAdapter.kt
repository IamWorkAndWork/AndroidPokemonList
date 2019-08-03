package project.practice.pokemonlist.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*
import project.practice.pokemonlist.R
import project.practice.pokemonlist.data.Pokemon

class PokemonListAdapter(val context: Context, var pokemonList: ArrayList<Pokemon>? = arrayListOf()) :
    RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>() {

    //    var pokemonList: ArrayList<Pokemon>? = arrayListOf()
    private var listener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemonList?.size!!
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bindItem(pokemonList?.get(position)!!)
    }

    fun addPokemon(list: ArrayList<Pokemon>) {
        pokemonList?.clear()
        pokemonList?.addAll(list)
        notifyDataSetChanged()
//        pokemonList = list
//        notifyDataSetChanged()
    }

    fun setListener(listener: OnClickListener) {
        this.listener = listener
    }

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.pokemonName.setOnClickListener {
                listener?.onClick(adapterPosition, itemView)
            }
        }

        fun bindItem(pokemon: Pokemon) {

            itemView.pokemonName.text = pokemon.name


        }

    }
}