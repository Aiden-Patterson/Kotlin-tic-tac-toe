package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var playerTwo : Boolean;
        val singlePlay = findViewById<Button>(R.id.btnSingle);
        val doublePlay = findViewById<Button>(R.id.btnDouble)
        singlePlay.setOnClickListener{
            Toast.makeText(this, "Single player mode", Toast.LENGTH_SHORT).show();
            playerTwo = false;
            val intent = Intent(this, Board::class.java)
            startActivity(intent)
        }
        doublePlay.setOnClickListener{
            Toast.makeText(this, "double player mode", Toast.LENGTH_SHORT).show();
            playerTwo = true;
            val intent = Intent(this, Board::class.java)
            startActivity(intent)
        }

    }


}