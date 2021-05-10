package com.example.mptalarm

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mptalarm.fragments.HomeFragment
import com.example.mptalarm.fragments.MapFragment
import com.example.mptalarm.fragments.TimerFragment
import kotlinx.android.synthetic.main.activity_maps.*
import kotlinx.android.synthetic.main.fragment_map.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class MapsActivity : AppCompatActivity() {

    //var doc: Document = Jsoup.connect("https://mpt.ru/studentu/raspisanie-zanyatiy/").get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val homeFragment = HomeFragment()
        val timerFragment = TimerFragment()
        val mapsFragment = MapFragment()

        makeCurrentFragment(homeFragment)
        bot_nav.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_timer -> makeCurrentFragment(timerFragment)
                R.id.ic_map -> makeCurrentFragment(mapsFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment : Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.fl_wrapper, fragment)
        commit()
    }
}
