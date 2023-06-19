package com.binayshaw7777.ionageassignment.ui.movies_listing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.binayshaw7777.ionageassignment.R
import com.binayshaw7777.ionageassignment.adapter.MoviesAdapter
import com.binayshaw7777.ionageassignment.base.ViewModelFactory
import com.binayshaw7777.ionageassignment.databinding.FragmentMoviesBinding
import com.binayshaw7777.ionageassignment.utils.Constants
import com.binayshaw7777.ionageassignment.utils.Logger
import com.binayshaw7777.ionageassignment.utils.hide
import com.binayshaw7777.ionageassignment.utils.show


class MoviesFragment : Fragment() {

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private val moviesViewModel by viewModels<MoviesViewModel> { ViewModelFactory() }
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)

        moviesAdapter = MoviesAdapter(requireActivity()) {
            binding.progressBar.show()
            moviesViewModel.fetchMovieDetailsRequest(it.imdbId)
        }

        initObserver()
        initViews()

        return binding.root
    }

    private fun initViews() {
        binding.apply {
            myToolBar.apply {
                toolbarTitle.text = getString(R.string.netflix)
            }
            moviesRecyclerView.adapter = moviesAdapter
            moviesRecyclerView.layoutManager = GridLayoutManager(requireActivity(), 2)
        }
    }

    private fun initObserver() {
        moviesViewModel.run {
            fetchMovieSearchRequest(Constants.DEFAULT_MOVIE_NAME)
            errorLiveData.observe(viewLifecycleOwner) {
                Logger.debugLog("Error: $it")
            }
            exceptionLiveData.observe(viewLifecycleOwner) {
                Logger.debugLog("Exception: $it")
            }
            movieSearchResponse.observe(viewLifecycleOwner) {
                moviesAdapter.submitList(it.searchResults)
                binding.progressBar.hide()
            }
            movieDetailsResponse.observe(viewLifecycleOwner) {
                binding.progressBar.hide()
                val action =
                    MoviesFragmentDirections.actionMoviesFragmentToMoviesPreviewFragment(it)
                findNavController().navigate(action)
            }
        }
    }


}