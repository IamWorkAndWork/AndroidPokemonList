package project.practice.pokemonlist.ui


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_pokemon_list.*
import project.practice.pokemonlist.BaseApp

import project.practice.pokemonlist.R
import project.practice.pokemonlist.data.PokemonResponse
import project.practice.pokemonlist.viewmodel.PokeMonListViewModel
import project.practice.pokemonlist.viewmodel.ViewModelFactory
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class PokemonListFragment : BaseFragment(), OnClickListener {


    var pokemonList: RecyclerView? = null

    private var param1: String? = null
    private var param2: String? = null

    var adapter: PokemonListAdapter? = null

    @Inject
    lateinit var viewmodelFactory: ViewModelFactory

    var pokemmonListViewModel: PokeMonListViewModel? = null

    override fun getLayoutByID(): Int {
        return R.layout.fragment_pokemon_list
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        (activity?.application as BaseApp).appComponent
            .newPokemonListComponent().inject(this)


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
////        return super.onCreateView(inflater, container, savedInstanceState)
//        val view = inflater.inflate(R.layout.fragment_pokemon_list, container, false)
//
//        pokemonList = view?.findViewById(R.id.pokemonList)
//
//        adapter = PokemonListAdapter(activity!!, arrayListOf())
//        // rest of my stuff
//        pokemonList?.setHasFixedSize(true)
//        pokemonList?.layoutManager = LinearLayoutManager(activity!!)
//        pokemonList?.adapter = adapter
//
//        return view
//    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokemmonListViewModel = ViewModelProviders.of(this, viewmodelFactory).get(PokeMonListViewModel::class.java)

        pokemonList = view.findViewById(R.id.pokemonList) as RecyclerView
//        activity?.run {
//            runOnUiThread {
        initUI()
//            }
//        }
    }

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
//
//        pokemmonListViewModel = ViewModelProviders.of(this, viewmodelFactory).get(PokeMonListViewModel::class.java)
//
//        initUI()
//    }

    private fun initUI() {

        setupView()
        getPokemonListData()

    }

    private fun getPokemonListData() {

        pokemmonListViewModel?.getPokemonList()
        observeViewModel()

    }

    private fun observeViewModel() {

        pokemmonListViewModel?.getLivePokemonList()?.observe(activity!!, Observer {
            it?.let {

                setData(it)


            }
        })

    }


    private fun setData(response: PokemonResponse) {

        response?.results?.run {


            //            if (adapter == null) {
            adapter = PokemonListAdapter(activity!!, this)
            pokemonList?.adapter = adapter
            adapter?.setListener(this@PokemonListFragment)

//            } else {
//                adapter?.addPokemon(this)
//                adapter?.notifyDataSetChanged()
//            }


            Log.e("print", "success pokemmonListViewModel der = " + this.size)

        }

    }

    private fun setupView() {

        adapter = PokemonListAdapter(activity!!)

        val lm = LinearLayoutManager(activity!!)

        pokemonList?.setHasFixedSize(true)

        pokemonList?.layoutManager = lm

        pokemonList?.adapter = adapter

        pokemonList?.addItemDecoration(DividerItemDecoration(activity, lm.orientation))

//        adapter?.setListener(this)

    }


//    override fun getLayoutByID(): Int {
//        return R.layout.fragment_pokemon_list
//    }

    override fun onClick(position: Int, view: View) {

        getPokemonDetails(position)

    }

    private fun getPokemonDetails(id: Int) {

//        val bundle = Bundle()
//        bundle.putInt(POKEMON_DETAILS_KEY, id)
        val pokemonDetailsFragment = PokemonDetailsFragment.newInstance(id)

        (activity as BaseActivity).supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, pokemonDetailsFragment)
            .addToBackStack(null)
            .commit()

        Log.e("print", "click at = " + id)


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
