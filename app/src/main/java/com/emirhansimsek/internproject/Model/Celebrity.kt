package com.emirhansimsek.internproject.Model

import com.google.gson.annotations.SerializedName

data class Celebrity(
    @SerializedName("user_type")
    val user_type: User

) {
    data class User(
        @SerializedName("man")
        val man: List<Actors>,
        @SerializedName("woman")
        val woman: List<Actresses>

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
            var birthdate: String?,
            @SerializedName("image")
            var image: String?,


        )

        data class Actresses(
            @SerializedName("name_surname")
            var name_surname: String?,
            @SerializedName("age")
            var age: String?,
            @SerializedName("phone_number")
            var phone_number: String?,
            @SerializedName("email")
            var email: String?,
            @SerializedName("birthdate")
            var birthdate: String?,
            @SerializedName("image")
            var image: String?
        )
    }




}
