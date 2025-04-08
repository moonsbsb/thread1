package com.example.threadpractice

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.threadpractice.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

    val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val a = A()
        val b = B()

        a.start()
        a.join()
        b.start()
    }
    class A: Thread(){
        override fun run() {
            super.run()
            for(i in 1 .. 1000){
                Log.d("test", "first: $i")
            }
        }
    }
    class B : Thread(){
        override fun run() {
            super.run()
            for(i in 1000 downTo 1){
                Log.d("test", "second: $i")
            }
        }
    }
}
        /*val handler = Handler(Looper.getMainLooper())

        val imageList = arrayListOf<Int>()

        imageList.add(R.drawable.bear)
        imageList.add(R.drawable.duke_background)
        imageList.add(R.drawable.bear)
        imageList.add(R.drawable.duke_background)
        imageList.add(R.drawable.bear)
        imageList.add(R.drawable.duke_background)
        imageList.add(R.drawable.duke_background)
        imageList.add(R.drawable.bear)
        imageList.add(R.drawable.duke_background)

        Thread{
            for(image in imageList){
                handler.post {
                    binding.iv.setImageResource(image)
                }
                Thread.sleep(2000)
            }
        }.start()
    }
}*/