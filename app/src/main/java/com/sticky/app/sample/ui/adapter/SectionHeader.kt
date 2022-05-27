package com.sticky.app.sample.ui.adapter

import com.sticky.app.sample.data.Section

class SectionHeader(private val section: Int) : Section {
    override fun type(): Int {
        return Section.HEADER
    }

    override fun sectionPosition(): Int {
        return section
    }
}