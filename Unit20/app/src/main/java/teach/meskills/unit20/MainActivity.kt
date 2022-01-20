package teach.meskills.unit20

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var counter = 0
    private val counterKey = "counter_key"
    private lateinit var click: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(MyLifecycleEventObserver())
        click = findViewById(R.id.textView)
        findViewById<Button>(R.id.clicker).setOnClickListener {
            counter++
            click.text = "Click $counter"
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(this.toString(), "on Start")
    }

    override fun onResume() {
        super.onResume()
        Log.i(this.toString(), "on Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(this.toString(), "on Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(this.toString(), "on Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(this.toString(), "on Destroy")
    }

    @SuppressLint("SetTextI18n")
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(counterKey, counter)
        super.onSaveInstanceState(outState)
        Log.i(this.toString(), "on Save Instance State")
    }

    @SuppressLint("SetTextI18n")
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt(counterKey)
        click.text = "Click $counter"
        Log.i(this.toString(), "on Restore Instance State")
    }
}