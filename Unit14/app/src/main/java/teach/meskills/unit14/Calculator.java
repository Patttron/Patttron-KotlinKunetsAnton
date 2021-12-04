package teach.meskills.unit14;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends Activity implements View.OnClickListener {
    EditText num1, num2;
    Button btnAdd, btnSub, btnMult, btnDiv;
    TextView tvResult;
    String operation = "";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View v) {

        float num1;
        float num2;
        float result = 0;

        if (TextUtils.isEmpty(this.num1.getText().toString())
                || TextUtils.isEmpty(this.num2.getText().toString())) {
            return;
        }

        num1 = Float.parseFloat(this.num1.getText().toString());
        num2 = Float.parseFloat(this.num2.getText().toString());

        switch (v.getId()) {
            case R.id.btnAdd:
                operation = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                operation = "-";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                operation = "*";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                operation = "/";
                result = num1 / num2;
                break;
            default:
                break;
        }

        tvResult.setText(num1 + " " + operation + " " + num2 + " = " + result);
    }
}
