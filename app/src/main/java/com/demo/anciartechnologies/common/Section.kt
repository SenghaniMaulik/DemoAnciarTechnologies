package com.demo.anciartechnologies.common

interface Section {
    fun type(): Int
    fun sectionPosition(): Int
    companion object {
        const val HEADER = 0
        const val SINGLE_ITEM = 1
        const val DOUBLE_ITEM = 2
    }
}