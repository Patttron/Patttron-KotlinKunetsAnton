package teach.meskills.twofragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import java.util.ArrayList

class CheckboxesFragment : Fragment(), CompoundButton.OnCheckedChangeListener {
    companion object {
        const val REQUEST_KEY = "students"
        const val BUNDLE_KEY = "bundleStudents"
        fun newInstance(): CheckboxesFragment {
            return CheckboxesFragment()
        }
    }

    var students = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.checkboxes_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view.findViewById<CheckBox?>(R.id.Stas).setOnCheckedChangeListener(this)
        view.findViewById<CheckBox?>(R.id.Alex).setOnCheckedChangeListener(this)
        view.findViewById<CheckBox?>(R.id.Sasha).setOnCheckedChangeListener(this)
        view.findViewById<CheckBox?>(R.id.Marina).setOnCheckedChangeListener(this)
        view.findViewById<CheckBox?>(R.id.Nadezhda).setOnCheckedChangeListener(this)
        view.findViewById<CheckBox?>(R.id.Natali).setOnCheckedChangeListener(this)
        view.findViewById<CheckBox?>(R.id.Dasha).setOnCheckedChangeListener(this)
        view.findViewById<CheckBox?>(R.id.Dima).setOnCheckedChangeListener(this)
        view.findViewById<CheckBox?>(R.id.Egor).setOnCheckedChangeListener(this)
        view.findViewById<CheckBox?>(R.id.Anton).setOnCheckedChangeListener(this)
        view.findViewById<CheckBox?>(R.id.Nastya).setOnCheckedChangeListener(this)
        view.findViewById<CheckBox?>(R.id.Nastya).setOnCheckedChangeListener(this)
        view.findViewById<Button>(R.id.btnOk).setOnClickListener {
            sendResult(students)
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        if (buttonView != null) {
            when (buttonView.id) {
                R.id.Stas -> if (isChecked) {
                    students.add("Stas")
                } else {
                    students.remove("Stas")
                }
                R.id.Alex -> if (isChecked) {
                    students.add("Alex")
                } else {
                    students.remove("Alex")
                }
                R.id.Sasha -> if (isChecked) {
                    students.add("Sasha")
                } else {
                    students.remove("Sasha")
                }
                R.id.Marina -> if (isChecked) {
                    students.add("Marina")
                } else {
                    students.remove("Marina")
                }
                R.id.Nadezhda -> if (isChecked) {
                    students.add("Nadezhda")
                } else {
                    students.remove("Nadezhda")
                }
                R.id.Natali -> if (isChecked) {
                    students.add("Natasha")
                } else {
                    students.remove("Natasha")
                }
                R.id.Dasha -> if (isChecked) {
                    students.add("Dasha")
                } else {
                    students.remove("Dasha")
                }
                R.id.Dima -> if (isChecked) {
                    students.add("Dima")
                } else {
                    students.remove("Dima")
                }
                R.id.Egor -> if (isChecked) {
                    students.add("Egor")
                } else {
                    students.remove("Egor")
                }
                R.id.Anton -> if (isChecked) {
                    students.add("Anton")
                } else {
                    students.remove("Anton")
                }
                R.id.Nastya -> if (isChecked) {
                    students.add("Nastya")
                } else {
                    students.remove("Nastya")
                }
            }
        }
    }

    private fun sendResult(message: ArrayList<String>) {
        setFragmentResult(REQUEST_KEY, bundleOf(BUNDLE_KEY to message))
        parentFragmentManager.popBackStack()
    }
}


