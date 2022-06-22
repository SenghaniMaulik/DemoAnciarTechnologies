package com.demo.anciartechnologies.model

import com.demo.anciartechnologies.common.Section

class DoubleImageModel(
    private val section: Int,
     val img1: String,
     val img2: String
) : Section {
    override fun type(): Int {
        return Section.DOUBLE_ITEM
    }

    override fun sectionPosition(): Int {
        return section
    }
}