package com.fernando.touch

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    val DEBUG_TAG : String? = "touch"
    private var secuence : ArrayList<Int>? = ArrayList()
    private val touchSequence : ArrayList<Int>? = ArrayList()
    private val TapAndMove : ArrayList<Int>? = ArrayList()
    var movementz : Float? = null


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        touchSequence?.add(0)
        touchSequence?.add(1)
        touchSequence?.add(0)
        touchSequence?.add(0)

        TapAndMove?.add(0)
        TapAndMove?.add(11)
        TapAndMove?.add(1)






//        if(onTouchEvent() == true){




    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        var pointerIndex = event?.getActionIndex()
        var pointerId = event?.getActionMasked()
        var x = event?.getX()
        var y = event?.getY()


        when (event?.actionMasked) {

            MotionEvent.ACTION_DOWN,
            MotionEvent.ACTION_POINTER_DOWN,
            MotionEvent.ACTION_POINTER_UP-> {
//                Log.i(DEBUG_TAG, "this is $pointerIndex")
//                Log.i(DEBUG_TAG, "this is $pointerId")
//
                Log.i(DEBUG_TAG, "this is $secuence")
//                Log.i(DEBUG_TAG, "this is $touchSecuence")
                pointerIndex?.let { secuence?.add(it) }
                if(secuence?.equals(touchSequence)!! ){
                    Toast.makeText(applicationContext, "tap sequence", Toast.LENGTH_SHORT).show()
                    secuence?.clear()

                }  else if (secuence?.equals(TapAndMove)!!) {
                    Toast.makeText(applicationContext, "slice movement", Toast.LENGTH_SHORT).show()

                }    else if( secuence?.size == 5){
                    secuence?.clear()
                }
            }
            MotionEvent.ACTION_UP -> {
                movementz = null
                secuence?.clear()
            }

            MotionEvent.ACTION_MOVE-> {
                if(movementz == null){
                    movementz = x!! + 80
                }
                if ((secuence?.size == 1)){
                    if (x!! >= movementz!!) {
                        secuence?.add(11)
                    }

                }
            }
        }

        return true
    }

}




