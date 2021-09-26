package com.example.recyclerviewlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var myCL: ConstraintLayout
    private lateinit var myET: EditText
    private lateinit var myButton: Button
    private lateinit var mylist: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        myCL = findViewById(R.id.clRoot)
        mylist = ArrayList()

        rvList.adapter = MessageAdapter(this, mylist)
        rvList.layoutManager = LinearLayoutManager(this)

        myET = findViewById(R.id.etEntry)
        myButton = findViewById(R.id.okButton)

        myButton.setOnClickListener { add() }
    }
    private fun add(){
        val demo = myET.text.toString()
        if(demo.isNotEmpty()){
            mylist.add(demo)
            myET.text.clear()
            myET.clearFocus()
        }else{
            Snackbar.make(clRoot, "Please enter some text", Snackbar.LENGTH_LONG).show()
        }

    }
}