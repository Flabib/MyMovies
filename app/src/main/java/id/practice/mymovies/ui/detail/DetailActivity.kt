package id.practice.mymovies.ui.detail

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.practice.mymovies.R
import id.practice.mymovies.data.Movie
import id.practice.mymovies.data.TV
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV = "extra_tv"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
        )
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        title = ""

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
        if (movie != null) {
            tvtitle.text = movie.title
            original_language.text = movie.originalLanguage
            overview.text = movie.description
            release_date.text = movie.releaseDate
            runtime.text = movie.runtime

            Glide.with(this)
                .load(
                    resources.getIdentifier(
                        movie.poster.split("/")[1],
                        "drawable",
                        applicationContext.packageName
                    )
                )
                .into(poster)

            Glide.with(this)
                .load(
                    resources.getIdentifier(
                        movie.poster.split("/")[1],
                        "drawable",
                        applicationContext.packageName
                    )
                )
                .into(backdrop)
        }

        val tv = intent.getParcelableExtra<TV>(EXTRA_TV)
        if (tv != null) {
            tvtitle.text = tv.title
            original_language.text = tv.originalLanguage
            overview.text = tv.description
            release_date.text = tv.releaseDate
            runtime.text = tv.runtime

            Glide.with(this)
                .load(
                    resources.getIdentifier(
                        tv.poster.split("/")[1],
                        "drawable",
                        applicationContext.packageName
                    )
                )
                .into(poster)

            Glide.with(this)
                .load(
                    resources.getIdentifier(
                        tv.poster.split("/")[1],
                        "drawable",
                        applicationContext.packageName
                    )
                )
                .into(backdrop)
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