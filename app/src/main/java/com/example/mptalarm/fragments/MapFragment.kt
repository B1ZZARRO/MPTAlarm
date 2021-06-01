package com.example.mptalarm.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.drawable.AnimationDrawable
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.beust.klaxon.json
import com.example.mptalarm.MapsActivity
import com.example.mptalarm.R
import com.example.mptalarm.ResponseBody.APIInterface
import com.example.mptalarm.ResponseBody.UrlModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.fragment_map.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var currentLocation: Location
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var permissionCode = 101
    var location : LatLng? = null
    var lat1 : String = ""
    var lng1 : String = ""
    var durationNezh : String = ""
    var durationNah : String = ""
    val nezh = "55.71237800579656, 37.47664034961596"
    val nah = "55.66502751738058, 37.597936146381635"
    val nezh1 = LatLng(55.71237800579656, 37.47664034961596)
    var yourloc : String = ""


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_address.setOnClickListener {
            response()
        }
        loadData()
        Log.i("TAG", "onViewCreated: ")
        txt_address.text = "До Нежинская, 7 : ${durationNezh}"
        txt_address1.text = "До Нахимовский, 21 : ${durationNah}"
        val mapFragment = childFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment?.getMapAsync(this)
    }

    private fun response() {
        val builder = Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com")
                .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build()
        val apiInterface : APIInterface = retrofit.create<APIInterface>(APIInterface::class.java)
        val call : retrofit2.Call<UrlModel> = apiInterface.getRoute(yourloc,nezh,true, "transit")
        call.enqueue(object : Callback<UrlModel> {
            override fun onFailure(call: retrofit2.Call<UrlModel>, t: Throwable) {
                Log.i("qwer", t.message.toString())
            }
            override fun onResponse(call: Call<UrlModel>, response: Response<UrlModel>) {
                val statusResponse = response.body()!!
                durationNezh = statusResponse.routes[0]!!.legs[0]!!.duration!!.text!!.toString()
                txt_address.text = "До Нежинская, 7 : ${durationNezh}"
                saveData()
            }
        })
        val call1 : retrofit2.Call<UrlModel> = apiInterface.getRoute(yourloc,nah,true, "transit")
        call1.enqueue(object : Callback<UrlModel> {
            override fun onFailure(call: retrofit2.Call<UrlModel>, t: Throwable) {
                Log.i("qwer", t.message.toString())
            }
            override fun onResponse(call: Call<UrlModel>, response: Response<UrlModel>) {
                val statusResponse = response.body()!!
                durationNah = statusResponse.routes[0]!!.legs[0]!!.duration!!.text!!.toString()
                txt_address1.text = "До Нахимовский, 21 : ${durationNah}"
                saveData()
            }
        })
    }

    private fun saveData() {
        val mainActivity = this.activity as MapsActivity
        val insertedText = lat1
        val insertedText1 = lng1
        val insertedText2 = durationNezh
        val insertedText3 = durationNah
        val sharedPreferences = mainActivity.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("string_KEY", insertedText.toString())
            putString("string1_KEY", insertedText1.toString())
            putString("string2_KEY", insertedText2.toString())
            putString("string3_KEY", insertedText3.toString())
        }.apply()
    }

    private  fun loadData() {
        val mainActivity = this.activity as MapsActivity
        val sharedPreferences = mainActivity.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("string_KEY", "")
        val savedString1 = sharedPreferences.getString("string1_KEY", "")
        val savedString2 = sharedPreferences.getString("string2_KEY", "")
        val savedString3 = sharedPreferences.getString("string3_KEY", "")
        lat1 = savedString!!
        lng1 = savedString1!!
        durationNezh = savedString2!!
        durationNah = savedString3!!
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        if (lat1 != "" && lng1 != "") {
            location = LatLng(lat1.toString().toDouble(), lng1.toString().toDouble())
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
            mMap.addMarker(MarkerOptions().position(location!!))
        } else {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nezh1, 15f))
        }
        mMap.setOnMapClickListener(object : GoogleMap.OnMapClickListener {
            override fun onMapClick(latlng: LatLng) {
                mMap.clear()
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latlng))
                location = LatLng(latlng.latitude, latlng.longitude)
                mMap.addMarker(MarkerOptions().position(location!!))
                lat1 = location!!.latitude.toString()
                lng1 = location!!.longitude.toString()
                yourloc = "${lat1}, ${lng1}"
            }
        })
    }
}