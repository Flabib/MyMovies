package id.practice.mymovies.ui.main.pages.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import id.practice.mymovies.R
import kotlinx.android.synthetic.main.fragment_tv.*

class TVFragment : Fragment() {

    private lateinit var tvViewModel: TVViewModel
    private var adapter = TVAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_tv.setHasFixedSize(true)
        rv_tv.layoutManager = GridLayoutManager(context, 2)
        rv_tv.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tvViewModel =
            ViewModelProvider(this).get(TVViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_tv, container, false)
        tvViewModel.listData.observe(viewLifecycleOwner, {
            adapter.listData = it
        })
        return root
    }
}