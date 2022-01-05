package teach.meskills.twofragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Checkboxes: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkboxes)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container,CheckboxesFragment())
            .addToBackStack(null)
            .commit()
    }
}