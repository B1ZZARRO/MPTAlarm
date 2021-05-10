package com.example.mptalarm.ResponseBody

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class UrlModel {
    @SerializedName("routes")
    @Expose var routes = ArrayList<Routes>()
    @SerializedName("status")
    @Expose var status : String? = null
}

class Routes {
    @SerializedName("legs")
    @Expose var legs = ArrayList<Legs>()
}

class Legs {
    @SerializedName("duration")
    @Expose var duration : Duration? = null
}

class Duration {
    @SerializedName("text")
    @Expose var text: String? = null
}