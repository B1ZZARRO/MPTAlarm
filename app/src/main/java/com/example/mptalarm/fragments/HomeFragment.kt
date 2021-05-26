package com.example.mptalarm.fragments

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.mptalarm.PostTask
import com.example.mptalarm.R
import com.example.mptalarm.SettingsActivity
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        PostTask()
        btn_onoff.setOnClickListener {
            //val html = ("это пока нужно для тестирования парсинга")
            //val doc = Jsoup.parse(html)
            //txt_schedule.text = doc.html()
        }
        btn_settings.setOnClickListener {
            startActivity(Intent(context,SettingsActivity::class.java))
        }
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