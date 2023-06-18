package com.example.aeon_shopping_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.google.android.material.snackbar.Snackbar

class Food_Content : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_content)

        val add_to_cart=findViewById<Button>(R.id.add_to_cart)
        add_to_cart.setOnClickListener { view->
            Snackbar.make(view,"Added to cart",Snackbar.LENGTH_LONG)
                .setAction("Action",null).show()
        }

        val back=findViewById<ImageButton>(R.id.back)
        back.setOnClickListener {
            val back= Intent(this,Scanner::class.java)
            startActivity(back)
        }
    }
}