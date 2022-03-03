package com.tp.testcoppel.ui.utils

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.tp.testcoppel.R
import com.tp.testcoppel.ui.utils.defaultUtils.IMG_DEFAULT
import de.hdodenhof.circleimageview.CircleImageView

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

@BindingAdapter("civ_imageUrl")
fun CircleImageView.loadImage(url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(context).load(url).into(this)
    }
}

@BindingAdapter("imageURL")
fun ImageView.loadImage(url: String?) {
    if (!url.isNullOrEmpty()) {
        Log.d("TAGGGGGG", "url : $url")
        Glide.with(context).load(url).placeholder(R.drawable.marvel).into(this)
    }
}

fun ImageView.loadImage2(url: String?) {
    if (!url.isNullOrEmpty()) {
        Log.d("TAGGGGGG", "url : $url")
        Glide.with(context).load(url).placeholder(R.drawable.marvel).into(this)
    }
}

