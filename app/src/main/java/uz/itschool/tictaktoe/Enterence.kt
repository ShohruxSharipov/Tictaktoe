package uz.itschool.tictaktoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class Enterence : AppCompatActivity() {
    lateinit var nameX: EditText
    lateinit var nameO: EditText

    lateinit var namex: String
    lateinit var nameo: String

    lateinit var start: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enterence)
        start = findViewById(R.id.Start)
        nameX = findViewById(R.id.playerx)
        nameO = findViewById(R.id.playero)
        start.setOnClickListener {
            Log.d("log", "jk")
            var intent = Intent(this, MainActivity::class.java)

            startActivity(intent)

//    fun sendData(){
//        nameo = nameO.text.toString()
//        namex = nameX.text.toString()
//
//
//
//        Log.d("tag",namex+ "    $nameo")
//
//
//    }
        }
    }
}
