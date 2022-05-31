package ru.netology.timetotravel.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.netology.timetotravel.R
import ru.netology.timetotravel.adapter.FlightAdapter
import ru.netology.timetotravel.adapter.OnFlightClickListener
import ru.netology.timetotravel.databinding.FragmentRootBinding
import ru.netology.timetotravel.utils.log
import ru.netology.timetotravel.viewmodel.FlightViewModel

class Root : Fragment(R.layout.fragment_root) {

    private lateinit var binding: FragmentRootBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRootBinding.bind(view)


        binding.root.setOnClickListener { log("on root") }
        binding.flightList.setOnClickListener { log("rv") }
        binding.baseLayout.setOnClickListener { log("constrain") }
        val viewModel: FlightViewModel by viewModels()

        val flightAdapter = FlightAdapter(
            object : OnFlightClickListener {
                override fun onLike(position: Int) {
                    viewModel.onLikeClicked(position)
                }

                override fun onDetails(position: Int) {
                    findNavController().navigate(R.id.action_root_to_itemDetails,
                        bundleOf("position" to position))
                }
            }
        )

        binding.flightList.adapter = flightAdapter

        viewModel.data.observe(viewLifecycleOwner) { flightAdapter.submitList(it) }
    }
}

