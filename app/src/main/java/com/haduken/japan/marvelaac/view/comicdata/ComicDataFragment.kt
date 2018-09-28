package com.haduken.japan.marvelaac.view.comicdata

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.haduken.japan.marvelaac.extensions.get


class ComicDataFragment : Fragment() {

    private lateinit var viewModel : ComicDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get()
    }

    override fun onStart() {
        super.onStart()
        viewModel.requestComicInfo()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.comicBookData.observe(this, Observer {

        })
    }
}