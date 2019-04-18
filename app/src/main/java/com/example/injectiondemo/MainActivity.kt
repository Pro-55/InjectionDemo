package com.example.injectiondemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView
import toothpick.Toothpick
import java.util.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), RecyclerAdapterInterface {

    @Inject
    lateinit var mContext: Context
    @Inject
    lateinit var dataList: ArrayList<Int>

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Open desired scope
        val appScope = Toothpick.openScope(getString(R.string.string_app_scope_name))
        Toothpick.inject(this, appScope)

        val idRvItemRecyclerView = findViewById<RecyclerView>(R.id.idRvItemRecyclerView)
        idRvItemRecyclerView.layoutManager = LinearLayoutManager(mContext)
        idRvItemRecyclerView.adapter = RecyclerAdapter(mContext, dataList, this)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(idRvItemRecyclerView)
    }

    override fun itemClickedAt(index: Int, targetView: CardView) {
        val activityTransitionBundle = ActivityOptionsCompat.makeSceneTransitionAnimation(this, targetView, targetView.transitionName).toBundle()
        val secondActivityIntent = Intent(this, SecondActivity::class.java)
        secondActivityIntent.putExtra("index", index)
        startActivity(secondActivityIntent, activityTransitionBundle)
    }
}
