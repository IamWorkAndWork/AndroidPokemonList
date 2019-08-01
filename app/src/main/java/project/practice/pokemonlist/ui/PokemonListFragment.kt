package project.practice.pokemonlist.ui


import android.content.Context
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import project.practice.pokemonlist.BaseApp

import project.practice.pokemonlist.R
import project.practice.pokemonlist.viewmodel.PokeMonListViewModel
import project.practice.pokemonlist.viewmodel.ViewModelFactory
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class PokemonListFragment : BaseFragment() {


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    val adapter = PokemonListAdapter()

    @Inject
    lateinit var viewmodelFactory: ViewModelFactory

    var pokemmonListViewModel: PokeMonListViewModel? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        (activity?.applicationContext as BaseApp).appComponent
            .newPokemonListComponent().inject(this)

        pokemmonListViewModel = ViewModelProviders.of(this, viewmodelFactory).get(PokeMonListViewModel::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {

        

    }


    override fun getLayoutByID(): Int {
        return R.layout.fragment_pokemon_list
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PokemonListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
