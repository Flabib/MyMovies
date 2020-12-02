package id.practice.mymovies.ui.main.pages.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import id.practice.mymovies.MyApplication
import id.practice.mymovies.databinding.FragmentTvBinding
import javax.inject.Inject

class TVFragment : Fragment() {

    @Inject lateinit var tvViewModel: TVViewModel
    private var adapter = TVAdapter()
    private var _fragmentTvBinding: FragmentTvBinding? = null
    private val fragmentTvBinding get() = _fragmentTvBinding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentTvBinding.rvTv.setHasFixedSize(true)
        fragmentTvBinding.rvTv.layoutManager = GridLayoutManager(context, 2)
        fragmentTvBinding.rvTv.adapter = adapter

        tvViewModel.getAllTVs().observe(viewLifecycleOwner, {
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
        _fragmentTvBinding = FragmentTvBinding.inflate(inflater, container, false)

        return fragmentTvBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _fragmentTvBinding = null
    }
}