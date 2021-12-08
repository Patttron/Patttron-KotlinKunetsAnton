package teach.meskills.unit14

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.annotation.SuppressLint
import android.os.Bundle
import teach.meskills.unit14.ExampleRiddles.Companion.arrayAnswers
import teach.meskills.unit14.ExampleRiddles.Companion.arrayRiddles

class Riddles : AppCompatActivity() {
    private lateinit var showMeRiddle: Button //кнопка показывает загадку
    private lateinit var checkMe: Button // проверяет правльный ли ответ
    private lateinit var someRiddle: TextView // показывает загадку текст
    private lateinit var rightAnswer: TextView //показывает правильный ли ответ
    private lateinit var personAnswer: EditText //ответ пользователя
    private lateinit var choseRiddle: String //выбранная рандомом загадка
    private var random: Int = 0
    private var right: String = ""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.riddles_activity)
        showMeRiddle = findViewById(R.id.show_me_riddles)
        someRiddle = findViewById(R.id.some_riddle)
        showMeRiddle.setOnClickListener {
            val shuffle = Shuffle(arrayRiddles().size)
            random = shuffle.doShuffle()
            right = arrayAnswers()[random].toString()
            rightAnswer = findViewById(R.id.rightAnswer)
            choseRiddle = arrayRiddles()[random].toString()
            someRiddle.text = choseRiddle
        }
        checkMe = findViewById(R.id.checkMe)
        checkMe.setOnClickListener {
            personAnswer = findViewById(R.id.person_answer)
            if (personAnswer.text.toString() == right) {
                rightAnswer.text ="You are right, answer is $right"
            } else {
                rightAnswer.text ="Sorry, right answer is $right"
            }
        }
    }
}

