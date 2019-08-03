package project.practice.pokemonlist.ui

import project.practice.pokemonlist.R

class MainActivity : BaseActivity() {

    private val pokemonListFragment = PokemonListFragment.newInstance("", "")

    override fun getLayoutById(): Int {
        return R.layout.activity_main
    }

    override fun initUI() {
        supportFragmentManager.beginTransaction().replace(R.id.container, pokemonListFragment).commit()
    }

}