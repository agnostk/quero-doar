package br.edu.ufabc.querodoar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.ufabc.querodoar.databinding.FragmentOngListBinding
import br.edu.ufabc.querodoar.databinding.OngListItemBinding
import br.edu.ufabc.querodoar.model.ONG

class OngListFragment : Fragment() {
    private lateinit var binding: FragmentOngListBinding

    private inner class NoteAdapter(val ongs: List<ONG>) :
        RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

        /**
         * View Holder.
         */
        private inner class NoteHolder(itemBinding: OngListItemBinding) :
            RecyclerView.ViewHolder(itemBinding.root) {
            val title = itemBinding.ongListItemTitle
            val value = itemBinding.ongListItemValue

//            init {
//                itemBinding.root.setOnClickListener {
//                    setFragmentResult(
//                        itemClickedKey,
//                        bundleOf(itemClickedPosition to bindingAdapterPosition)
//                    )
//                }
//            }
        }

        /**
         * Create a view holder.
         */
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): NoteHolder =
            NoteHolder(
                OngListItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

        /**
         * Populate a view holder with data.
         */
        override fun onBindViewHolder(holder: NoteHolder, position: Int) {
            val ong = ongs[position]

            holder.title.text = ong.name
            holder.value.text = "Meta: R$ ${String.format("%.2f", ong.goal)}"
        }

        /**
         * The total quantity of items in the list.
         */
        override fun getItemCount(): Int = ongs.size

        /**
         * Called when a view holder is recycled.
         */
        override fun onViewRecycled(holder: NoteHolder) {
            super.onViewRecycled(holder)
//            Log.d("APP", "Recycled holder at position ${holder.bindingAdapterPosition}")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOngListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val ongs : List<ONG> = listOf(
            ONG(getString(R.string.ong_name), "", 10f, 2350f),
            ONG(getString(R.string.ong_name), "", 10f, 2350f),
            ONG(getString(R.string.ong_name), "", 10f, 2350f)
        )

        binding.recyclerviewOngList.apply {
            adapter = NoteAdapter(ongs)
        }
    }
}