package ru.netology.timetotravel.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import ru.netology.timetotravel.R
import ru.netology.timetotravel.databinding.FragmentItemDetailsBinding
import ru.netology.timetotravel.utils.formatDate
import ru.netology.timetotravel.utils.log
import ru.netology.timetotravel.viewmodel.FlightViewModel

class ItemDetails : Fragment(R.layout.fragment_item_details) {

    private lateinit var binding: FragmentItemDetailsBinding

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentItemDetailsBinding.bind(view)

        val viewModel: FlightViewModel by activityViewModels()

        val position = requireArguments().get("position") as Int

        binding.like.setOnClickListener { viewModel.onLikeClicked(position) }

        viewModel.item.observe(viewLifecycleOwner) {
            log(it?.searchToken)

            binding.apply {
                startCity.text = it?.startCity
                endCity.text = it?.endCity
                detailsStartDate.text = formatDate(it?.startDate.toString())
                detailsEndDate.text = formatDate(it?.endDate.toString())
                detailsPrice.text = "${it?.price} ${getString(R.string.currency)}"
                searchToken.text = it?.searchToken

                like.setIconResource(
                    if (it!!.liked) R.drawable.ic_baseline_thumb_up_24
                    else R.drawable.ic_baseline_thumb_up_off_alt_24
                )

                back.setOnClickListener { findNavController().popBackStack() }
            }
        }
    }
}