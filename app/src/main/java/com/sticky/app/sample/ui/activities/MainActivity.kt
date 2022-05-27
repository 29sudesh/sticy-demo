package com.sticky.app.sample.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sticky.app.R
import com.sticky.app.sample.data.Section
import com.sticky.app.sample.model.SectionItem
import com.sticky.app.sample.ui.adapter.SectionAdapter
import com.sticky.app.sample.ui.adapter.SectionHeader
import com.stickyheader.app.StickyHeaderItemDecorator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val dividerDecorator = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerDecorator)
        val adapter = SectionAdapter()
        recyclerView.adapter = adapter
        val decorator = StickyHeaderItemDecorator(adapter)
        decorator.attachToRecyclerView(recyclerView)
        adapter.items = object : ArrayList<Section>() {
            init {
                var section = 0
                for (i in 0..57) {
                    if (i < 12) {
                        if (i % 4 == 0) {
                            section = i
                            add(SectionHeader(section))
                        } else {
                            add(SectionItem(section))
                        }
                    } else {
                        if (i % 8 == 0) {
                            section = i
                            add(SectionHeader(section))
                        } else {
                            add(SectionItem(section))
                        }
                    }
                }
            }
        }
        adapter.notifyDataSetChanged()
    }
}