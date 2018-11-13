package com.masaibar.dummynewspicksuisample

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter


class HogeAdapter(
    private val context: Context,
    fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager) {

    enum class Page {
        Top,
        NewArrival
    }


    override fun getItem(position: Int): Fragment = when (position) {
        Page.Top.ordinal -> {
            ScrollableFragment.newInstance("Top")
        }
        Page.NewArrival.ordinal -> {
            ScrollableFragment.newInstance("NewArrival")
        }
        else -> {
            throw IllegalArgumentException("illegal position: $position")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        Page.Top.ordinal -> {
            "Top"
        }
        Page.NewArrival.ordinal -> {
            "NewArrival"
        }
        else -> {
            throw IllegalArgumentException("illegal position: $position")
        }
    }

    override fun getCount(): Int =
        Page.values().size
}