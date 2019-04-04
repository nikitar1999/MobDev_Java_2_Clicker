package com.example.mobile_task_1_2_clicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mainText;
    Button subtractButton;
    ImageView resetImage;
    Button addButton;

    private long score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = findViewById(R.id.mainText);
        subtractButton = findViewById(R.id.subtract_button);
        resetImage = findViewById(R.id.reset_image);
        addButton = findViewById(R.id.add_button);

        View.OnClickListener subtractClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score--;
                updateText();
            }
        };
        subtractButton.setOnClickListener(subtractClickListener);
        View.OnClickListener resetClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;
                updateText();
            }
        };
        resetImage.setOnClickListener(resetClickListener);

        View.OnClickListener addClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                updateText();
            }
        };
        addButton.setOnClickListener(addClickListener);

        updateText();
    }

    private void updateText() {
        String endWord = getEndWord();
        String s = "Кнопка нажата " + score + endWord;
        mainText.setText(s.toCharArray(), 0, s.length());
    }

    private String getEndWord() {
        long absScore = Math.abs(score);

        long lastScoreDigit = absScore % 10;

        if (lastScoreDigit == 0 || lastScoreDigit == 1)
            return " раз";

        if (absScore == 2 || absScore == 3 || absScore == 4)
            return " раза";

        if (absScore < 20)
            return " раз";

        return " раза";
    }
}

