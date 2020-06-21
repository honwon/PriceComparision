package com.honwon.pricecomparision

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListAdapter (val context: Context, val UserList: ArrayList<User>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        // 리스트 소스가 되는 XML 등록

        val view: View = LayoutInflater.from(context).inflate(R.layout.standard, null)

        //리스트 소스의 각 개별 아이템 ID 등록

        val Name = view.findViewById<TextView>(R.id.name_tv)
        val Email = view.findViewById<TextView>(R.id.email_tv)
        val Content = view.findViewById<TextView>(R.id.content_tv)

        val user = UserList[position]

        //등록
        Name.text = user.name
        Email.text = user.email
        Content.text = user.content

        return view
    }


    override fun getItem(position: Int): Any {
        return UserList[position]
    }
    override fun getItemId(position: Int): Long {
        return 0
    }
    override fun getCount(): Int {
        return UserList.size
    }
}