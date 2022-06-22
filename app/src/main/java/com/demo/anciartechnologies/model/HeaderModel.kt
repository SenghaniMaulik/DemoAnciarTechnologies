package com.demo.anciartechnologies.model

import com.demo.anciartechnologies.common.Section

class HeaderModel(private val section: Int) : Section {
    override fun type(): Int {
        return Section.HEADER
    }

    override fun sectionPosition(): Int {
        return section
    }
}