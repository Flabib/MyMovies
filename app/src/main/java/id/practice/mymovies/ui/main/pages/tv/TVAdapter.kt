package id.practice.mymovies.ui.main.pages.tv

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.practice.mymovies.R
import id.practice.mymovies.data.TV
import id.practice.mymovies.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.item_row_catalogue.view.*

class TVAdapter : RecyclerView.Adapter<TVAdapter.TVViewHolder>() {
    var listData: List<TV> = listOf()

    inner class TVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tv: TV) {
            with(itemView) {
                title.text = tv.title
                Glide.with(this)
                    .load(resources.getIdentifier(tv.poster.split("/")[1], "drawable", context.packageName))
                    .into(poster)

                setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TV, tv)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TVAdapter.TVViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_catalogue, parent, false)

        return TVViewHolder(view)
    }

    override fun onBindViewHolder(holder: TVAdapter.TVViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}