package com.honwon.pricecomparision

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.w3c.dom.Text

class ListAdapter (val context: Context, val UserList: ArrayList<Data>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        // 리스트 소스가 되는 XML 등록

        val view: View = LayoutInflater.from(context).inflate(R.layout.standard, null)

        //리스트 소스의 각 개별 아이템 ID 등록

        val Count = view.findViewById<TextView>(R.id.count)
        val Mart = view.findViewById<TextView>(R.id.martP)
        val Online = view.findViewById<TextView>(R.id.onlineP)
        val subPrice = view.findViewById<TextView>(R.id.subP)
        val percent  = view.findViewById<TextView>(R.id.returnR)

        val user = UserList[position]

        //등록
        Count.text = user.number
        Mart.text = user.mart
        Online.text = user.online
        subPrice.text = user.diff
        percent.text = user.percent

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