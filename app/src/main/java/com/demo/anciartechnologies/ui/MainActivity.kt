package com.demo.anciartechnologies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.anciartechnologies.adapter.SectionAdapter
import com.demo.anciartechnologies.common.Section
import com.demo.anciartechnologies.databinding.ActivityMainBinding
import com.demo.anciartechnologies.model.DoubleImageModel
import com.demo.anciartechnologies.model.HeaderModel
import com.demo.anciartechnologies.model.SingleImageModel
import com.shuhart.stickyheader.StickyHeaderItemDecorator

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setView()
    }

    private fun setView() {


        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = SectionAdapter()
        binding.recyclerView.adapter = adapter

        val decorator = StickyHeaderItemDecorator(adapter)
        decorator.attachToRecyclerView(binding.recyclerView)
        adapter.items = object : ArrayList<Section>() {
            init {
                var section = 0
                var sectionCount = 1
                for (i in 0..101) {
                    if (i % 9 == 0) { // condition to add header
                        section = i
                        add(HeaderModel(sectionCount))
                        sectionCount++
                    } else {
                        if (i % 2 == 0) { // condition to add SINGLE and DOUBLE item to recyclerview
                            add(
                                SingleImageModel(
                                    section,
                                    "https://images.unsplash.com/photo-1579353977828-2a4eab540b9a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8c2FtcGxlfGVufDB8fDB8fA%3D%3D&w=1000&q=80"
                                )
                            )
                        } else {
                            add(
                                DoubleImageModel(
                                    section,
                                    "https://www.sample-videos.com/img/Sample-jpg-image-50kb.jpg",
                                    "https://nikonrumors.com/wp-content/uploads/2014/03/Nikon-1-V3-sample-photo.jpg"
                                )
                            )
                        }
                    }
                }
            }
        }
        adapter.notifyDataSetChanged()
    }
}