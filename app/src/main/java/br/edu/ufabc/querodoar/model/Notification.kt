package br.edu.ufabc.querodoar.model

/**
 * Transfer (domain) object.
 */
data class Notification(
    var id: Long,
    var content: String,
    var dateReceived: String
)