package com.example.mptalarm.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mptalarm.MapsActivity
import com.example.mptalarm.R
import com.example.mptalarm.SettingsActivity
import com.example.mptalarm.service.AlarmService
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : Fragment() {

    lateinit var  alarmService: AlarmService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        alarmService = AlarmService(context!!)

        btn_onoff.setOnClickListener {
            setAlarm {timeInMillis -> alarmService.setExactAlarm(timeInMillis)}
        }

        btn_settings.setOnClickListener {
            startActivity(Intent(context,SettingsActivity::class.java))
        }
    }

    private  fun loadData() {
        val mainActivity = this.activity as MapsActivity
        val sharedPreferences1 = mainActivity.getSharedPreferences("sharedPrefs1", Context.MODE_PRIVATE)
        val sharedPreferences = mainActivity.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString2 = sharedPreferences.getString("string2_KEY", "")
        val savedString3 = sharedPreferences.getString("string3_KEY", "")
        val savedString20 = sharedPreferences1.getString("string20_KEY", "")
        val savedString30 = sharedPreferences1.getString("string30_KEY", "")
        txt_yourgroup.text = "Ваша группа: ${savedString20}"
        txt_yourtime.text = "Время подготовки: ${savedString30}"
        txt_youraddress.text = "Ехать До Нежинская ул., д. 7 : ${savedString2}"
        txt_youraddress1.text = "Ехать До Нахимовский пр., д. 21 : ${savedString3}"
    }

    private  fun setAlarm(callback: (Long) -> Unit) {
        Calendar.getInstance().apply {
            DatePickerDialog(
                    context!!,
                    0,
                    { _, year, month, day ->
                        this.set(Calendar.YEAR, year)
                        this.set(Calendar.MONTH, month)
                        this.set(Calendar.DAY_OF_MONTH, day)
                        TimePickerDialog(
                                context!!,
                                0,
                                { _, hour, min, ->
                                    this.set(Calendar.HOUR_OF_DAY, hour)
                                    this.set(Calendar.MINUTE, min)
                                },
                                this.get(Calendar.HOUR_OF_DAY),
                                this.get(Calendar.MINUTE),
                                false
                        ).show()
                    },
                    this.get(Calendar.YEAR),
                    this.get(Calendar.MONTH),
                    this.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }
}