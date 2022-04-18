package br.edu.ufabc.querodoar.ui.notifications

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.edu.ufabc.querodoar.App

class NotificationsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = (application as App).repository

    val clickedItemId by lazy {
        MutableLiveData<Long?>()
    }

    fun getNoficationsById(id: Long) = repository.getNotificationById(id)

    fun all() = repository.getAllNotifications()

}