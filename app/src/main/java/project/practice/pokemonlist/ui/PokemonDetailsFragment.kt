package project.practice.pokemonlist.ui


import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_pokemon_details.*
import project.practice.pokemonlist.BaseApp

import project.practice.pokemonlist.R
import project.practice.pokemonlist.data.PokemonDetails
import project.practice.pokemonlist.viewmodel.PokemonDetailsViewModel
import project.practice.pokemonlist.viewmodel.ViewModelFactory
import javax.inject.Inject

private const val ARG_PARAM1 = "id"


class PokemonDetailsFragment : BaseFragment() {

    private lateinit var pokemonDetailsViewModel: PokemonDetailsViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun getLayoutByID(): Int {
        return R.layout.fragment_pokemon_details
    }

    private var id: Int? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        (activity?.application as BaseApp).appComponent.newPokemonDetailsComponent().inject(this)


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt(ARG_PARAM1)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokemonDetailsViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(PokemonDetailsViewModel::class.java)

        id?.let {
            getPokemonDetails()
        }
    }

    private fun getPokemonDetails() {

        if (isVisible) {
            pokemonDetailsViewModel.getPokemonDetails(id!!)
            observePokemonDetails()
        }

    }

    private fun observePokemonDetails() {

        pokemonDetailsViewModel.getLivePokemonDetails().observe(activity!!, Observer {
            it?.run {
                setData(this)
            }
        })

    }

    private fun setData(response: PokemonDetails) {

        Picasso.get().load(response?.sprites?.front_default).into(pokemonImage)
        pokemonWeight.text = "Weight is " + response.weight.toString()
        pokemonHeight.text = "Height is ".plus(response?.height.toString())

    }


    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
            PokemonDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }
}
