package teach.meskills.unit14

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.os.Bundle

class FormatLetters : AppCompatActivity() {
   lateinit var btnSort:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.format_letters_activity)
        val formatLetters = findViewById<Button>(R.id.format_button)
         btnSort= findViewById(R.id.btnSort)
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

        btnSort.setOnClickListener {
           var str:String= inputText.text.toString()
            var helpStr=""
          val  ch=str.toCharArray()
            val cats = mutableListOf<String>()
            for (i in 0 until ch.size ) {
                helpStr=helpStr+ch[i]
                if (ch[i]==' '||i==ch.size-1 ){
                    helpStr.trim()
                    cats.add(helpStr)
                    helpStr=""
                }
            }
            inputText.setText("")

            cats.sortWith(
                Comparator { cat1, cat2 ->
                    cat1.length - cat2.length
                }
            )

            cats.forEach {
               // println("${it.name}: ${it.age}, ${it.weight}")

                inputText.append(it+" ")
            }
        }


    }
}