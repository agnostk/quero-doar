package br.edu.ufabc.querodoar.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import br.edu.ufabc.querodoar.databinding.FragmentNotificationsBinding
import br.edu.ufabc.querodoar.databinding.NotificationItemBinding
import br.edu.ufabc.querodoar.model.Notification

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: NotificationsViewModel by activityViewModels()

    private inner class NotificationAdapter(val notifications: List<Notification>) : RecyclerView.Adapter<NotificationAdapter.NotificationHolder>() {

        private inner class NotificationHolder(itemBinding: NotificationItemBinding)
            : RecyclerView.ViewHolder(itemBinding.root) {
            val content = itemBinding.notificationListItemContent
            val dateReceived = itemBinding.notificationListItemDatereceived

            init {
                itemBinding.root.setOnClickListener {
                    viewModel.clickedItemId.value = getItemId(bindingAdapterPosition)
                }
            }
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): NotificationHolder =
            NotificationHolder(NotificationItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false))

        override fun onBindViewHolder(holder: NotificationHolder, position: Int) {
            val notification = notifications[position]

            holder.content.text = notification.content
            holder.dateReceived.text = notification.dateReceived
        }

        override fun getItemCount(): Int = notifications.size

        override fun getItemId(position: Int): Long = notifications[position].id
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        activity?.let {
            binding.reclycerviewNotificationList.apply {
                adapter = NotificationAdapter(viewModel.all())
            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}