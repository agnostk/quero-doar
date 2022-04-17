package br.edu.ufabc.querodoar.model

class Repository {

    fun getAllNotifications(): List<Notification> {
        lateinit var notes: List<Notification>

        notes = listOf(Notification(1L,"A ONG que você apoia “Lar dos gatos” adicionou um novo evento: Feira de Adoção em 04/07.", "10:20 10/07/2022")
                ,Notification(2L,"A ONG que você apoia “Lar dos gatos” adicionou um novo evento: Feira de Adoção em 04/07.", "10:20 10/07/2022")
                ,Notification(3L,"A ONG que você apoia “Lar dos gatos” adicionou um novo evento: Feira de Adoção em 04/07.", "10:20 10/07/2022"))

        return notes
    }

}