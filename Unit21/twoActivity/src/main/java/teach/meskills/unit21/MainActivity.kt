package teach.meskills.unit21

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import teach.meskills.unit21.Checkboxes.Companion.EXTRA
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var chosen: TextView

    private val getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            val resultCode = activityResult.resultCode
            val data = activityResult.data
            findViewById<Button>(R.id.roll).setOnClickListener {
                val students = data?.getStringArrayListExtra(EXTRA)
                if (resultCode == RESULT_OK) {
                    if (students != null) {
                        chosen.text = students[Random.nextInt(students.size)]
                    }
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chosen = findViewById(R.id.chosen)
        findViewById<Button>(R.id.choose).setOnClickListener {
            getContent.launch(Intent(this, Checkboxes::class.java))
        }
        findViewById<Button>(R.id.roll).setOnClickListener {
            chosen.text = "Choose some student"
        }
    }
}
