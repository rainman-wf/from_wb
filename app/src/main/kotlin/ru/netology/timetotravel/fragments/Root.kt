package ru.netology.timetotravel.fragments

import android.os.Bundle
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewTreeObserver
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import ru.netology.timetotravel.MainActivity
import ru.netology.timetotravel.R
import ru.netology.timetotravel.adapter.FlightAdapter
import ru.netology.timetotravel.adapter.OnFlightClickListener
import ru.netology.timetotravel.databinding.FragmentRootBinding
import ru.netology.timetotravel.viewmodel.FlightViewModel

class Root : Fragment(R.layout.fragment_root) {

    private lateinit var binding: FragmentRootBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRootBinding.bind(view)

        val viewModel: FlightViewModel by activityViewModels()

        val flightAdapter = FlightAdapter(
            object : OnFlightClickListener {
                override fun onLike(position: Int) {
                    viewModel.onLikeClicked(position)
                }

                override fun onDetails(position: Int) {
                    viewModel.onDetailsClicked(position)
                    findNavController().navigate(
                        R.id.action_root_to_itemDetails,
                        bundleOf("position" to position)
                    )
                }
            }
        )

        binding.flightList.apply {
            adapter = flightAdapter
            val animator = itemAnimator
            if (animator is DefaultItemAnimator) animator.supportsChangeAnimations = false
        }

        viewModel.data.observe(viewLifecycleOwner) {
            flightAdapter.submitList(it.toList())
            if (it.isNotEmpty()) (activity as MainActivity)
                .findViewById<ConstraintLayout>(R.id.rootActivity).background = null
        }
    }
}
