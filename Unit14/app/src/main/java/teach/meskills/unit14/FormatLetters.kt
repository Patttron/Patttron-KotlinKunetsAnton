package teach.meskills.unit14

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.os.Bundle

class FormatLetters : AppCompatActivity() {
    val numberMap = mutableMapOf<String, String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.format_letters_activity)
        numberMap.put("1", "один")
        numberMap.put("2", "два")
        numberMap.put("3", "три")
        numberMap.put("4", "четыре")
        numberMap.put("5", "пять")
        numberMap.put("6", "шесть")
        numberMap.put("7", "семь")
        numberMap.put("8", "восемь")
        numberMap.put("9", "девять")
        numberMap.put("10", "десять")


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
        // inputText.setText(formattedText) закоментировал
        var string=formattedText
            string.replace("10", numberMap.getValue("10"),true)
                .also { string = it }
            string.forEach {
                if (numberMap.containsKey(it.toString()))
                    string.replace(it.toString(), numberMap.getValue(it.toString()))
                        .also { string = it }
            }


            val sl = string.split(" ")

            var stringList = sl.sortedWith(Comparator { word1, word2 ->
                word1.length - word2.length

            })

            inputText.setText( stringList.joinToString(" "))

        }


    }
}