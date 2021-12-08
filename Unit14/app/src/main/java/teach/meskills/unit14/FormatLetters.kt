package teach.meskills.unit14

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.os.Bundle

class FormatLetters : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.format_letters_activity)
        val formatLetters = findViewById<Button>(R.id.format_button)
        val inputText = findViewById<EditText>(R.id.text)
        formatLetters.setOnClickListener {
            var formattedText = ""
            val array = inputText.text.toString().toCharArray()
            for (i in array.indices) {
                when (array[i]) {
                    'A' -> array[i] = 'O'
                    'a' -> array[i] = 'o'
                    'А' -> array[i] = 'О'
                    'а' -> array[i] = 'о'
                }
                formattedText += array[i]
            }
            inputText.setText(formattedText)
        }
    }
}