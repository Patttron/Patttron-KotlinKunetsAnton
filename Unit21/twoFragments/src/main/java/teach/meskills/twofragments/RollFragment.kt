package teach.meskills.twofragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import kotlin.random.Random

class RollFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.roll_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val chooseStudents: Button = view.findViewById(R.id.choose)
        chooseStudents.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment1, CheckboxesFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
        val chosen = view.findViewById<TextView>(R.id.result)
        setFragmentResultListener(CheckboxesFragment.REQUEST_KEY) { _, bundle ->
            val students = bundle.getStringArrayList(CheckboxesFragment.BUNDLE_KEY)
            view.findViewById<Button>(R.id.roll).setOnClickListener {
                if (students != null) {
                    if (students.size != 0) {
                        chosen.text = students[Random.nextInt(students.size)]
                    } else {
                        chosen.text = "Choose some students"
                    }
                }
            }
        }
    }
}