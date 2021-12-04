package teach.meskills.unit14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class FormatLetters extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_format_letters);
        Button formatLetters = (Button) findViewById(R.id.format_button);
        EditText inputText = (EditText) findViewById(R.id.text);
        formatLetters.setOnClickListener(v -> {
            String formattedText = "";
            char[] array = inputText.getText().toString().toCharArray();
            for (int i = 0; i < array.length; i++) {
                switch (array[i]) {
                    case 'O':
                        array[i] = 'A';
                        break;
                    case 'o':
                        array[i] = 'a';
                        break;
                    case 'О':
                        array[i] = 'А';
                        break;
                    case 'о':
                        array[i] = 'а';
                        break;
                }
                formattedText += array[i];
            }
            inputText.setText(formattedText);
        });
    }
}