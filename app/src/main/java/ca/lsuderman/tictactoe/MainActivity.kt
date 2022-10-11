package ca.lsuderman.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    lateinit var iv1: ImageView
    lateinit var iv2: ImageView
    lateinit var iv3: ImageView
    lateinit var iv4: ImageView
    lateinit var iv5: ImageView
    lateinit var iv6: ImageView
    lateinit var iv7: ImageView
    lateinit var iv8: ImageView
    lateinit var iv9: ImageView
    var xTurn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var gameOver = true

        val btnStartGame = findViewById<Button>(R.id.btnStartGame)
        iv1 = findViewById<ImageView>(R.id.iv1)
        iv2 = findViewById<ImageView>(R.id.iv2)
        iv3 = findViewById<ImageView>(R.id.iv3)
        iv4 = findViewById<ImageView>(R.id.iv4)
        iv5 = findViewById<ImageView>(R.id.iv5)
        iv6 = findViewById<ImageView>(R.id.iv6)
        iv7 = findViewById<ImageView>(R.id.iv7)
        iv8 = findViewById<ImageView>(R.id.iv8)
        iv9 = findViewById<ImageView>(R.id.iv9)

        // starts a new game, turns all the spaces blank
        btnStartGame.setOnClickListener(View.OnClickListener {
            iv1.setImageDrawable(getDrawable(R.drawable.blank_background))
            iv2.setImageDrawable(getDrawable(R.drawable.blank_background))
            iv3.setImageDrawable(getDrawable(R.drawable.blank_background))
            iv4.setImageDrawable(getDrawable(R.drawable.blank_background))
            iv5.setImageDrawable(getDrawable(R.drawable.blank_background))
            iv6.setImageDrawable(getDrawable(R.drawable.blank_background))
            iv7.setImageDrawable(getDrawable(R.drawable.blank_background))
            iv8.setImageDrawable(getDrawable(R.drawable.blank_background))
            iv9.setImageDrawable(getDrawable(R.drawable.blank_background))

            gameOver = false
        })

        //region Click Listeners
        iv1?.setOnClickListener(View.OnClickListener {
            if (!gameOver) takeTurn(iv1)
        })

        iv2?.setOnClickListener(View.OnClickListener {
            if (!gameOver) takeTurn(iv2)
        })

        iv3?.setOnClickListener(View.OnClickListener {
            if (!gameOver) takeTurn(iv3)
        })

        iv4?.setOnClickListener(View.OnClickListener {
            if (!gameOver) takeTurn(iv4)
        })

        iv5?.setOnClickListener(View.OnClickListener {
            if (!gameOver) takeTurn(iv5)
        })

        iv6?.setOnClickListener(View.OnClickListener {
            if (!gameOver) takeTurn(iv6)
        })

        iv7?.setOnClickListener(View.OnClickListener {
            if (!gameOver) takeTurn(iv7)
        })

        iv8?.setOnClickListener(View.OnClickListener {
            if (!gameOver) takeTurn(iv8)
        })

        iv9?.setOnClickListener(View.OnClickListener {
            if (!gameOver) takeTurn(iv9)
        })
        //endregion
    }

    // sets the section that was clicked to the correct image
    private fun takeTurn(iv: ImageView) {
        if (xTurn) {
            iv.setImageDrawable(getDrawable(R.drawable.x))
        }
        else {
            iv.setImageDrawable(getDrawable(R.drawable.o))
        }
        xTurn = !xTurn
    }
}