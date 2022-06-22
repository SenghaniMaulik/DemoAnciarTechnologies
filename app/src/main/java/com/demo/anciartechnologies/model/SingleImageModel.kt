package com.demo.anciartechnologies.model

import com.demo.anciartechnologies.common.Section

class SingleImageModel(
    private val section: Int,
    val img1: String
) : Section {
    override fun type(): Int {
        return Section.SINGLE_ITEM
    }

    override fun sectionPosition(): Int {
        return section
    }
}