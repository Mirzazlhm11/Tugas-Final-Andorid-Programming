package com.example.tugasfinal.User

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PenumpangDao {

    @Query("SELECT * FROM penumpang_table")
    fun getAllPenumpang(): LiveData<List<PenumpangEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPenumpang(penumpangEntity: PenumpangEntity)

    @Update
    fun updatePenumpang(penumpangEntity: PenumpangEntity)

    @Delete
    fun deletePenumpang(penumpangEntity: PenumpangEntity)
}