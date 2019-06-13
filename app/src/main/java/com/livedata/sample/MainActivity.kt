package com.livedata.sample

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.livedata.sample.listener.ConvertListenr
import com.livedata.sample.viewmodel.LiveDataViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.annotations.Nullable

class MainActivity : AppCompatActivity(), ConvertListenr {
    override fun convertMessage(converDollar:Float) {
        Toast.makeText(this, "Indian Amount is:" + converDollar.toString(), Toast.LENGTH_SHORT).show()    }

    lateinit var liveDataViewModel: LiveDataViewModel
    lateinit var changeObserver: Observer<Float>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_main)
        liveDataViewModel = ViewModelProviders.of(this).get(LiveDataViewModel::class.java)
        liveDataViewModel.setListener(this)
        btnConvert.setOnClickListener {
            liveDataViewModel.setDollarValue(edtDollar.text.toString())
        }

        changeObserver = Observer<Float> { value ->
            value?.let {
                txtIndAmnt.text = "INDIAN AMOUNT:" + it
            }
            }

            liveDataViewModel.getIndValue().observe(this, changeObserver)

        }
    }





