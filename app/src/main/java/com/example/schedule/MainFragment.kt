package com.example.schedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import com.example.schedule.databinding.FragmentMainBinding
import com.example.schedule.screens.ScheduleFragment

class MainFragment : Fragment() {
    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnNavigation?.setOnItemSelectedListener {
            changeTab(it.itemId)
            true
        }

        changeTab(R.id.week_schedule)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    private fun changeTab(@IdRes id: Int) {
        val navHostId = binding?.container?.id
        navHostId ?: return
        val transaction = childFragmentManager.beginTransaction()
        when (id) {
            R.id.week_schedule, ->
                transaction.replace(navHostId, ScheduleFragment(true))

            R.id.today_schedule ->
                transaction.replace(navHostId, ScheduleFragment(false))
        }
        transaction.commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment().apply {

            }
    }
}