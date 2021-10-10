package com.example.mvvmexploration.explore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexploration.databinding.FragmentExploreBinding
import com.example.mvvmexploration.explore.ExploreViewModel
import com.example.mvvmexploration.explore.usecase.Result
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExploreFragment : Fragment() {

    private val exploreViewModel: ExploreViewModel by viewModels()

    private var _binding: FragmentExploreBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter = CarouselAdapter()
    private val mainAdapter = MainCarouselAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.carouselMainVp.adapter = mainAdapter
        TabLayoutMediator(binding.carouselMainTl, binding.carouselMainVp) { _, _ ->
            // Some implementation
        }.attach()

        binding.carouselHelpRv.adapter = adapter
        binding.carouselHelpRv.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        exploreViewModel.result.observe(viewLifecycleOwner) { result ->
            // TODO implement intermediate states
            if (result is Result.UiUpdate) adapter.update(result.list)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
