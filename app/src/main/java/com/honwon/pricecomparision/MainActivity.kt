package com.honwon.pricecomparision

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.selector
import org.jetbrains.anko.toast
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)











        searchBtn.setOnClickListener {
            val cities = listOf("다나와", "에누리","네이버 쇼핑")
            val product = URLEncoder.encode(productName.text.toString(),"utf-8")

            selector(title = "온라인 쇼핑몰",items = cities){

                    dialogInterface, i ->
                when(i) {
                    0 -> if(product == ""){
                        toast("제품명이 입력되지 않았습니다")
                    } else { browse("http://search.danawa.com/mobile/dsearch.php?keyword=${product}")   }

                    1 -> if(product == ""){
                    toast("제품명이 입력되지 않았습니다")
                    } else{browse("http://m.enuri.com/m/search.jsp?keyword=${product}")}

                    2 -> if(product == ""){
                    toast("제품명이 입력되지 않았습니다")
                } else{browse("https://msearch.shopping.naver.com/search/all?query=${product}&frm=NVSHSRC&cat_id=&pb=true&mall=")
                }}}


        }

    }
}