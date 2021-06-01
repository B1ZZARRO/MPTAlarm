package com.example.mptalarm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_settings.*
import java.text.SimpleDateFormat
import java.util.*

class SettingsActivity : AppCompatActivity() {

    var dep1 : Int = -1
    var group1 : Int = -1
    var groupStr : String = ""
    var time : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        loadData()
        val cal = Calendar.getInstance()
        tp_dialog.setOnTimeChangedListener { view, hourOfDay, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hourOfDay)
            cal.set(Calendar.MINUTE, minute)
            time = SimpleDateFormat("HH:mm").format(cal.time)
        }
        SpinnerFill()
        sp_group1.setSelection(group1)
        tp_dialog.setIs24HourView(true)

        btn_save.setOnClickListener {
            dep1 = sp_dep1.selectedItemPosition
            group1 = sp_group1.selectedItemPosition
            groupStr = sp_group1.selectedItem.toString()
            time = SimpleDateFormat("HH:mm").format(cal.time)
            saveData()
            startActivity(Intent(this,MapsActivity::class.java))
        }
    }

    private fun saveData() {
        val insertedText = dep1
        val insertedText1 = group1
        val insertedText2 = groupStr
        val insertedText3 = time
        val sharedPreferences = getSharedPreferences("sharedPrefs1", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putInt("string0_KEY", insertedText)
            putInt("string10_KEY", insertedText1)
            putString("string20_KEY", insertedText2)
            putString("string30_KEY", insertedText3)
        }.apply()
    }

    private  fun loadData() {
        val sharedPreferences = getSharedPreferences("sharedPrefs1", Context.MODE_PRIVATE)
        val savedInt = sharedPreferences.getInt("string0_KEY", -1)
        val savedInt1 = sharedPreferences.getInt("string10_KEY", -1)
        dep1 = savedInt
        group1 = savedInt1
    }

    fun SpinnerChanged() {
        sp_dep1.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
                if (sp_dep1.selectedItemPosition == 0) {
                    val adapterr: ArrayAdapter<*> = ArrayAdapter.createFromResource(this@SettingsActivity, R.array.group921, android.R.layout.simple_spinner_item)
                    adapterr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapterr)
                }
                else if (sp_dep1.selectedItemPosition == 1) {
                    val adapterr: ArrayAdapter<*> = ArrayAdapter.createFromResource(this@SettingsActivity, R.array.group926, android.R.layout.simple_spinner_item)
                    adapterr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapterr)
                }
                else if (sp_dep1.selectedItemPosition == 2) {
                    val adapterr: ArrayAdapter<*> = ArrayAdapter.createFromResource(this@SettingsActivity, R.array.group927, android.R.layout.simple_spinner_item)
                    adapterr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapterr)
                }
                else if (sp_dep1.selectedItemPosition == 3) {
                    val adapterr: ArrayAdapter<*> = ArrayAdapter.createFromResource(this@SettingsActivity, R.array.group1025, android.R.layout.simple_spinner_item)
                    adapterr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapterr)
                }
                else if (sp_dep1.selectedItemPosition == 4) {
                    val adapterr: ArrayAdapter<*> = ArrayAdapter.createFromResource(this@SettingsActivity, R.array.group4021, android.R.layout.simple_spinner_item)
                    adapterr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapterr)
                }
                else if (sp_dep1.selectedItemPosition == 5) {
                    val adapterr: ArrayAdapter<*> = ArrayAdapter.createFromResource(this@SettingsActivity, R.array.groupOtd, android.R.layout.simple_spinner_item)
                    adapterr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapterr)
                }
            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) { }
        })
    }

    fun SpinnerFill() {
        if (dep1 != -1 && group1 != -1) {
            val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.dep, android.R.layout.simple_spinner_item)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sp_dep1.setAdapter(adapter)
            sp_dep1.setSelection(dep1)
            if (sp_dep1.selectedItemPosition == 0) {
                val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.group921, android.R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sp_group1.setAdapter(adapter)
            }
            else if (sp_dep1.selectedItemPosition == 1) {
                val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.group926, android.R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sp_group1.setAdapter(adapter)
            }
            else if (sp_dep1.selectedItemPosition == 2) {
                val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.group927, android.R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sp_group1.setAdapter(adapter)
            }
            else if (sp_dep1.selectedItemPosition == 3) {
                val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.group1025, android.R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sp_group1.setAdapter(adapter)
            }
            else if (sp_dep1.selectedItemPosition == 4) {
                val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.group4021, android.R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sp_group1.setAdapter(adapter)
            }
            else if (sp_dep1.selectedItemPosition == 5) {
                val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.groupOtd, android.R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sp_group1.setAdapter(adapter)
            }
        }
        else {
            val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.dep, android.R.layout.simple_spinner_item)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sp_dep1.setAdapter(adapter)
            val adapter1: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.group921, android.R.layout.simple_spinner_item)
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sp_group1.setAdapter(adapter1)
        }
        SpinnerChanged()
        sp_group1.setSelection(group1)
    }
}