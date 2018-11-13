package com.masaibar.dummynewspicksuisample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.masaibar.dummynewspicksuisample.databinding.FragmentScrollableBinding


class ScrollableFragment : Fragment() {

    companion object {
        private const val KEY_NAME = "name"
        fun newInstance(name: String): ScrollableFragment = ScrollableFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_NAME, name)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentScrollableBinding.inflate(
            inflater,
            container,
            false
        )

        arguments?.getString(KEY_NAME)?.let {
            binding.textName.text = it
        }

        return binding.root
    }
}