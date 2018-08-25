package com.haduken.japan.marvelaac.view.comicdata

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.haduken.japan.marvelaac.extensions.get


class ComicDataFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get<ComicDataViewModel>()
    }
}