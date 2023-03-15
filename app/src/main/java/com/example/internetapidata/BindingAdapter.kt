package com.example.internetapidata

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("set_status")
fun setStatus(iv: ImageView, status: MarsApiStatus) {
    when (status) {
        MarsApiStatus.LOADING -> iv.setImageResource(R.drawable.loading)
        MarsApiStatus.ERROR -> iv.setImageResource(R.drawable.ic_error)
        MarsApiStatus.DONE -> iv.setImageResource(R.drawable.ic_done)
    }
}

@BindingAdapter("img_url")
fun setImageUrl(iv: ImageView, url: String) {
    Log.d("Network", "Url: $url")
    val clean_url = url.toUri().buildUpon().scheme("https").build()
    iv.load(clean_url) {
        crossfade(true)
        crossfade(1000)
        placeholder(R.drawable.ic_placeholder_100)
    }
}

@BindingAdapter("img_type")
fun setIconType(iv: ImageView, type: String) {
    when (type) {
        "buy" -> iv.setImageResource(R.drawable.ic_buy_24)
        "rent" -> iv.setImageResource(R.drawable.ic_sell_24)
    }
}

@BindingAdapter("price")
fun setPrice(tv: TextView, price: Double) {
    tv.text = "$${price}"
}