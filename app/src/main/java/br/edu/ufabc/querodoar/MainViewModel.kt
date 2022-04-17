package br.edu.ufabc.querodoar

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = (application as App).repository

    fun allNotifications() = repository.getAll()

}