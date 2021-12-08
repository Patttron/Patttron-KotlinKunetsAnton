package teach.meskills.unit14

import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.app.Activity
import android.text.TextUtils

class Calculator : Activity(), View.OnClickListener {
    private lateinit var num1: EditText
    private lateinit var num2: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnSub: Button
    private lateinit var btnMult: Button
    private lateinit var btnDiv: Button
    private lateinit var tvResult: TextView
    private var operation = ""
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator_activity)
        num1 = findViewById(R.id.num1)
        num2 = findViewById(R.id.num2)
        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMult = findViewById(R.id.btnMult)
        btnDiv = findViewById(R.id.btnDiv)
        tvResult = findViewById(R.id.tvResult)
        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMult.setOnClickListener(this)
        btnDiv.setOnClickListener(this)
    }

    @SuppressLint("NonConstantResourceId", "SetTextI18n")
    override fun onClick(v: View) {
        val num1: Float
        val num2: Float
        var result = 0f
        if (TextUtils.isEmpty(this.num1.text.toString())
            || TextUtils.isEmpty(this.num2.text.toString())
        ) {
            return
        }
        num1 = this.num1.text.toString().toFloat()
        num2 = this.num2.text.toString().toFloat()
        when (v.id) {
            R.id.btnAdd -> {
                operation = "+"
                result = num1 + num2
            }
            R.id.btnSub -> {
                operation = "-"
                result = num1 - num2
            }
            R.id.btnMult -> {
                operation = "*"
                result = num1 * num2
            }
            R.id.btnDiv -> {
                operation = "/"
                result = num1 / num2
            }
            else -> {}
        }
        tvResult.text = "$num1 $operation $num2 = $result"
    }
}