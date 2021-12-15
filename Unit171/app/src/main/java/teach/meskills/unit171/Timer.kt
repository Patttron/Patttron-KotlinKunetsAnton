package teach.meskills.unit171

import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class Timer : AppCompatActivity() {

    private lateinit var chronometer: Chronometer
    private lateinit var startButton: Button
    private lateinit var stopButton: Button
    private lateinit var resetButton: Button
    private val counter = 5L

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timer_activity)
        chronometer = findViewById(R.id.chronometer)
        startButton = findViewById(R.id.btnStart)
        stopButton = findViewById(R.id.btnStop)
        resetButton = findViewById(R.id.btnReset)


        startButton.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime() + 1000 * counter
            chronometer.start()
            //TODO
        }

        stopButton.setOnClickListener {
            chronometer.stop()
        }

        resetButton.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime()
        }
    }
}
