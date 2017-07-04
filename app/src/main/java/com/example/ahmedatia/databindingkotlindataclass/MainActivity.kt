package com.example.ahmedatia.databindingkotlindataclass

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.example.ahmedatia.databindingkotlindataclass.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

//data Binding Exp :
// https://medium.com/@jlkuma/androids-data-binding-with-kotlin-df94a24ffc0f
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ActivityMainBinding name of xml file but first Character is UpperCase
        // then in the end add Binding
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        // data class with only One Constructor
        val user1 = DataClass1Constructor("Ahmed", 23)

        // data class with Two One Constructor
        val user22= DataClass2Constructor("Ahmed", 23)
        val user21= DataClass2Constructor("Ahmed Atia", 23,"http://i.imgur.com/DvpvklR.png")


        val image = findViewById(R.id.profile_image) as ImageView

        binding.setVariable(BR.dataClass2Constructor, user21)


        binding.executePendingBindings()

        Picasso.with(applicationContext).load(user21.photo).into(image)
        Log.e("The Url Of Photo IS",user21.photo)

        //Button
        val next = findViewById(R.id.btn) as Button
        next.setOnClickListener {
            val intent: Intent = Intent()
            setResult(RESULT_OK, intent)
            finish()
        }


    }
}
