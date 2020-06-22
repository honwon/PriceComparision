package com.honwon.pricecomparision

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*
import java.text.NumberFormat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var marttt = intent.getIntExtra("mart",0)
        var onlinee = intent.getIntExtra("online",0)
        var post = intent.getIntExtra("post",0)


        var DataList = arrayListOf<Data>()

        for (i in 1..30) {
            DataList.add(
                Data(
                    "${i}개",
                    "${NumberFormat.getIntegerInstance().format(marttt * i)}",
                    "${NumberFormat.getIntegerInstance().format(onlinee * i + post)}",
                    "${NumberFormat.getIntegerInstance().format(marttt * i - (onlinee * i + post))}",
                    "${((((marttt * i).toFloat() / (onlinee * i + post).toFloat()) - 1.0) * 100.0).toInt()}%"
                )
            )
        }


        val Adapter = ListAdapter(this, DataList)
        list_view.adapter = Adapter

    }
}