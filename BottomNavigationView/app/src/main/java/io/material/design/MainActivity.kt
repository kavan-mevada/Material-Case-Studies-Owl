package io.material.design

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import io.material.design.ui.components.doBounceAnimation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_new_cources -> {
                textMessage.setText(R.string.title_new_cources)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_featured -> {
                textMessage.setText(R.string.title_featured)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_search -> {
                textMessage.setText(R.string.title_search)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        textMessage = findViewById(R.id.message)
        bottom_shadow.doBounceAnimation()
        nav_view.doBounceAnimation()

        (logo.drawable as AnimatedVectorDrawable).start()
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
