package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Declare an instant of Viewmodel
    private lateinit var viewModel: CounterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Initialise ViewModel
        viewModel.counter.observe(this, Observer <Int>{
            if(viewModel.counter.value==10)endGame()
        }
        )

        viewModel=ViewModelProviders.of(this).get(CounterViewModel::class.java)
        buttonAdd.setOnClickListener(){
            viewModel.increment()
            textViewCounter.text=viewModel.counter.toString()
        }
        buttonMinus.setOnClickListener(){
            viewModel.decrement()
            textViewCounter.text=viewModel.counter.toString()
        }

    }
    private fun endGame(){
        Toast.makeText(applicationContext,
            "Counter==10",Toast.LENGTH_LONG).show()
    }
}
