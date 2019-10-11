package mx.edu.utng.appjuego


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val buttons = Array<Array<Button>>(3) { arrayOfNulls(3) }

    private var player1Turn = true

    private var roundCount: Int = 0

    private var player1Points: Int = 0
    private var player2Points: Int = 0

    private var textViewPlayer1: TextView? = null
    private var textViewPlayer2: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewPlayer1 = findViewById(R.id.text_view_p1)
        textViewPlayer2 = findViewById(R.id.text_view_p2)

        for (i in 0..2) {
            for (j in 0..2) {
                val buttonID = "button_$i$j"
                val resID = resources.getIdentifier(buttonID, "id", packageName)
                buttons[i][j] = findViewById(resID)
                buttons[i][j].setOnClickListener(this)
            }
        }

    }

    override fun onClick(v: View) {
        if ((v as Button).text.toString() != "") {
            return
        }

        if (player1Turn) {
            v.text = "X"
        } else {
            v.text = "O"
        }

        roundCount++

        if (checkForWin()) {
            if (player1Turn) {
                player1Wins()
            } else {
                player2Wins()
            }
        } else if (roundCount == 9) {
            draw()
        } else {
            player1Turn = !player1Turn
        }

    }

    private fun checkForWin(): Boolean {
        val field = Array<Array<String>>(3) { arrayOfNulls(3) }

        for (i in 0..2) {
            for (j in 0..2) {
                field[i][j] = buttons[i][j].text.toString()
            }
        }

        for (i in 0..2) {
            if (field[i][0] == field[i][1]
                && field[i][0] == field[i][2]
                && field[i][0] != ""
            ) {
                return true
            }
        }

        for (i in 0..2) {
            if (field[0][i] == field[1][i]
                && field[0][i] == field[2][i]
                && field[0][i] != ""
            ) {
                return true
            }
        }

        if (field[0][0] == field[1][1]
            && field[0][0] == field[2][2]
            && field[0][0] != ""
        ) {
            return true
        }

        return if (field[0][2] == field[1][1]
            && field[0][2] == field[2][0]
            && field[0][2] != ""
        ) {
            true
        } else false

    }

    private fun player1Wins() {
        player1Points++
        Toast.makeText(this, "Jugador 1 es el ganador", Toast.LENGTH_SHORT).show()
        updatePointsText()
        resetBoard()
    }

    private fun player2Wins() {
        player2Points++
        Toast.makeText(this, "Jugador 2 es el ganador", Toast.LENGTH_SHORT).show()
        updatePointsText()
        resetBoard()
    }

    private fun draw() {
        Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show()
        resetBoard()
    }

    private fun updatePointsText() {
        textViewPlayer1!!.text = "Jugador 1: $player1Points"
        textViewPlayer2!!.text = "Jugador 2: $player2Points"
    }

    private fun resetBoard() {
        for (i in 0..2) {
            for (j in 0..2) {
                buttons[i][j].text = ""
            }
        }

        roundCount = 0
        player1Turn = true
    }
}
