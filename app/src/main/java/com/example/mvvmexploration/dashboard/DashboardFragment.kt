package com.example.mvvmexploration.dashboard

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mvvmexploration.databinding.FragmentDashboardBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class DashboardFragment : Fragment() {

    private val dashboardViewModel by viewModels<DashboardViewModel>()
    private val binding by viewBinding(FragmentDashboardBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        super.onViewCreated(view, savedInstanceState)
    }
}
