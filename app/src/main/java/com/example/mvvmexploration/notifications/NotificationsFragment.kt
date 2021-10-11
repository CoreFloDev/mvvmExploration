package com.example.mvvmexploration.notifications

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mvvmexploration.R
import com.example.mvvmexploration.databinding.FragmentNotificationsBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class NotificationsFragment : Fragment(R.layout.fragment_notifications) {

    private val notificationsViewModel by viewModels<NotificationsViewModel>()
    private val binding by viewBinding(FragmentNotificationsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        notificationsViewModel.text.observe(viewLifecycleOwner, {
            binding.textNotifications.text = it
        })
        super.onViewCreated(view, savedInstanceState)
    }
}
