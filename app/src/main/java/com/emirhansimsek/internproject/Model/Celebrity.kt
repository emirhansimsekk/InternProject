package com.emirhansimsek.internproject.Model

import com.google.gson.annotations.SerializedName

data class Celebrity(
    @SerializedName("users")
    val users: List<Actors>

) {
    data class Actors(
        @SerializedName("name_surname")
        var name_surname: String?,
        @SerializedName("age")
        var age: String?,
        @SerializedName("phone_number")
        var phone_number: String?,
        @SerializedName("email")
        var email: String?,
        @SerializedName("birthdate")
        var birthdate: String?
    )


}
