package uz.itschool.tictaktoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    lateinit var playag: Button
     var check: Boolean = true
    var matrix = Array(3){IntArray(3){-1} }
    var col:Int = 2
    var row:Int = 2

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
        playag = findViewById(R.id.playagain)

        first.setOnClickListener(this)
        second.setOnClickListener(this)
        third.setOnClickListener(this)
        fourth.setOnClickListener(this)
        fifs.setOnClickListener(this)
        sixs.setOnClickListener(this)
        seventh.setOnClickListener(this)
        eighth.setOnClickListener(this)
        nineth.setOnClickListener(this)

        playag.setOnClickListener{
            matrix = Array(3) { IntArray(3) { -1 } }
            first.setBackgroundResource(0)
            second.setBackgroundResource(0)
            third.setBackgroundResource(0)
            fourth.setBackgroundResource(0)
            fifs.setBackgroundResource(0)
            sixs.setBackgroundResource(0)
            seventh.setBackgroundResource(0)
            eighth.setBackgroundResource(0)
            nineth.setBackgroundResource(0)
            first.isEnabled = true
            second.isEnabled = true
            third.isEnabled = true
            fourth.isEnabled = true
            fifs.isEnabled = true
            sixs.isEnabled = true
            seventh.isEnabled = true
            eighth.isEnabled = true
            nineth.isEnabled = true
            playag.visibility = View.INVISIBLE
            playerturn.text = "Player X"
            amount = 0
        }

    }
var amount = 0
    override fun onClick(view: View?) {
        var a = findViewById<ImageView>(view!!.id)
        row = (a.tag.toString().toInt() - 1) / 3
        col = (a.tag.toString().toInt() - 1) % 3
        if (matrix[row][col] == -1) {
            amount++
            if (check) {
                a.setBackgroundResource(R.drawable.img_2)
                check = false
                playerturn.text = "Player O"
                matrix[row][col] = 1
                game(col, row, 1)


            } else {
                a.setBackgroundResource(R.drawable.img_1)
                check = true
                playerturn.text = "Player X"
                matrix[row][col] = 0
                game(col, row, 0)
            }
        }
    }

    var count = 0
    fun game(col:Int,row:Int,a:Int) {
        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[i][j] == a) {
                    count++
                }
            }
            if (count == 3) {
                iswinner(a)
                return
            }
            count=0

        }

        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[j][i] == a) {
                    count++
                }
            }
            if (count == 3) {
                iswinner(a)
                return
            }
            count=0

        }
        for (i in 0..2) {
            for (j in 0..2) {
                if (i == j) {
                    if (matrix[j][i] == a) {
                        count++
                    }
                }
            }
        }
        if (count == 3) {
            iswinner(a)
            return
        }
        count=0
        for (i in 0..2) {
            for (j in 0..2) {
                if (i+j == 2) {
                    if (matrix[i][j] == a) {
                        count++
                    }
                }
            }
        }
        if (count == 3) {
            iswinner(a)
            return
        }
        count=0

        if (amount == 9){
            iswinner(3)
        }
    }

    fun iswinner(a:Int){
        first.isEnabled = false
        second.isEnabled = false
        third.isEnabled = false
        fourth.isEnabled = false
        fifs.isEnabled = false
        sixs.isEnabled = false
        seventh.isEnabled = false
        eighth.isEnabled = false
        nineth.isEnabled = false
        count = 0
        if (a == 1){
        playerturn.text = "Player X won"}
        else if (a==3){playerturn.text = "Draw"}
        else {playerturn.text = "Player O won"}

        playag.visibility = View.VISIBLE
    }
}