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

            var helpStr =
                ""                                 // создадим вспомогательную строковую переменную в которую будем по буквам собирать слова
            var str =
                ""                                  // создадим вспомогательную строковую переменную в которую будем по буквам собирать слова и еще менять цифры на слова
            val ch =
                (formattedText + " ").toCharArray()             // создадим чаровый массив из уже отформатированной пользовательской строки

            for (i in 0 until ch.size) {
                if (ch[i] == '1' && ch[i + 1] == '0') {
                    str = str + "десять "
                } else if (numberMap.containsKey(ch[i].toString())) {
                    str = str + numberMap.getValue(ch[i].toString())
                } else {
                    if (ch[i] == '0' && ch[i - 1] == '1') {
                        continue
                    } else {
                        str = str + ch[i]
                    }
                }
            }
            val numbersAsWordsCharArray =
                str.toCharArray()           // новый чаровый мвссив с поменяными цифрами на слова
            val words =
                mutableListOf<String>()                // создадим лист для хранения полученных отдельных слов
            for (i in 0 until numbersAsWordsCharArray.size) {       // пробежимся фором по чаровому массиву по буквам собирая слова
                helpStr = helpStr + numbersAsWordsCharArray[i]
                if (numbersAsWordsCharArray[i] == ' ' || i == numbersAsWordsCharArray.size - 1) {         // натыкаясь на пробел или на конец строки ( чарового массива в данном случае ), кладем слово в лист
                    // предварительно обрежим пробел с конца слова , чтоб не мешал
                    words.add(helpStr.trim())                                     //теперь кладем в лист
                    helpStr =
                        ""                                        // и обнуляем строку , чтоб после пробела собиралось следующее слово, а не наклеивалось на предыдущее
                }
            }
            inputText.setText("")                               // теперь обнулим эдитТекст, чтоб вдальнейшем при использовании inputText.append(it+" ") текст не склеивался с предыдущим

            words.sortWith(                                          // отсортируем по возрастанию, спасибо котлин
                Comparator { cat1, cat2 ->
                    cat1.length - cat2.length
                }

            )

            var finaleS=""
// бежим по отсортированному массиву форычем и добавляем по слову в конечную строку за каждую итерацию
            words.forEach {

                finaleS= finaleS+it+" "

            }

            inputText.setText(finaleS.trim())

        }


    }
}