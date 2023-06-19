package com.binayshaw7777.ionageassignment.ui.movies_preview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.binayshaw7777.ionageassignment.R
import com.binayshaw7777.ionageassignment.databinding.FragmentMoviesPreviewBinding
import com.binayshaw7777.ionageassignment.model.MovieDetails
import com.binayshaw7777.ionageassignment.ui.MainActivity
import com.binayshaw7777.ionageassignment.utils.show
import com.bumptech.glide.Glide


class MoviesPreviewFragment : Fragment() {

    private var _binding: FragmentMoviesPreviewBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<MoviesPreviewFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesPreviewBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun initView() {
        val movieDetails: MovieDetails = args.moviesDetails
        binding.apply {

            //Toolbar
            myToolBar.apply {
                toolbarTitle.text = getString(R.string.netflix)
            }

            //Movie Details
            Glide.with(requireActivity())
                .load(movieDetails.poster)
                .placeholder(R.drawable.ic_launcher_background)
                .into(moviePosterImageView)

            movieNameTextView.text = movieDetails.title
            movieDirectorNameTextView.text = movieDetails.director
            movieReleaseYearTextView.text = "Release on: ${movieDetails.released}"
            movieRatingTextView.text = movieDetails.imdbRating
            movieActorsNameTextView.text = " ${movieDetails.actors}"
            movieDescriptionTextView.text = " ${movieDetails.plot}"
            movieGenreTextView.text = " ${movieDetails.genre}"


        }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        // This callback will only be called when MyFragment is at least Started.
//        val callback: OnBackPressedCallback =
//            object : OnBackPressedCallback(true /* enabled by default */) {
//                override fun handleOnBackPressed() {
//                    // Handle the back button event
//                    NavHostFragment.findNavController(this@MoviesPreviewFragment).popBackStack()
//                }
//            }
//        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
//    }


}