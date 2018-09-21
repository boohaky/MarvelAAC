package com.haduken.japan.marvelaac.view.comiclist

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.haduken.japan.marvelaac.extensions.get


class ComicListFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get<ComicListViewModel>()
        viewModel.comicListData.observe(this, Observer {

        })
    }

}