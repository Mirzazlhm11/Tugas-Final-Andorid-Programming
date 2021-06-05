package com.example.tugasfinal.User

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class PenumpangRepository(application: Application) {

    private val penumpangDao: PenumpangDao
    private var penumpangs: LiveData<List<PenumpangEntity>>? = null

    init {
        val db = UserDatabase.getDatabase(application.applicationContext)
        penumpangDao = db.penumpangDao()
        penumpangs = penumpangDao.getAllPenumpang()
    }

    fun getAllPenumpang(): LiveData<List<PenumpangEntity>>? {
        return penumpangs
    }

    fun insert(penumpang: PenumpangEntity) = runBlocking {
        this.launch(Dispatchers.IO) {
            penumpangDao.insertPenumpang(penumpang)
        }
    }

    fun delete(penumpang: PenumpangEntity) {
        runBlocking {
            this.launch(Dispatchers.IO) {
                penumpangDao.deletePenumpang(penumpang)
            }
        }
    }

    fun update(penumpang: PenumpangEntity) = runBlocking {
        this.launch(Dispatchers.IO) {
            penumpangDao.updatePenumpang(penumpang)
        }
    }

}