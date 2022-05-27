package com.sticky.app.sample.ui.adapter

import com.stickyheader.app.StickyAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import com.sticky.app.sample.ui.adapter.SectionAdapter.HeaderViewholder
import com.sticky.app.R
import com.sticky.app.sample.ui.adapter.SectionAdapter.ItemViewHolder
import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import com.sticky.app.sample.data.Section
import java.util.ArrayList

class SectionAdapter : StickyAdapter<ViewHolder?, ViewHolder?>() {
    @JvmField
    var items: List<Section> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == Section.HEADER || viewType == Section.CUSTOM_HEADER) {
            HeaderViewholder(inflater.inflate(R.layout.recycler_view_header_item, parent, false))
        } else ItemViewHolder(inflater.inflate(R.layout.recycler_view_item, parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val type = items[position].type()
        val section = items[position].sectionPosition()
        if (type == Section.HEADER) {
            (holder as HeaderViewholder).textView.text = "Section " + (position + 1)
        } else if (type == Section.ITEM) {
            (holder as ItemViewHolder).textView.text = "Hello " + (position + 1)
        } else {
            (holder as HeaderViewholder).textView.text = "Custom header"
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getHeaderPositionForItem(itemPosition: Int): Int {
        return items[itemPosition].sectionPosition()
    }

    @SuppressLint("SetTextI18n")
    override fun onBindHeaderViewHolder(holder: ViewHolder?, headerPosition: Int) {
        (holder as HeaderViewholder?)!!.textView.text = "Section " + (headerPosition + 1)
    }

    override fun onCreateHeaderViewHolder(parent: ViewGroup?): ViewHolder {
        return createViewHolder(parent!!, Section.HEADER)
    }

    class HeaderViewholder internal constructor(itemView: View) : ViewHolder(itemView) {
        var textView: TextView

        init {
            textView = itemView.findViewById(R.id.text_view)
        }
    }

    class ItemViewHolder internal constructor(itemView: View) : ViewHolder(itemView) {
        var textView: TextView

        init {
            textView = itemView.findViewById(R.id.text_view)
        }
    }
}