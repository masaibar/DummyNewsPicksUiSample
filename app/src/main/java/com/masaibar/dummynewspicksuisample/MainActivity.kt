package com.masaibar.dummynewspicksuisample

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import com.masaibar.dummynewspicksuisample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)


        val toggle = object : ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        ) {
        }

        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_nav_hoge -> {
                    switchFragment(
                        HogeFragment.newInstance(),
                        HogeFragment::class.java.simpleName
                    )
                    true
                }
                R.id.bottom_nav_fuga -> {
                    switchFragment(
                        FugaFragment.newInstance(),
                        FugaFragment::class.java.simpleName
                    )
                    true
                }
                else -> false
            }
        }
        binding.bottomNavigationView.selectedItemId = R.id.bottom_nav_hoge
    }

    private fun switchFragment(target: Fragment, tag: String) {
        supportFragmentManager.beginTransaction().apply {
            val found = supportFragmentManager.findFragmentByTag(tag)
            if (found == null) {
                add(
                    R.id.container,
                    target,
                    tag
                )
            } else {
                show(found)
            }
            supportFragmentManager.fragments.forEach { fragment ->
                if (fragment::class.java.simpleName != target::class.java.simpleName) {
                    hide(fragment)
                }
            }
        }.commitNow()
    }
}
