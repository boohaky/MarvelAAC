package com.haduken.japan.marvelaac.widget.recycler

import android.view.View

abstract class DataRecyclerAdapter<VH : BaseRecylcerAdapter.BaseViewHolder, D> : BaseRecylcerAdapter<VH>() {


    companion object {
        private const val DATA_VIEW_TYPE = -1
    }

    var data: List<D>? = null

    /**
     * Method for getting proper view type for view holder.
     * Data view holder defined automatically. In order to add secondary view holders
     * override method.
     */
    override fun getItemViewType(position: Int): Int {
        return if (isData(position)) {
            DATA_VIEW_TYPE
        } else super.getItemViewType(position)
    }

    abstract fun isData(position: Int): Boolean

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        super.onBindViewHolder(holder, position)
        if (holder.itemViewType == DATA_VIEW_TYPE){
            bindData(holder, data!![position])
        }
    }

    abstract fun bindData(holder: VH, item: D)

    abstract class DataBaseViewHolder<in D>(itemView : View) : BaseViewHolder(itemView){

        override fun bind(position: Int) {
            throw IllegalStateException("For data view holder use bind(data : D)")
        }

        abstract fun bind(item : D)

    }

}