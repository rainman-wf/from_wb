package ru.netology.timetotravel.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.netology.timetotravel.R
import ru.netology.timetotravel.databinding.FragmentItemDetailsBinding

class ItemDetails: Fragment(R.layout.fragment_item_details) {

    private lateinit var binding: FragmentItemDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentItemDetailsBinding.bind(view)

        binding.tv.text = requireArguments().get("position").toString()
    }
}