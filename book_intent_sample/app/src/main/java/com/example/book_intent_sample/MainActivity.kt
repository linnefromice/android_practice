package com.example.book_intent_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 画面部品ListViewの表示
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        // SimpleAdapterで使用するMutableListオブジェクトを用意
        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()
        // データを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menuList.add(mutableMapOf("name" to "から揚げ定食", "price" to "800円"))
        menuList.add(mutableMapOf("name" to "ハンバーグ定食", "price" to "850円"))
        menuList.add(mutableMapOf("name" to "生姜焼き定食", "price" to "850円"))
        menuList.add(mutableMapOf("name" to "ステーキ定食", "price" to "1000円"))
        menuList.add(mutableMapOf("name" to "野菜炒め定食", "price" to "750円"))
        menuList.add(mutableMapOf("name" to "とんかつ定食", "price" to "900円"))
        menuList.add(mutableMapOf("name" to "メンチかつ定食", "price" to "850円"))
        menuList.add(mutableMapOf("name" to "チキンカツ定食", "price" to "900円"))

        val from = arrayOf("name", "price")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        val adapter = SimpleAdapter(applicationContext, menuList, android.R.layout.simple_expandable_list_item_2, from, to)
        lvMenu.adapter = adapter
    }
}