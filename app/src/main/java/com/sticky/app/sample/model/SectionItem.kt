package com.sticky.app.sample.model

import com.sticky.app.sample.data.Section

class SectionItem(private val section: Int) : Section {
    override fun type(): Int {
        return Section.ITEM
    }

    override fun sectionPosition(): Int {
        return section
    }
}