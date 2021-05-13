package com.example.mptalarm.fragments

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
import org.jetbrains.anko.onItemSelectedListener


class TimerFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tp_dialog.setIs24HourView(true)
        val mainActivity = this.activity as MapsActivity
        SpinnerChanged()
        sp_dep1.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
                if (sp_dep1.selectedItemPosition == 0) {
                    val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(mainActivity, R.array.group921, android.R.layout.simple_spinner_item)
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapter)
                }
                if (sp_dep1.selectedItemPosition == 1) {
                    val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(mainActivity, R.array.group926, android.R.layout.simple_spinner_item)
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapter)
                }
                if (sp_dep1.selectedItemPosition == 2) {
                    val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(mainActivity, R.array.group927, android.R.layout.simple_spinner_item)
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapter)
                }
                if (sp_dep1.selectedItemPosition == 3) {
                    val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(mainActivity, R.array.group1025, android.R.layout.simple_spinner_item)
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapter)
                }
                if (sp_dep1.selectedItemPosition == 4) {
                    val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(mainActivity, R.array.group4021, android.R.layout.simple_spinner_item)
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapter)
                }
                if (sp_dep1.selectedItemPosition == 5) {
                    val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(mainActivity, R.array.groupOtd, android.R.layout.simple_spinner_item)
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    sp_group1.setAdapter(adapter)
                }
            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {
                return
            }
        })
    }
    
    fun SpinnerChanged() {

        //sp_dep1.onItemSelectedListener (object : )
    }
}