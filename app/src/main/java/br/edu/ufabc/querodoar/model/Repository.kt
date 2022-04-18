package br.edu.ufabc.querodoar.model

class Repository {

    private var notifications: List<Notification> = listOf(Notification(1L,"A ONG que você apoia “Lar dos gatos” adicionou um novo evento: Feira de Adoção em 04/07.", "10:20 10/07/2022")
    ,Notification(2L,"A ONG que você apoia “Lar dos gatos” adicionou um novo evento: Feira de Adoção em 04/07.", "10:20 10/07/2022")
    ,Notification(3L,"A ONG que você apoia “Lar dos gatos” adicionou um novo evento: Feira de Adoção em 04/07.", "10:20 10/07/2022")
    ,Notification(4L,"A ONG que você apoia “Lar dos gatos” adicionou um novo evento: Feira de Adoção em 04/07.", "10:20 10/07/2022")
    ,Notification(5L,"A ONG que você apoia “Lar dos gatos” adicionou um novo evento: Feira de Adoção em 04/07.", "10:20 10/07/2022")
    ,Notification(6L,"A ONG que você apoia “Lar dos gatos” adicionou um novo evento: Feira de Adoção em 04/07.", "10:20 10/07/2022"))

    fun getAllNotifications(): List<Notification> {
        return notifications
    }

    fun getNotificationById(id: Long) = notifications.find {
        it.id == id
    }

}