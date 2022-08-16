package com.githab.laravish.lessonmvp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(var id : Long, var login : String) : Parcelable
