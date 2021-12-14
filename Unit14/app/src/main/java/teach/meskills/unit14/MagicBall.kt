package teach.meskills.unit14

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.os.Bundle


class MagicBall : AppCompatActivity() {
    private val answers = arrayOf(
        "Yes", "No", "Probably yes",
        "Probably not", "Probably",
        "There are prospects",
        "The question is not asked correctly"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.magic_ball_activity)
        val magicBall = findViewById<Button>(R.id.getAnswer)
        val message = findViewById<TextView>(R.id.answer)
        magicBall.setOnClickListener {
            val shuffle = Shuffle(answers.size)
            message.text = answers[shuffle.doShuffle()]
        }
    }
}