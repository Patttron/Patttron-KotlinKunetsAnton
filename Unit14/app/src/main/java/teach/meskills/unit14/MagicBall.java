package teach.meskills.unit14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MagicBall extends AppCompatActivity {
    String [] answers = {"Yes", "No", "Probably yes",
            "Probably not", "Probably",
            "There are prospects",
            "The question is not asked correctly"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_ball);
        Button magicBall = (Button) findViewById(R.id.getAnswer);
        TextView message = (TextView) findViewById(R.id.answer);
        magicBall.setOnClickListener(v -> {
            shuffleArray(answers);
            message.setText(answers[0]);
        });
    }
    void shuffleArray(String[] answers){
        Random random = new Random();
        for (int i = answers.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            String a = answers[index];
            answers[index] = answers[i];
            answers[i] = a;
        }
    }
}