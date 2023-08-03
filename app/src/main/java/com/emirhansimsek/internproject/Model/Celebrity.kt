package com.emirhansimsek.internproject.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Celebrity(
    @SerializedName("user_type")
    val user_type: User

) {
    data class User(
        @SerializedName("celebrities")
        val celebrities: List<Celebrities>


    ) {
        @Entity(tableName = "Celebrities")
        data class Celebrities(
            @ColumnInfo(name = "name_surname")
            @SerializedName("name_surname")
            var name_surname: String?,
            @ColumnInfo(name = "age")
            @SerializedName("age")
            var age: String?,
            @ColumnInfo(name = "gender")
            @SerializedName("gender")
            var gender: String?,
            @ColumnInfo(name = "phone_number")
            @SerializedName("phone_number")
            var phone_number: String?,
            @ColumnInfo(name = "email")
            @SerializedName("email")
            var email: String?,
            @ColumnInfo(name = "birthdate")
            @SerializedName("birthdate")
            var birthdate: String?,
            @ColumnInfo(name = "resim")
            @SerializedName("image")
            var resim: String?



        ){
            @PrimaryKey(autoGenerate = true)
            @ColumnInfo(name = "celebrityIDdb")
            var celebrityID: Int = 0

        }




    }




}
