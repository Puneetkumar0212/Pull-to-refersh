package com.example.refreshlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var k:Int =14
        val recyclerView: RecyclerView = findViewById(R.id.recylerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val items = fetchData()
        val adaptor = RecyclerAdaptor(items)
        recylerview.adapter = adaptor
        val swipe: SwipeRefreshLayout = findViewById(R.id.swipe)
        swipe.setOnRefreshListener {
            Toast.makeText(this, " Page Refreshing!", Toast.LENGTH_LONG).show()
            items.addAll(updatedData())
            adaptor.notifyDataSetChanged()
            swipe.isRefreshing = false

        }
    }
    var k = 14


    fun updatedData(): ArrayList<String> {

        k= k +1
        val item = ArrayList<String>()



       for (i in k..k) {


        item.add("Items $i")
      }

      return item
    }


    fun fetchData(): ArrayList<String> {
        val list = ArrayList<String>()
        for (i in 1 until 15) {
            list.add("Items $i")
        }
        return list
    }


}
//    private fun refreshapp() {
//        swipe.setOnRefreshListener {
//            Toast.makeText(this, " Page Refreshing!", Toast.LENGTH_LONG).show()
//            swipe.isRefreshing = false
//            recylerview.setLayoutManager( new LayoutManager)
//
//
//        }
//    }
//  }

