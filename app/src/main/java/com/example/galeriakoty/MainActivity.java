package com.example.galeriakoty;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private ImageView imageView;
    private Button buttonPrev, buttonNext;
    private EditText editTextNumber;
    private Switch switchColor;
    private LinearLayout mainLayout;

    private int[] images = {
            R.drawable.kot1,
            R.drawable.kot2,
            R.drawable.kot3,
            R.drawable.kot4
    };

    private int aktualnyindex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView_galeria_kotow);
        buttonPrev = findViewById(R.id.button_nastepne_zdj);
        buttonNext = findViewById(R.id.button_poprzednie_zdj);
        editTextNumber = findViewById(R.id.editTextText);
        switchColor = findViewById(R.id.switch1);
        mainLayout = findViewById(R.id.main);


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualnyindex++;
                if (aktualnyindex >= images.length) {
                    aktualnyindex = 0;
                }
                imageView.setImageResource(images[aktualnyindex]);
            }
        });
        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualnyindex--;
                if (aktualnyindex < 0) {
                    aktualnyindex = images.length - 1;
                }
                imageView.setImageResource(images[aktualnyindex]);
            }
        });
        editTextNumber.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(android.text.Editable editable) {
                String text = editable.toString();
                if (!text.isEmpty()) {
                    try {
                        int nr = Integer.parseInt(text);
                        if (nr >= 1 && nr <= images.length) {
                            aktualnyindex = nr - 1;
                            imageView.setImageResource(images[aktualnyindex]);
                        }
                    }

                    catch (NumberFormatException e) {

                    }
                }
            }
        });



        switchColor.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                mainLayout.setBackgroundColor(android.graphics.Color.parseColor("#1565c0"));
            } else {
                mainLayout.setBackgroundColor(android.graphics.Color.parseColor("#00796B"));
            }
        });


    }
}