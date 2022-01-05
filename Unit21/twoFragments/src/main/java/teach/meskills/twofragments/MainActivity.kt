package teach.meskills.twofragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import teach.meskills.twofragments.CheckboxesFragment.Companion.EXTRA
import teach.meskills.twofragments.CheckboxesFragment.Companion.students
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var chosen: TextView

    private val getContent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            activityResult ->
        val resultCode = activityResult.resultCode
        val data = activityResult.data
        if (resultCode == RESULT_OK) {
            data?.getStringArrayListExtra(EXTRA)
            findViewById<Button>(R.id.roll).setOnClickListener {
                val roll = Random.nextInt(students.size)
                chosen.text = students[roll]
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chosen = findViewById(R.id.result)
        findViewById<Button>(R.id.choose).setOnClickListener {
            startActivity(Intent(this,Checkboxes::class.java))
            students.clear()
        }
    }
}