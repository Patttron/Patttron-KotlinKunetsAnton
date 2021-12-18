package teach.meskills.unit17

import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.text.TextUtils
import android.widget.Button
import android.widget.Chronometer
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import java.util.*

class Timer : AppCompatActivity() {

    private lateinit var chronometer: Chronometer
    private lateinit var startButton: Button
    private lateinit var startFinalButton: Button
    private lateinit var stopButton: Button
    private lateinit var resetButton: Button
    private lateinit var inputTime: EditText
    var counter: Long = 0L

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timer_activity)
        chronometer = findViewById(R.id.chronometer)
        startButton = findViewById(R.id.btnStart)
        startFinalButton = findViewById(R.id.btnFinal)
        stopButton = findViewById(R.id.btnStop)
        resetButton = findViewById(R.id.btnReset)
        inputTime = findViewById(R.id.etTime)

        startButton.setOnClickListener {
            counter = inputTime.text.toString().toLong()
            chronometer.base = SystemClock.elapsedRealtime() + 1000 * counter
            chronometer.start()
            chronometer.setOnChronometerTickListener {
                if ((SystemClock.elapsedRealtime() > chronometer.base)) {
                    chronometer.stop()
                }
            }
        }
        startFinalButton.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                chronometer.isTheFinalCountDown
            }
        }

        stopButton.setOnClickListener {
            chronometer.stop()
        }

        resetButton.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime()
        }
    }
}
//if ((TextUtils.isEmpty(this.num1.getText().toString())
//|| TextUtils.isEmpty(this.num2.getText().toString()))){
//    return
//}
//
//num1 = this.num1.getText().toString().toFloat()
//num2 = this.num2.getText().toString().toFloat()