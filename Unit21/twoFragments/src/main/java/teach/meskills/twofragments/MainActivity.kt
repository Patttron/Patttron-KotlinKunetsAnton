package teach.meskills.twofragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val chooseStudents: Button = findViewById(R.id.choose)
        chooseStudents.setOnClickListener {
            if (savedInstanceState == null) {
                val fragment = CheckboxesFragment.newInstance()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit()
//                chooseStudents.visibility = View.INVISIBLE
            }
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment1, Roll())
            .addToBackStack(null)
            .commit()
    }
}
//package teach.meskills.twofragments
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//
//class Checkboxes: AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.checkboxes)
//        if (savedInstanceState == null) {
//            val fragment = CheckboxesFragment.newInstance()
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.container, fragment)
//                .addToBackStack(null)
//                .commit()
//        }
//    }
//}
