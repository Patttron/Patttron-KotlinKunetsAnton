package teach.meskills.unit21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import teach.meskills.unit21.Checkboxes.Companion.studentsArray
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val chosen = findViewById<TextView>(R.id.chosen)
        findViewById<Button>(R.id.remove).setOnClickListener {
            startActivity(Intent(this, Checkboxes::class.java))
        }
        findViewById<Button>(R.id.roll).setOnClickListener {
            val random = Random
            val roll = random.nextInt(studentsArray.size)
            chosen.text = studentsArray[roll]
        }
    }
}