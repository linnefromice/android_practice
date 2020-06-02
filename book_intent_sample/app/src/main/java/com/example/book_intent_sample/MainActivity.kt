package com.example.book_intent_sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

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

        // リストタップのListenerクラス登録
        lvMenu.onItemClickListener = ListItemClickListener()
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            // タップされた行のデータを取得 / SimpleAdapterでは一行分のデータはMutableMap型
            val item = parent.getItemAtPosition(position) as MutableMap<String, String>
            // インテントオブジェクトを生成
            val intent = Intent(applicationContext, MenuThanksActivity::class.java)
            // 第2画面に送るデータを格納 / 定食名と金額を取得
            intent.putExtra("menuName", item["name"])
            intent.putExtra("menuPrice", item["price"])
            startActivity(intent)
        }
    }
}