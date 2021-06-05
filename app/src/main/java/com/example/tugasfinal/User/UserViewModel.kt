package com.example.tugasfinal.User

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class UserViewModel(application: Application): AndroidViewModel(application) {

    private var repository = PenumpangRepository(application)
    private var penumpang: LiveData<List<PenumpangEntity>>? = repository.getAllPenumpang()

    fun insertPenumpang(penumpangEntity: PenumpangEntity) {
        repository.insert(penumpangEntity)
    }

    fun getPenumpang(): LiveData<List<PenumpangEntity>>? {
        return penumpang
    }

    fun deletePenumpang(penumpangEntity: PenumpangEntity) {
        repository.delete(penumpangEntity)
    }

    fun updatePenumpang(penumpangEntity: PenumpangEntity) {
        repository.update(penumpangEntity)
    }

}