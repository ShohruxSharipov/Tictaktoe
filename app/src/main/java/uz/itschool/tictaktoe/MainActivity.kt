package uz.itschool.tictaktoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity(),OnClickListener {
    lateinit var playerturn : TextView
    lateinit var first: ImageView
    lateinit var second: ImageView
    lateinit var third: ImageView
    lateinit var fourth: ImageView
    lateinit var fifs: ImageView
    lateinit var sixs: ImageView
    lateinit var seventh: ImageView
    lateinit var eighth: ImageView
    lateinit var nineth: ImageView
     var check: Boolean = true
    var matrix = Array(7){IntArray(7){-1} }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        first = findViewById<ImageView>(R.id.qator1_joy1)
        second = findViewById<ImageView>(R.id.qator1_joy2)
        third = findViewById<ImageView>(R.id.qator1_joy3)
        fourth = findViewById<ImageView>(R.id.qator2_joy1)
        fifs = findViewById<ImageView>(R.id.qator2_joy2)
        sixs = findViewById<ImageView>(R.id.qator2_joy3)
        seventh = findViewById<ImageView>(R.id.qator3_joy1)
        eighth = findViewById<ImageView>(R.id.qator3_joy2)
        nineth = findViewById<ImageView>(R.id.qator3_joy3)
        playerturn = findViewById<TextView>(R.id.textView)

        first.setOnClickListener(this)
        second.setOnClickListener(this)
        third.setOnClickListener(this)
        fourth.setOnClickListener(this)
        fifs.setOnClickListener(this)
        sixs.setOnClickListener(this)
        seventh.setOnClickListener(this)
        eighth.setOnClickListener(this)
        nineth.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        var a = findViewById<ImageView>(view!!.id)

        if (check){
            a.setBackgroundResource(R.drawable.img_2)
            check=false
            playerturn.text = "Player 0"
        }else {a.setBackgroundResource(R.drawable.img_1)
            check=true
            playerturn.text = "Player X"}
    }

//    fun game(){
//
//    }
}