package com.honwon.pricecomparision

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.selector
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import java.net.URLEncoder
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    lateinit var mAdView : AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)




        background.setOnClickListener{
            hideKeyboard()
        }



        compareBtn.setOnClickListener {
            if (martPrice==null && onlinePrice ==null){
                toast("금액을 입력해주세요")
            } else{
            startActivity<ResultActivity>(
                "mart" to martPrice.text.toString().toIntOrNull(),
                "online" to onlinePrice.text.toString().toIntOrNull(),
                "post" to postSend.text.toString().toIntOrNull()
            )

            }
        }



        searchBtn.setOnClickListener {

            hideKeyboard()

            val cities = listOf("다나와", "에누리","네이버 쇼핑","쿠팡")
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
                    }
                    3-> if(product == ""){
                        toast("제품명이 입력되지 않았습니다")}
                    else{browse("https://m.coupang.com/nm/search?q=${product}")
                    }
                }}


        }

    }

    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }}

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))}

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)}

    override fun onRestart() {
        loadData()
        super.onRestart()
    }

    override fun onStop() {
        val a = martPrice.text.toString().toIntOrNull()?:0
        val b = onlinePrice.text.toString().toIntOrNull()?:0
        val c = postSend.text.toString().toIntOrNull()?:0
        saveData(a,b,c)

        super.onStop()
    }



    open fun saveData(A: Int ,B:Int,C:Int) {
        val pref = this.getPreferences(0)
        val editor = pref.edit()
        editor.putInt("_ONE",A)
        editor.putInt("_TWO",B)
        editor.putInt("_THREE",C)

        editor.apply()
    }

    open fun loadData() {
        val pref = this.getPreferences(0)
        var a = pref.getInt("_ONE",0)
        var b = pref.getInt("_TWO",0)
        var c = pref.getInt("_THREE",0)


        if (a != 0) {
            martPrice.setText(a.toString())
        }
        if (b != 0) {
            onlinePrice.setText(b.toString())
        }
        if (c != 0) {
            postSend.setText(c.toString())
        }

    }

}