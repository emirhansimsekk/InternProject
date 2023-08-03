package com.emirhansimsek.internproject.Controller

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.emirhansimsek.internproject.Model.Celebrity

@Dao
interface CelebrityDAO {
    @Insert
    fun insert(celebrity: Celebrity.User.Celebrities)

    @Query("Delete from Celebrities where name_surname= :name_surname")
    fun delete(name_surname:String?)

    @Query("Select count(*) from Celebrities Where name_surname LIKE :name_surname")
    fun getCelebrity(name_surname:String): Int?

    @Query("INSERT INTO Celebrities (name_surname, age, gender, phone_number, email, birthdate) " +
        "VALUES (:name_surname, :age, :gender, :phone_number, :email, :birthdate)")
    fun insertCelebrity(name_surname:String?, age: String?, gender: String?, phone_number: String?, email: String?, birthdate: String?)
}