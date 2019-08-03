package project.practice.pokemonlist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import project.practice.pokemonlist.R

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getLayoutById(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutById())

        initUI()

    }

    abstract fun initUI()
}
