package teach.meskills.unit21

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

class Checkboxes : AppCompatActivity() {
    companion object {
        const val EXTRA = "Students"

        @SuppressLint("StaticFieldLeak")
        var btnOk: Button? = null
        var studentsArray = ArrayList<String>()
        var students = ArrayList<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkboxes)
        findViewById<CheckBox?>(R.id.Stas)
        findViewById<CheckBox?>(R.id.Alex)
        findViewById<CheckBox?>(R.id.Sasha)
        findViewById<CheckBox?>(R.id.Marina)
        findViewById<CheckBox?>(R.id.Nadezhda)
        findViewById<CheckBox?>(R.id.Natali)
        findViewById<CheckBox?>(R.id.Dasha)
        findViewById<CheckBox?>(R.id.Dima)
        findViewById<CheckBox?>(R.id.Egor)
        findViewById<CheckBox?>(R.id.Anton)
        findViewById<CheckBox?>(R.id.Nastya)
        studentsArray.add(0, "Stas")
        studentsArray.add(1, "Alex")
        studentsArray.add(2, "Sasha")
        studentsArray.add(3, "Marina")
        studentsArray.add(4, "Nadezhda")
        studentsArray.add(5, "Natasha")
        studentsArray.add(6, "Dasha")
        studentsArray.add(7, "Dima")
        studentsArray.add(8, "Egor")
        studentsArray.add(9, "Anton")
        studentsArray.add(10, "Nastya")
        btnOk = findViewById(R.id.btnOk)
        btnOk!!.setOnClickListener {
            sendResult()
        }
    }

    fun onCheckboxClick(view: View?) {
        val checkBox = view as CheckBox
        val checked = checkBox.isChecked
        when (view.getId()) {
            R.id.Stas -> if (checked) {
                students.add(studentsArray[0])
            } else {
                students.removeAt(0)
            }
            R.id.Alex -> if (checked) {
                students.add(studentsArray[1])
            } else {
                students.removeAt(1)
            }
            R.id.Sasha -> if (checked) {
                students.add(studentsArray[2])
            } else {
                students.removeAt(2)
            }
            R.id.Marina -> if (checked) {
                students.add(studentsArray[3])
            } else {
                students.removeAt(3)
            }
            R.id.Nadezhda -> if (checked) {
                students.add(studentsArray[4])
            } else {
                students.removeAt(4)
            }
            R.id.Natali -> if (checked) {
                students.add(studentsArray[5])
            } else {
                students.removeAt(5)
            }
            R.id.Dasha -> if (checked) {
                students.add(studentsArray[6])
            } else {
                students.removeAt(6)
            }
            R.id.Dima -> if (checked) {
                students.add(studentsArray[7])
            } else {
                students.removeAt(7)
            }
            R.id.Egor -> if (checked) {
                students.add(studentsArray[8])
            } else {
                students.removeAt(8)
            }
            R.id.Anton -> if (checked) {
                students.add(studentsArray[9])
            } else {
                students.removeAt(9)
            }
            R.id.Nastya -> if (checked) {
                students.add(studentsArray[10])
            } else {
                students.removeAt(10)
            }
        }
    }

    private fun sendResult() {
        setResult(RESULT_OK, Intent().apply {
            putExtra(EXTRA, students)
        })
        finish()
    }
}

