package com.example.mptalarm.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.mptalarm.MapsActivity
import com.example.mptalarm.R
import kotlinx.android.synthetic.main.fragment_timer.*
import kotlinx.android.synthetic.main.fragment_timer.view.*
import org.jetbrains.anko.onItemSelectedListener


class TimerFragment : Fragment() {

    val mainActivity = this.activity as MapsActivity
    lateinit var pos1 : String
    lateinit var pos2 : String

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadData()
        tp_dialog.setIs24HourView(true)
        SpinnerChanged()
        saveData()
    }

    override fun onPause() {
        super.onDestroy()
        super.onPause()
    }

    private fun saveData() {
        pos1 = sp_dep1.selectedItemPosition.toString()
        pos2 = sp_group1.selectedItemPosition.toString()
        val insertedText = pos1
        val insertedText1 = pos2
        val sharedPreferences = mainActivity.getSharedPreferences("sharedPrefs1", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("string_KEY", insertedText.toString())
            putString("string1_KEY", insertedText1.toString())
        }.apply()
    }

    private  fun loadData() {
        val sharedPreferences = mainActivity.getSharedPreferences("sharedPrefs1", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("string_KEY", null)
        val savedString1 = sharedPreferences.getString("string1_KEY", null)
        pos1 = savedString!!
        pos2 = savedString1!!

    }

   // override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)

    //}
    
    fun SpinnerChanged() {
        if (pos1 != "" && pos2 != "") {
            sp_dep1.setSelection(pos1.toInt())
            sp_group1.setSelection(pos2.toInt())
        }
        else {
            val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(mainActivity, R.array.dep, android.R.layout.simple_spinner_item)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sp_dep1.setAdapter(adapter)
            val adapter1: ArrayAdapter<*> = ArrayAdapter.createFromResource(mainActivity, R.array.group921, android.R.layout.simple_spinner_item)
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sp_group1.setAdapter(adapter1)
        }
        sp_dep1.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
                if (sp_dep1.selectedItemPosition == 0) {
                    val adapterr: ArrayAdapter<*> = ArrayAdapter.createFromResource(mainActivity, R.array.group921, android.R.layout.simple_spinner_item)
                    adapterr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapterr)
                }
                else if (sp_dep1.selectedItemPosition == 1) {
                    val adapterr: ArrayAdapter<*> = ArrayAdapter.createFromResource(mainActivity, R.array.group926, android.R.layout.simple_spinner_item)
                    adapterr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapterr)
                }
                else if (sp_dep1.selectedItemPosition == 2) {
                    val adapterr: ArrayAdapter<*> = ArrayAdapter.createFromResource(mainActivity, R.array.group927, android.R.layout.simple_spinner_item)
                    adapterr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapterr)
                }
                else if (sp_dep1.selectedItemPosition == 3) {
                    val adapterr: ArrayAdapter<*> = ArrayAdapter.createFromResource(mainActivity, R.array.group1025, android.R.layout.simple_spinner_item)
                    adapterr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapterr)
                }
                else if (sp_dep1.selectedItemPosition == 4) {
                    val adapterr: ArrayAdapter<*> = ArrayAdapter.createFromResource(mainActivity, R.array.group4021, android.R.layout.simple_spinner_item)
                    adapterr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapterr)
                }
                else if (sp_dep1.selectedItemPosition == 5) {
                    val adapterr: ArrayAdapter<*> = ArrayAdapter.createFromResource(mainActivity, R.array.groupOtd, android.R.layout.simple_spinner_item)
                    adapterr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapterr)
                }
            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) { }
        })
    }
}