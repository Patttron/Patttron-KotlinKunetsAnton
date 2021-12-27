package teach.meskills.unit21

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

class Checkboxes : AppCompatActivity() {
    companion object {
        var studentsArray = ArrayList<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<LinearLayout>(R.id.liner)
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
    }

    fun onCheckboxClick(view: View) {
        val checkBox = view as CheckBox
        val checked = checkBox.isChecked
        when (view.getId()) {
            R.id.Stas -> if (checked) {
                studentsArray.removeAt(0)
            }
            R.id.Alex -> if (checked) {
                studentsArray.removeAt(1)
            }
            R.id.Sasha -> if (checked) {
                studentsArray.removeAt(2)
            }
            R.id.Marina -> if (checked) {
                studentsArray.removeAt(3)
            }
            R.id.Nadezhda -> if (checked) {
                studentsArray.removeAt(4)
            }
            R.id.Natali -> if (checked) {
                studentsArray.removeAt(5)
            }
            R.id.Dasha -> if (checked) {
                studentsArray.removeAt(6)
            }
            R.id.Dima -> if (checked) {
                studentsArray.removeAt(7)
            }
            R.id.Egor -> if (checked) {
                studentsArray.removeAt(8)
            }
            R.id.Anton -> if (checked) {
                studentsArray.removeAt(9)
            }
            R.id.Nastya -> if (checked) {
                studentsArray.removeAt(10)
            }
        }
    }
}
