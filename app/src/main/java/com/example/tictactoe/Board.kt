package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Board : AppCompatActivity(), View.OnClickListener {
    lateinit var btn00: Button
    lateinit var btn01: Button
    lateinit var btn02: Button
    lateinit var btn10: Button
    lateinit var btn11: Button
    lateinit var btn12: Button
    lateinit var btn20: Button
    lateinit var btn21: Button
    lateinit var btn22: Button
    lateinit var btnReset: Button
    lateinit var btnMenu: Button
    lateinit var txtXPoints: TextView
    lateinit var txtOPoints: TextView
    lateinit var txtTurn: TextView
    var gameValues = arrayOf("", "", "", "", "", "", "", "", "")
    private var turn = "X"
    var xPoints: Int = 0
    var oPoints: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        txtTurn = findViewById(R.id.txTurn)
        txtOPoints = findViewById(R.id.txPo)
        txtXPoints = findViewById(R.id.txPx)
        btn00 = findViewById(R.id.button00)
        btn01 = findViewById(R.id.button01)
        btn02 = findViewById(R.id.button02)
        btn10 = findViewById(R.id.button10)
        btn11 = findViewById(R.id.button11)
        btn12 = findViewById(R.id.button12)
        btn20 = findViewById(R.id.button20)
        btn21 = findViewById(R.id.button21)
        btn22 = findViewById(R.id.button22)
        btnReset = findViewById(R.id.buttonReset)
        btnMenu = findViewById(R.id.buttonMenu)

        btn00.setOnClickListener(this)
        btn01.setOnClickListener(this)
        btn02.setOnClickListener(this)
        btn10.setOnClickListener(this)
        btn11.setOnClickListener(this)
        btn12.setOnClickListener(this)
        btn20.setOnClickListener(this)
        btn21.setOnClickListener(this)
        btn22.setOnClickListener(this)
        btnReset.setOnClickListener(this)
        btnMenu.setOnClickListener(this)

        txtTurn.text = "$turn turn"

    }

    fun switchTurns(turn: String): String {
        if (turn == "X")
            return "O"
        else
            return "X"
    }

    fun checkWin(turn : String): Boolean {
        for (i in 0..2) {
            if (gameValues[3* i] == turn && gameValues[3 * i] == gameValues[3 * i + 1] && gameValues[3 * i + 1] == gameValues[3 * i + 2])
                return true;
            else if (gameValues[i + 3] == turn && gameValues[i] == gameValues[i + 3] && gameValues[i + 3] == gameValues[i + 6])
                return true;
        }
        if (gameValues[0] == turn && gameValues[0] == gameValues[4] && gameValues[4] == gameValues[8])
            return true;
        else if (gameValues[2] == turn && gameValues[2] == gameValues[4] && gameValues[4] == gameValues[6])
            return true;

        return false;
    }


    override fun onClick(p0: View?) {
        var btnClicked = findViewById<Button>(p0!!.id)
        if (!checkWin(turn)) {
            if (btnClicked.text == "") {
                btnClicked.setText(turn)
                val tag: String = btnClicked.tag.toString()
                gameValues[tag.toInt()] = turn
                if(!checkWin(turn)){
                    turn = switchTurns(turn)
                    txtTurn.text = "$turn's turn"
                }
            } else if(btnClicked.text == "O" || btnClicked.text == "X")
                Toast.makeText(this, "select a different square", Toast.LENGTH_SHORT).show()
        }
        if(checkWin(turn)){
            txtTurn.text = "$turn Wins!"
            if(turn == "X") {
                ++xPoints;
                txtXPoints.text == "Player X: $xPoints"
            }
            else {
                ++oPoints;
                txtOPoints.text == "Player O: $oPoints"
            }
        }

        if (btnClicked.text == "Reset") {
            gameValues = arrayOf("", "", "", "", "", "", "", "", "")
            btn00.text = "";
            btn01.text = "";
            btn02.text = "";
            btn10.text = "";
            btn11.text = "";
            btn12.text = "";
            btn20.text = "";
            btn21.text = "";
            btn22.text = "";
            turn = switchTurns(turn)
            txtTurn.text = "$turn's turn"
        }
        if (btnClicked.text == "Back to main menu") {
            gameValues = arrayOf("", "", "", "", "", "", "", "", "")
            btn00.text = "";
            btn01.text = "";
            btn02.text = "";
            btn10.text = "";
            btn11.text = "";
            btn12.text = "";
            btn20.text = "";
            btn21.text = "";
            btn22.text = "";
            turn = switchTurns(turn)
            txtTurn.text = "$turn's turn"
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}