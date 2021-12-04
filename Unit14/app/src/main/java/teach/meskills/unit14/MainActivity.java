package teach.meskills.unit14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button formatLetters, magicBall, riddles, calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        formatLetters = (Button) findViewById(R.id.format_button);
        magicBall = (Button) findViewById(R.id.magic_ball);
        riddles = (Button) findViewById(R.id.riddles);
        calculator = (Button) findViewById(R.id.calculator);
        formatLetters.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, FormatLetters.class));
        });
        magicBall.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MagicBall.class));
        });
        riddles.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, Riddles.class));
        });
        calculator.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, Calculator.class));
        });
    }
}