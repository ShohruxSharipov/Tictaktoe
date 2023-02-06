package uz.itschool.tictaktoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

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
    lateinit var playag: ImageButton
    lateinit var winner:CardView
    lateinit var Winner:TextView
    lateinit var playerfcount:TextView
    lateinit var playerscount:TextView
    lateinit var playerf:TextView
    lateinit var players:TextView
    var namex:String? = "Player X"
    var nameo:String? = "Player O"

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
        winner = findViewById<CardView>(R.id.winercard)
        Winner = findViewById(R.id.winner)
        playerfcount = findViewById(R.id.playerfcount)
        playerscount = findViewById(R.id.playerscount)
        playerf = findViewById(R.id.playerf)
        players = findViewById(R.id.players)
        namex = intent.getStringExtra("NAME_X")
        nameo = intent.getStringExtra("NAME_O")
        if (nameo!!.isEmpty()){
            nameo = "Player O"
        }
        if (namex!!.isEmpty()){
            namex = "Player X"
        }

        playerf.text = namex
        players.text = nameo
        playerturn.text = namex
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
            val anim = AnimationUtils.loadAnimation(this,R.anim.animatoinback)
            winner.startAnimation(anim)
            winner.visibility = View.INVISIBLE
            playerturn.text = namex
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
                val anim = AnimationUtils.loadAnimation(this,R.anim.animation)
                a.startAnimation(anim)
                check = false
                playerturn.text = nameo
                matrix[row][col] = 1
                game(col, row, 1)


            } else {
                a.setBackgroundResource(R.drawable.img_1)
                val anim = AnimationUtils.loadAnimation(this,R.anim.animation)
                a.startAnimation(anim)
                check = true
                playerturn.text = namex
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
    var firstpl = 0
    var secondpl = 0
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
            Winner.text = namex
            firstpl++
            playerfcount.text = firstpl.toString()
        }
        else if (a==3){Winner.text = "Draw"}
        else {
            Winner.text = nameo
            secondpl++
            playerscount.text = secondpl.toString()
        }
        check = true
        winner.visibility = View.VISIBLE
        val anim = AnimationUtils.loadAnimation(this,R.anim.animation)
        winner.startAnimation(anim)
    }
}