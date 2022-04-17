package br.edu.ufabc.querodoar

import android.app.Application
import br.edu.ufabc.querodoar.model.Repository

class App : Application() {
    val repository = Repository()
}