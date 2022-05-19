package br.edu.ufabc.querodoar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import br.edu.ufabc.querodoar.OngListFragment
import br.edu.ufabc.querodoar.databinding.FragmentConfirmDonateBinding

class ConfirmDonate : Fragment() {

    private var _binding: FragmentConfirmDonateBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentConfirmDonateBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val ongRecebedoraContainer = binding.ongRecebedoraFragmentContainer
        childFragmentManager.commit {
            replace(ongRecebedoraContainer.id, OngListFragment())
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}