package com.example.recyclerviewradiobuttonkotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewradiobuttonkotlin.recyclerview.ItemClickListener
import com.example.recyclerviewradiobuttonkotlin.recyclerview.itemAdapter


class MainActivity : AppCompatActivity() {
    //선언
    private var recyclerView: RecyclerView? = null
    private var itemClickListener: ItemClickListener? = null
    private var adapter: itemAdapter? = null

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //변수에 담기
        recyclerView = findViewById(R.id.recyclerView)

        //리스트
        val arrayList: ArrayList<String> = ArrayList()

        //데이터 생성
        for (i in 0..999) {
            arrayList.add("RB $i")
        }
        itemClickListener =
            ItemClickListener { s ->
                recyclerView!!.post { adapter!!.notifyDataSetChanged() }
                Toast.makeText(
                    this@MainActivity, "selected: $s",
                    Toast.LENGTH_SHORT
                ).show()
            }
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        adapter = itemAdapter(arrayList, itemClickListener)
        recyclerView!!.adapter = adapter
    }
} //MainActivity
