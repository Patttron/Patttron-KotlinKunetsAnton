package teach.meskills.unit21

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import teach.meskills.unit21.Checkboxes.Companion.students
import kotlin.random.Random

class MainActivity : Activity() {
    private lateinit var chosen: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chosen = findViewById(R.id.chosen)
        val intent = Intent(this, Checkboxes::class.java)
        findViewById<Button>(R.id.remove).setOnClickListener {
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.getStringArrayListExtra("array")
        findViewById<Button>(R.id.roll).setOnClickListener {
            val random = Random
            val roll = random.nextInt(students.size)
            chosen.text = students[roll]
        }
    }
}
