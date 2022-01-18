package teach.meskills.timer

import android.content.Context
import android.os.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var inputSeconds: EditText
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputSeconds = findViewById(R.id.inputSeconds)
        text = findViewById(R.id.text)
        val viewModel = ViewModelProvider(this).get(TimerViewModel::class.java)
        viewModel.timerStateLiveData.value = false
        findViewById<Button>(R.id.start).setOnClickListener {
            if (inputSeconds.text.isNotEmpty()) {
                input = inputSeconds.text.toString().toInt()
                if (viewModel.timerStateLiveData.value == false) {
                    viewModel.start()
                }
                vibrate()
            } else {
                text.text = "Enter some number"
            }
        }
        findViewById<Button>(R.id.pause).setOnClickListener {
            if (viewModel.timerStateLiveData.value!!) {
                viewModel.pause()
            }
        }
        findViewById<Button>(R.id.reset).setOnClickListener {
            viewModel.reset()

        }
        viewModel.someData.observe(this, Observer { text.text = it.toString() })
    }

    private fun vibrate() {
        val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager =
                this.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator
        } else {
            this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(
                VibrationEffect.createOneShot(
                    500,
                    VibrationEffect.DEFAULT_AMPLITUDE
                )
            )
        } else {
            //deprecated in API 26
            vibrator.vibrate(500)
        }
    }

    companion object {
        var input = 0
    }
}
