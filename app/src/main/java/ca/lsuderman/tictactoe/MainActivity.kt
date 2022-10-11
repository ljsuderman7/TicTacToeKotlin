package ca.lsuderman.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView


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
    lateinit var txtWinner: TextView
    lateinit var swFirstTurn: Switch
    var xTurn = true
    var gameOver = true
    var numberOfTurns = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        txtWinner = findViewById<TextView>(R.id.txtWinner)
        swFirstTurn = findViewById<Switch>(R.id.swFirstTurn)

        // starts a new game, turns all the spaces blank, sets gameOver to false and sets number of turns to 0
        btnStartGame.setOnClickListener(View.OnClickListener {
            //region ImageView Game Setup
            iv1.setImageDrawable(getDrawable(R.drawable.blank_background))
            iv1.isClickable = true
            iv1.tag = "blank"

            iv2.setImageDrawable(getDrawable(R.drawable.blank_background))
            iv2.isClickable = true
            iv2.tag = "blank"

            iv3.setImageDrawable(getDrawable(R.drawable.blank_background))
            iv3.isClickable = true
            iv3.tag = "blank"

            iv4.setImageDrawable(getDrawable(R.drawable.blank_background))
            iv4.isClickable = true
            iv4.tag = "blank"

            iv5.setImageDrawable(getDrawable(R.drawable.blank_background))
            iv5.isClickable = true
            iv5.tag = "blank"

            iv6.setImageDrawable(getDrawable(R.drawable.blank_background))
            iv6.isClickable = true
            iv6.tag = "blank"

            iv7.setImageDrawable(getDrawable(R.drawable.blank_background))
            iv7.isClickable = true
            iv7.tag = "blank"

            iv8.setImageDrawable(getDrawable(R.drawable.blank_background))
            iv8.isClickable = true
            iv8.tag = "blank"

            iv9.setImageDrawable(getDrawable(R.drawable.blank_background))
            iv9.isClickable = true
            iv9.tag = "blank"
            //endregion

            gameOver = false
            // sets the first turn to X if the switch is not selected
            if (!swFirstTurn.isChecked) {
                xTurn = true
            }
            txtWinner.text = ""
            numberOfTurns = 0
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
        // increases the turn counter by 1
        numberOfTurns++

            // if it X's turn to go, display an X, and save it as such
            if (xTurn) {
                iv.setImageDrawable(getDrawable(R.drawable.x))
                iv.isClickable = false
                iv.tag = "X"
            }
            // or O
            else {
                iv.setImageDrawable(getDrawable(R.drawable.o))
                iv.isClickable = false
                iv.tag = "O"
            }

        // only checks for a winner once 5 turns have been taken (not possible to win before that)
        if (numberOfTurns >= 5) {
            checkForWinner()

            if (gameOver) {
                var winner = if (xTurn) "X" else "O"

                txtWinner.text = "$winner wins!"
            }
        }

        // displays that it is a tie if the number of turns is 9 and nobody has won yet
        if (numberOfTurns == 9 && !gameOver){
            txtWinner.text = "It's a tie!"
        }

        // changes whose turn it is
        xTurn = !xTurn
    }


    private fun checkForWinner(){
        // checks horizontal
        if ((iv1.tag == "X" && iv2.tag == "X" && iv3.tag == "X") ||
            (iv4.tag == "X" && iv5.tag == "X" && iv6.tag == "X") ||
            (iv7.tag == "X" && iv8.tag == "X" && iv9.tag == "X") ||
            (iv1.tag == "O" && iv2.tag == "O" && iv3.tag == "O") ||
            (iv4.tag == "O" && iv5.tag == "O" && iv6.tag == "O") ||
            (iv7.tag == "O" && iv8.tag == "O" && iv9.tag == "O")) {
            gameOver = true
        }

        // checks vertical
        if ((iv1.tag == "X" && iv4.tag == "X" && iv7.tag == "X") ||
            (iv2.tag == "X" && iv5.tag == "X" && iv8.tag == "X") ||
            (iv3.tag == "X" && iv6.tag == "X" && iv9.tag == "X") ||
            (iv1.tag == "O" && iv4.tag == "O" && iv7.tag == "O") ||
            (iv2.tag == "O" && iv5.tag == "O" && iv8.tag == "O") ||
            (iv3.tag == "O" && iv6.tag == "O" && iv9.tag == "O")) {
            gameOver = true
        }

        // checks diagonal
        if ((iv1.tag == "X" && iv5.tag == "X" && iv9.tag == "X") ||
            (iv7.tag == "X" && iv5.tag == "X" && iv3.tag == "X") ||
            (iv1.tag == "O" && iv5.tag == "O" && iv9.tag == "O") ||
            (iv7.tag == "O" && iv5.tag == "O" && iv3.tag == "O")) {
            gameOver = true
        }
    }
}