package boohaky.japan.haduken.imdead.widget.recycler

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseRecylcerAdapter<VH : BaseRecylcerAdapter.BaseViewHolder> : RecyclerView.Adapter<VH>() {

    var mAdapterItemClickListener: ((view: View, position: Int) -> Unit)? = null

    var mAdapterItemLongClickListener: ((view: View, position: Int) -> Unit)? = null

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            mAdapterItemClickListener?.invoke(it, position)
        }
        holder.itemView.setOnLongClickListener {
            mAdapterItemLongClickListener?.invoke(it, position).also {
                return@setOnLongClickListener true
            }
            false
        }
    }

    fun setOnItemClickListener(function: (view: View, position: Int) -> Unit){
        mAdapterItemClickListener = function
    }

    fun setOnItemLongClickListener(function: (view: View, position: Int) -> Unit){
        mAdapterItemLongClickListener = function
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        abstract fun bind(position: Int)

    }
}