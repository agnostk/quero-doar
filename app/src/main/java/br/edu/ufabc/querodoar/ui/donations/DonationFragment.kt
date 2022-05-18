package br.edu.ufabc.querodoar.ui.donations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import br.edu.ufabc.querodoar.OngListFragment
import br.edu.ufabc.querodoar.databinding.FragmentDonationBinding

class DonationFragment : Fragment() {

    private var _binding: FragmentDonationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val donationViewModel =
            ViewModelProvider(this).get(DonationViewModel::class.java)

        _binding = FragmentDonationBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val ongAssinadasContainer = binding.ongAssinadasFragmentContainer
        childFragmentManager.commit {
            replace(ongAssinadasContainer.id, OngListFragment())
        }

        val ongHistoricoContainer = binding.ongHistoricoFragmentContainer
        childFragmentManager.commit {
            replace(ongHistoricoContainer.id, OngListFragment())
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}