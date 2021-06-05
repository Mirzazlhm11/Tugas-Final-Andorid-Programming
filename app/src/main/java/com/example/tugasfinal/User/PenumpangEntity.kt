package com.example.tugasfinal.User

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "penumpang_table")
data class PenumpangEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var nama: String,
    var umur: String,
    var alamat: String,
    @ColumnInfo(name = "tempat_keberangkatan")
    var tempatKeberangkatan: String,
    @ColumnInfo(name = "tujuan_keberangkatan")
    var tujuanKeberangkatan: String
)