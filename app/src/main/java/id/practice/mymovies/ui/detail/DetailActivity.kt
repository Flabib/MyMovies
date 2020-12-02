package id.practice.mymovies.ui.detail

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.practice.mymovies.BuildConfig
import id.practice.mymovies.data.entity.Movie
import id.practice.mymovies.data.entity.TV
import id.practice.mymovies.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var activityDetailBinding: ActivityDetailBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV = "extra_tv"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
        )

        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        title = ""

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
        if (movie != null) {
            activityDetailBinding.tvtitle.text = movie.title
            activityDetailBinding.originalLanguage.text = movie.originalLanguage
            activityDetailBinding.overview.text = movie.description
            activityDetailBinding.releaseDate.text = movie.releaseDate
            activityDetailBinding.voteAverage.text = movie.voteAverage

            if (movie.poster?.contains("@drawable/") == true) {
                Glide.with(this)
                        .load(resources.getIdentifier(movie.poster.split("/")[1], "drawable", applicationContext.packageName))
                        .into(activityDetailBinding.poster)
            } else {
                Glide.with(this)
                        .load(BuildConfig.IMG_URL + movie.poster)
                        .into(activityDetailBinding.poster)
            }

            if (movie.poster?.contains("@drawable/") == true) {
                Glide.with(this)
                        .load(resources.getIdentifier(movie.poster.split("/")[1], "drawable", applicationContext.packageName))
                        .into(activityDetailBinding.backdrop)
            } else {
                Glide.with(this)
                        .load(BuildConfig.IMG_URL + movie.backdrop)
                        .into(activityDetailBinding.backdrop)
            }
        }

        val tv = intent.getParcelableExtra<TV>(EXTRA_TV)
        if (tv != null) {
            activityDetailBinding.tvtitle.text = tv.title
            activityDetailBinding.originalLanguage.text = tv.originalLanguage
            activityDetailBinding.overview.text = tv.description
            activityDetailBinding.releaseDate.text = tv.releaseDate
            activityDetailBinding.voteAverage.text = tv.voteAverage

            if (tv.poster?.contains("@drawable/") == true) {
                Glide.with(this)
                        .load(resources.getIdentifier(tv.poster.split("/")[1], "drawable", applicationContext.packageName))
                        .into(activityDetailBinding.poster)
            } else {
                Glide.with(this)
                        .load(BuildConfig.IMG_URL + tv.poster)
                        .into(activityDetailBinding.poster)
            }

            if (tv.poster?.contains("@drawable/") == true) {
                Glide.with(this)
                        .load(resources.getIdentifier(tv.poster.split("/")[1], "drawable", applicationContext.packageName))
                        .into(activityDetailBinding.backdrop)
            } else {
                Glide.with(this)
                        .load(BuildConfig.IMG_URL + tv.backdrop)
                        .into(activityDetailBinding.backdrop)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()

                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}