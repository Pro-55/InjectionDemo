package com.example.injectiondemo

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import toothpick.Toothpick
import java.util.*
import javax.inject.Inject

class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var mContext: Context
    @Inject
    lateinit var dataList: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //Open desired scope
        val appScope = Toothpick.openScope(getString(R.string.string_app_scope_name))
        Toothpick.inject(this, appScope)

        val index = intent.getIntExtra("index", 0)

        when {
            index % 6 == 0 -> idCvSecondCard.setCardBackgroundColor(mContext.resources.getColor(dataList[0]))
            index % 5 == 0 -> idCvSecondCard.setCardBackgroundColor(mContext.resources.getColor(dataList[1]))
            index % 4 == 0 -> idCvSecondCard.setCardBackgroundColor(mContext.resources.getColor(dataList[2]))
            index % 3 == 0 -> idCvSecondCard.setCardBackgroundColor(mContext.resources.getColor(dataList[3]))
            index % 2 == 0 -> idCvSecondCard.setCardBackgroundColor(mContext.resources.getColor(dataList[4]))
            else -> idCvSecondCard.setCardBackgroundColor(mContext.resources.getColor(dataList[5]))
        }
        idTvSecondText.text = index.toString()
    }
}
