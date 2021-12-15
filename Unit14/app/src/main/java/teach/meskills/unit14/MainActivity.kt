package teach.meskills.unit14

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.os.Bundle
import android.content.Intent

class MainActivity : AppCompatActivity() {
    private lateinit var formatLetters: Button
    private lateinit var magicBall: Button
    private lateinit var riddles: Button
    private lateinit var calculator: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        formatLetters = findViewById(R.id.format_button)
        magicBall = findViewById(R.id.magic_ball)
        riddles = findViewById(R.id.riddles)
        calculator = findViewById(R.id.calculator)
        formatLetters.setOnClickListener {
            startActivity(
                Intent(
                    this, FormatLetters::class.java
                )
            )
            // Новый комит для тренировки
        }
        magicBall.setOnClickListener {
            startActivity(
                Intent(
                    this, MagicBall::class.java
                )
            )
        }
        riddles.setOnClickListener {
            startActivity(
                Intent(
                    this, Riddles::class.java
                )
            )
        }
        calculator.setOnClickListener {
            startActivity(
                Intent(
                    this, Calculator::class.java
                )
            )
        }
    }
}