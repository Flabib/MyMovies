package id.practice.mymovies.ui.main.pages.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.practice.mymovies.BuildConfig
import id.practice.mymovies.data.entity.Movie
import id.practice.mymovies.databinding.ItemRowCatalogueBinding
import id.practice.mymovies.ui.detail.DetailActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var listData: List<Movie> = listOf()

    inner class MovieViewHolder(private val itemRowCatalogueBinding: ItemRowCatalogueBinding) : RecyclerView.ViewHolder(itemRowCatalogueBinding.root) {
        fun bind(movie: Movie) {
            with(itemView) {
                itemRowCatalogueBinding.title.text = movie.title

                if (movie.poster?.contains("@drawable/") == true) {
                    Glide.with(this)
                            .load(resources.getIdentifier(movie.poster.split("/")[1], "drawable", context.packageName))
                            .into(itemRowCatalogueBinding.poster)
                } else {
                    Glide.with(this)
                            .load(BuildConfig.IMG_URL + movie.poster)
                            .into(itemRowCatalogueBinding.poster)
                }

                setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, movie)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapter.MovieViewHolder {
        val itemRowCatalogueBinding = ItemRowCatalogueBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MovieViewHolder(itemRowCatalogueBinding)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}