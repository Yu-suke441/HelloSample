package com.websarva.wings.android.hellosample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 表示ボタンであるButtonオブジェクトを取得
        val btClick = findViewById<Button>(R.id.btClick)
        // リスナクラスのインスタンスを生成。
        val listner = HelloListener()
        // 表示ボタンにリスナを設定。
        btClick.setOnClickListener(listner)

        //クリアボタンであるButtonオブジェクトを取得
        val btClear = findViewById<Button>(R.id.btClear)
        btClear.setOnClickListener(listner)
    }
    // ボタンをクリックした時のリスナクラス
    private inner class HelloListener: View.OnClickListener {
        override fun onClick(view: View) {
            // 名前入力欄であるEditTextオブジェクトを取得。
            val input = findViewById<EditText>(R.id.etName)
            // メッセージを表示するTextViewオブジェクトを取得。
            val output = findViewById<TextView>(R.id.tvOutput)

            // idのR値に応じて処理を分岐。
            when(view.id) {
                // 表示ボタンんが押された場合。
                R.id.btClick -> {
                    // 入力された名前文字列を取得。
                    val inputStr = input.toString()
                    // メッセージを表示。
                    output.text = inputStr + "さん、こんにちは！"
                }
                // クリアボタンが押された場合。
                R.id.btClear -> {
                    // 名前入力欄をから文字に設定。
                    input.setText("")
                    // メッセージ表示欄を空文字に設定。
                    output.text = ""
                }
            }
        }
    }
}