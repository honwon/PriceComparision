package com.honwon.pricecomparision

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        var UserList = arrayListOf<User>(
            User("심효근","shimhg02@naver.com","아령하세요잇!"),
            User("박채연","asdf@naver.com","할말이 없다"),
            User("박서연","qwerqr2@naver.com","ㄷ"),
            User("박태욱","ㅁㄴㅇㄹㅁㄴㅇㄹㅁㄴㅇㄹ@naver.com","ㅁㄴㅇㄹ"),
            User("김민식","qwer2@naver.com","ㅇㅁㄴㄹ!"),
            User("이소명","shㅇㄹ@naver.com","아령dsafsdf!"),
            User("한규언","shiㅁㄴㅇㄹ@naver.com","afsdf!"),
            User("정빈","shi@naver.com","ㅁㄴㅇㄹ"),
            User("김태양","sㅁㄴㅇㄹㅁㅇㄴㄹaver.com","아ㅇ잇!")
        )

        val Adapter = ListAdapter(this, UserList)
        list_view.adapter = Adapter

    }
}