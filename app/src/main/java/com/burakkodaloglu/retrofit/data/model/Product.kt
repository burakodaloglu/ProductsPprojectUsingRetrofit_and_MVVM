package com.burakkodaloglu.retrofit.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val description: String?,
    val id: String?,
    val image: String?,
    val price: Double?,
    val title: String?
):Parcelable
