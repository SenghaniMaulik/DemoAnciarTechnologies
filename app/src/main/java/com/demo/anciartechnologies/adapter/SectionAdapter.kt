package com.demo.anciartechnologies.adapter

import com.shuhart.stickyheader.StickyAdapter
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.demo.anciartechnologies.R
import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.demo.anciartechnologies.common.Section
import com.demo.anciartechnologies.model.DoubleImageModel
import com.demo.anciartechnologies.model.SingleImageModel
import com.demo.anciartechnologies.utils.loadImageFromUrl
import java.util.ArrayList

class SectionAdapter : StickyAdapter<RecyclerView.ViewHolder, RecyclerView.ViewHolder>() {
    var items: List<Section> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == Section.HEADER) {
            HeaderViewHolder(inflater.inflate(R.layout.recycler_view_header_item, parent, false))
        } else if (viewType == Section.SINGLE_ITEM) {
            SingleItemViewHolder(
                inflater.inflate(
                    R.layout.recycler_view_item_with_images,
                    parent,
                    false
                )
            )
        } else if (viewType == Section.DOUBLE_ITEM) {
            DoubleItemViewHolder(
                inflater.inflate(
                    R.layout.recyclerview_item_with_two_images,
                    parent,
                    false
                )
            )
        } else {
            HeaderViewHolder(inflater.inflate(R.layout.recycler_view_header_item, parent, false))
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val type = items[position].type()
        val section = items[position].sectionPosition()
        if (type == Section.HEADER) {
            (holder as HeaderViewHolder).textView.text = "Section $section"
        } else if (type == Section.SINGLE_ITEM) {
            val single = items[position] as SingleImageModel
            (holder as SingleItemViewHolder).apply {
                imgFull.loadImageFromUrl(single.img1)
            }
        } else {
            val double = items[position] as DoubleImageModel
            (holder as DoubleItemViewHolder).apply {
                imgOne.loadImageFromUrl(double.img1)
                imgTwo.loadImageFromUrl(double.img2)
            }
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
    override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder, headerPosition: Int) {
        val section = items[headerPosition].sectionPosition()
        (holder as HeaderViewHolder).textView.text = "Section  $section"
    }

    override fun onCreateHeaderViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return createViewHolder(parent, Section.HEADER)
    }
    class HeaderViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var textView: TextView

        init {
            textView = itemView.findViewById(R.id.text_view)
        }
    }
    class SingleItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgFull: ImageView

        init {
            imgFull = itemView.findViewById(R.id.imgFull)
        }
    }
    class DoubleItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgOne: ImageView
        var imgTwo: ImageView
        init {
            imgOne = itemView.findViewById(R.id.imgOne)
            imgTwo = itemView.findViewById(R.id.imgTwo)
        }
    }


}