package teach.meskills.unit17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnTimer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnTimer = findViewById(R.id.btnTimer)
        btnTimer.setOnClickListener() {
            startActivity(Intent(this, Timer::class.java))
        }
    }
}