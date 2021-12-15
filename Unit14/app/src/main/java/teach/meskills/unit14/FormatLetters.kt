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

            // inputText.setText(formattedText) закоментировал

            var helpStr = ""                       // создадим вспомогательную строковую переменную в которую будем по буквам собирать слова
            val ch = formattedText.toCharArray() // создадим чаровый массив из уже отформатированной пользовательской строки
            val words = mutableListOf<String>() // создадим лист для хранения полученных отдельных слов
            for (i in 0 until ch.size) {       // пробежимся фором по чаровому массиву по буквам собирая слова
                helpStr = helpStr + ch[i]
                if (ch[i] == ' ' || i == ch.size - 1) { // натыкаясь на пробел или на конец строки ( чарового массива в данном случае ), кладем слово в лист
                    helpStr.trim()             // предварительно обрежим пробел с конца слова , чтоб не мешал
                    words.add(helpStr)         //теперь кладем в лист
                    helpStr =
                        ""                 // и обнуляем строку , чтоб после пробела собиралось следующее слово а не наклеивалось на предыдущее
                }
            }
            inputText.setText("")           // теперь обнулим эдитТекст, чтоб вдальнейшем при использовании inputText.append(it+" ") текст не склеивался с предыдущим

            words.sortWith(                // отсортируем повозрастанию, спасибо котлин
                Comparator { cat1, cat2 ->
                    cat1.length - cat2.length
                }
            )
// бежим по отсортированному массиву форычем и добавляем по слову с пробелом в эдитТекст за каждую итерацию
            words.forEach {
            inputText.append(it + " ")
            }
        }




    }
}