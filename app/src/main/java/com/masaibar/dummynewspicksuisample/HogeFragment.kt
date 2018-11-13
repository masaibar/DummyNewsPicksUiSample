package com.masaibar.dummynewspicksuisample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.masaibar.dummynewspicksuisample.databinding.FragmentHogeBinding


class HogeFragment : Fragment() {

    companion object {
        fun newInstance(): HogeFragment = HogeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentHogeBinding.inflate(
            inflater,
            container,
            false
        )

        binding.viewPager.adapter = HogeAdapter(
            requireContext(),
            childFragmentManager
        )
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        return binding.root
    }
}