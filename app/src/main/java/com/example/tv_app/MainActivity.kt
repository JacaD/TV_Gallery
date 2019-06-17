package com.example.tv_app

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tv_app.adapters.RecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.view.KeyEvent
import android.view.View


class MainActivity : Activity() {

    lateinit var adapter: RecyclerViewAdapter
    var listSize: Int = 0
    var currentPos: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageListId = ArrayList<Int>()
        val drawables = R.raw::class.java.fields
        for (f in drawables) {
            imageListId.add(resources.getIdentifier(f.name, "raw", packageName))
        }
        listSize = imageListId.size
        adapter = RecyclerViewAdapter(this, imageListId)
        galleryView.adapter = adapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        galleryView.layoutManager = layoutManager
        val helper = LinearSnapHelper()
        helper.attachToRecyclerView(galleryView)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        return when (keyCode) {
            KeyEvent.KEYCODE_DPAD_RIGHT-> {
                next(null)
                true
            }
            KeyEvent.KEYCODE_DPAD_LEFT-> {
                prev(null)
                true
            }
            else -> super.onKeyUp(keyCode, event)
        }
    }

    fun next(v: View?){
        if(currentPos + 1 > listSize - 1) currentPos = 0 else currentPos += 1
        galleryView.smoothScrollToPosition(currentPos)

    }

    fun prev(v: View?){
        if(currentPos - 1 < 0) currentPos = listSize - 1 else currentPos -= 1
        galleryView.smoothScrollToPosition(currentPos)
    }
}
