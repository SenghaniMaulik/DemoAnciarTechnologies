package com.demo.anciartechnologies.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.demo.anciartechnologies.R


fun ImageView.loadImageFromUrl(imageUrl: String?, placeHolder: Int? = null) {
    Glide
        .with(this.context)
        .load(imageUrl)
        .centerCrop()
        .placeholder(placeHolder ?: R.drawable.ic_error_placeholder)
        .error(placeHolder ?: R.drawable.ic_error_placeholder)
        .into(this)
}
