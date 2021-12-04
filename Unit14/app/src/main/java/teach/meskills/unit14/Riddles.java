package teach.meskills.unit14;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Riddles extends AppCompatActivity {
    Button showMeRiddle, checkMe;
    TextView someRiddle, finishAnswer;
    EditText personAnswer;
    String choseRiddle = "";
    String[] arrayRiddles = {
            "Жёлтый шар, слегка горчит.\n" +
                    "Летом жажду утолит.",
            "Этот фрукт на вкус хорош\n" +
                    "И на лампочку похож.",
            "Сто одежек -\n" +
                    "Все без застежек",
            "В этот гладкий коробок\n" +
                    "Бронзового цвета\n" +
                    "Спрятан маленький дубок\n" +
                    "Будущего лета."};


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddles);
        showMeRiddle = (Button) findViewById(R.id.show_me_riddles);
        someRiddle = (TextView) findViewById(R.id.some_riddle);
        showMeRiddle.setOnClickListener(v -> {
            shuffleArray(arrayRiddles);
            someRiddle.setText(arrayRiddles[0]);
            choseRiddle = arrayRiddles[0];
        });
        rightAnswerRiddle(choseRiddle);
        personAnswer = (EditText) findViewById(R.id.person_answer);
        finishAnswer = (TextView) findViewById(R.id.finishAnswer);
        checkMe = (Button) findViewById(R.id.checkMe);
        checkMe.setOnClickListener(v -> {
          if(personAnswer.getText().toString().equals(rightAnswerRiddle(choseRiddle))){
              finishAnswer.setText("You are right");
          }
          else{
              finishAnswer.setText("Sorry, it's false, right answer is: " + rightAnswerRiddle(choseRiddle));
          }
        });
    }

    static String rightAnswerRiddle(String choseRiddle){
        String rightAnswer;
        if(choseRiddle.startsWith("Жёлтый")){
            rightAnswer = "грейпфрут";
        }
        else if(choseRiddle.startsWith("Этот фрукт")){
            rightAnswer = "груша";
        }
        else if(choseRiddle.startsWith("Сто")){
            rightAnswer = "капуста";
        }
        else {
            rightAnswer = "желудь";
        }
        return rightAnswer;
    }

    void shuffleArray(String [] arrayRiddles) {
        Random random = new Random();
        for (int i = arrayRiddles.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            String a = arrayRiddles[index];
            arrayRiddles[index] = arrayRiddles[i];
            arrayRiddles[i] = a;
        }
    }
}
