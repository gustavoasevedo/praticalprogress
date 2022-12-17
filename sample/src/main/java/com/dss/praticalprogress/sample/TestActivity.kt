package com.dss.praticalprogress.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dss.praticalprogress.GlobalProgressBuilder
import com.dss.praticalprogress.ViewProgress
import com.dss.praticalprogress.sample.databinding.ActivityTestBinding
import java.util.Timer
import java.util.TimerTask

class TestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val progress = GlobalProgressBuilder().with(this)
            progress.run()
        }

        binding.btnStartItems.setOnClickListener {
            ViewProgress().with(this).on(binding.textView).runProgressOnView()
            ViewProgress().with(this).on(binding.imageView2).runProgressOnView()
            ViewProgress().with(this).on(binding.switch1).runProgressOnView()
        }

        binding.btnStop.setOnClickListener {
            ViewProgress.finishLoad(binding.textView, this)
            ViewProgress.finishLoad(binding.imageView2, this)
            ViewProgress.finishLoad(binding.switch1, this)
        }

    }
}