package br.edu.ufabc.querodoar.ui.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import br.edu.ufabc.querodoar.databinding.FragmentNotificationItemBinding

class NotificationItemFragment: Fragment() {

    private lateinit var binding: FragmentNotificationItemBinding
    private val viewModel: NotificationsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotificationItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        try {
            viewModel.clickedItemId.value?.let { contactId ->
                viewModel.getNoficationsById(contactId)?.let { notification ->
                    binding.notificationItemContent.text = notification.content
                    binding.notificationItemDatereceived.text = notification.dateReceived
                } ?: throw Exception("Failed to find contact with id $contactId")
            } ?: throw Exception("Could not obtain contact id")
        } catch (e: Exception) {
            Log.e("VIEW", "Failed to create item detail view", e)
            binding.root.visibility = View.INVISIBLE
        }

    }
}