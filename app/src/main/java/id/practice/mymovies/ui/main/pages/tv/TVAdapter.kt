package id.practice.mymovies.ui.main.pages.tv

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.practice.mymovies.BuildConfig
import id.practice.mymovies.data.entity.TV
import id.practice.mymovies.databinding.ItemRowCatalogueBinding
import id.practice.mymovies.ui.detail.DetailActivity

class TVAdapter : RecyclerView.Adapter<TVAdapter.TVViewHolder>() {
    var listData: List<TV> = listOf()

    inner class TVViewHolder(private val itemRowCatalogueBinding: ItemRowCatalogueBinding) : RecyclerView.ViewHolder(itemRowCatalogueBinding.root) {
        fun bind(tv: TV) {
            with(itemView) {
                itemRowCatalogueBinding.title.text = tv.title

                if (tv.poster?.contains("@drawable/") == true) {
                    Glide.with(this)
                            .load(resources.getIdentifier(tv.poster.split("/")[1], "drawable", context.packageName))
                            .into(itemRowCatalogueBinding.poster)
                } else {
                    Glide.with(this)
                            .load(BuildConfig.IMG_URL + tv.poster)
                            .into(itemRowCatalogueBinding.poster)
                }

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
        val itemRowCatalogueBinding = ItemRowCatalogueBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TVViewHolder(itemRowCatalogueBinding)
    }

    override fun onBindViewHolder(holder: TVAdapter.TVViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}