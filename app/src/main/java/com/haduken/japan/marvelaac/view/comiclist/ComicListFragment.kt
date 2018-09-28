package com.haduken.japan.marvelaac.view.comiclist

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.haduken.japan.marvelaac.extensions.get


class ComicListFragment : Fragment() {

    private lateinit var viewModel : ComicListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get()
    }

    override fun onStart() {
        super.onStart()
        viewModel.requestComicBookItems()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get<ComicListViewModel>()
        viewModel.comicListData.observe(this, Observer {

        })
    }

}