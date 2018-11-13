package com.masaibar.dummynewspicksuisample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.masaibar.dummynewspicksuisample.databinding.FragmentFugaBinding


class FugaFragment : Fragment() {

    companion object {
        fun newInstance(): FugaFragment = FugaFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentFugaBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }
}