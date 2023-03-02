package com.example.internetapidata

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("set_status")
fun setStatus(iv: ImageView, status: MarsApiStatus) {
    when (status) {
        MarsApiStatus.LOADING -> iv.setImageResource(R.drawable.loading)
        MarsApiStatus.ERROR -> iv.setImageResource(R.drawable.ic_error)
        MarsApiStatus.DONE -> iv.setImageResource(R.drawable.ic_done)
    }
}