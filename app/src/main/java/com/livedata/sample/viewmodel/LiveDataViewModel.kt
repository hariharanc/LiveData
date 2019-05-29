package com.livedata.sample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.livedata.sample.listener.ConvertListenr


class LiveDataViewModel : ViewModel() {
    var usaToInd = 70.0F
    var dollar: Float = 0.0F
    private var result = MutableLiveData<Float>()
    lateinit var convertListenr: ConvertListenr

    fun setDollarValue(value: String) {
        dollar = value.toFloat()
       val converDollar=dollar * usaToInd
        result.postValue(converDollar)
        convertListenr.convertMessage(converDollar)

    }

    fun getIndValue(): MutableLiveData<Float> {
        return result
    }

    fun setListener(convertListenr: ConvertListenr) {
       this.convertListenr=convertListenr
    }

}