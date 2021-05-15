package com.example.mptalarm

import android.content.SharedPreferences
import android.graphics.Bitmap
import android.os.AsyncTask
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.text.PrecomputedText
import android.util.Log
import android.widget.Toast
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

//    lateinit var doc: Document
//    var doc: Document = Jsoup.connect("https://mpt.ru/studentu/raspisanie-zanyatiy/").get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

       // doc = Jsoup.connect("https://mpt.ru/studentu/raspisanie-zanyatiy").get()

        PostTask()

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

@Suppress("DEPRECATION")
class PostTask() : AsyncTask<String, Int, Document>() {
    override fun doInBackground(vararg p0: String?): Document {
        val doc: Document = Jsoup.connect("https://mpt.ru/studentu/raspisanie-zanyatiy/").get()
        Log.i("TAG", doc.toString())
        return doc
    }
}
