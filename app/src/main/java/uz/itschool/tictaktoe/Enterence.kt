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

    lateinit var start:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enterence)
        start = findViewById(R.id.Start)
        nameX = findViewById(R.id.playerx)
        nameO = findViewById(R.id.playero)

        start.setOnClickListener {

            namex = nameX.text.toString()
            nameo = nameO.text.toString()

            var intent = Intent(this,MainActivity::class.java).also {
                it.putExtra("NAME_X",namex)
                it.putExtra("NAME_O",nameo)
                startActivity(it)
            }
        }
    }


}