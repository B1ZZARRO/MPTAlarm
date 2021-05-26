package com.example.mptalarm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.view.size
import com.example.mptalarm.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    var dep1 : Int = -1
    var group1 : Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)


        loadData()
        txt_pn.text = dep1.toString()
        txt_vt.text = group1.toString()
        SpinnerFill()
        sp_group1.setSelection(group1)
        //SpinnerChanged()
        tp_dialog.setIs24HourView(true)

        btn_settings.setOnClickListener {
            dep1 = sp_dep1.selectedItemPosition
            group1 = sp_group1.selectedItemPosition
            saveData()
            startActivity(Intent(this,MapsActivity::class.java))
        }
    }

    private fun saveData() {
        val insertedText = dep1
        val insertedText1 = group1
        val sharedPreferences = getSharedPreferences("sharedPrefs1", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putInt("string0_KEY", insertedText)
            putInt("string10_KEY", insertedText1)
        }.apply()
    }

    private  fun loadData() {
        val sharedPreferences = getSharedPreferences("sharedPrefs1", Context.MODE_PRIVATE)
        val savedInt = sharedPreferences.getInt("string0_KEY", -1)
        val savedInt1 = sharedPreferences.getInt("string10_KEY", -1)
        dep1 = savedInt
        group1 = savedInt1
    }

    /*private  fun loadData1() {
        val mainActivity = this.activity as MapsActivity
        val sharedPreferences = mainActivity.getSharedPreferences("sharedPrefs1", Context.MODE_PRIVATE)
        //val savedInt = sharedPreferences.getInt("string0_KEY", -1)
        val savedInt1 = sharedPreferences.getInt("string10_KEY", -1)
        //dep1 = savedInt
        group1 = savedInt1
    }*/

    /*override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }*/

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
        /*val mainActivity = this.activity as MapsActivity
        val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(mainActivity, R.array.dep, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp_dep1.setAdapter(adapter)
        val adapter1: ArrayAdapter<*> = ArrayAdapter.createFromResource(mainActivity, R.array.group921, android.R.layout.simple_spinner_item)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp_group1.setAdapter(adapter1)
        sp_dep1.setSelection(2)
        sp_group1.setSelection(2)*/
        //txt_pn.text = sp_dep1.selectedItemPosition.toString()
        //txt_vt.text = sp_group1.selectedItemPosition.toString()
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