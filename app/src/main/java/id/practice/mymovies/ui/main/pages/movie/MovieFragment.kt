package id.practice.mymovies.ui.main.pages.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import id.practice.mymovies.MyApplication
import id.practice.mymovies.databinding.FragmentMovieBinding
import javax.inject.Inject

class MovieFragment : Fragment() {

    @Inject lateinit var movieViewModel: MovieViewModel
    private var adapter = MovieAdapter()
    private var _fragmentMovieBinding: FragmentMovieBinding? = null
    private val fragmentMovieBinding get() = _fragmentMovieBinding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentMovieBinding.rvMovie.setHasFixedSize(true)
        fragmentMovieBinding.rvMovie.layoutManager = GridLayoutManager(context, 2)
        fragmentMovieBinding.rvMovie.adapter = adapter

        movieViewModel.getAllMovies().observe(viewLifecycleOwner, {
            adapter.listData = it
            adapter.notifyDataSetChanged()
        })
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        (context?.applicationContext as MyApplication).appComponent?.inject(this)
        _fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false)

        return fragmentMovieBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _fragmentMovieBinding = null
    }
}