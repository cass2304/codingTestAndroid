package com.example.userlab.stylechanger;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StyleChanger extends AppCompatActivity {
    TextView label1, label2, label3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_changer);

        final EditText entry = findViewById(R.id.editText);
        label1 = findViewById(R.id.label1);
        label2 = findViewById(R.id.label2);
        label3 = findViewById(R.id.label3);
        final StyleChanger this_ = this;

        Button btn = findViewById(R.id.btn_randomize);

        entry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    String text = charSequence.toString();
                    String[] split = text.split(" ");

                    if (split.length > 5) {
                        Context context = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, "text should have less than 5 words", duration);
                        toast.show();
                        return;
                    }
                    label1.setText("");
                    label2.setText("");
                    label3.setText("");
                    for (int j = 0; j < split.length; j++) {
                        if (j < split.length / 3) {
                            label1.setText(label1.getText() + " " + split[j]);
                        }
                        if (j >= split.length / 3 && j <= (split.length / 3 * 2)) {
                            label2.setText(label2.getText() + " " + split[j]);
                        }

                        if (j > (split.length / 3) * 2) {
                            label3.setText(label3.getText() + " " + split[j]);
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = entry.getText().toString();

                String[] split = text.split(" ");

                if (split.length > 5) {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, "text should have less than 5 words", duration);
                    toast.show();
                    return;
                }
                label1.setText("");
                label2.setText("");
                label3.setText("");
                for (int i = 0; i < split.length; i++) {
                    if (i < split.length / 3) {
                        label1.setText(label1.getText() + " " + split[i]);
                    }
                    if (i >= split.length / 3 && i <= (split.length / 3 * 2)) {
                        label2.setText(label2.getText() + " " + split[i]);
                    }


                    if (i > (split.length / 3) * 2) {
                        label3.setText(label3.getText() + " " + split[i]);
                    }
                }
                this_.ramdomizeStyle();

            }
        });

    }

    private void ramdomizeStyle() {
        int rand = 1 + (int) (Math.random() * ((4 - 1) + 1));
        switch (rand) {
            case 1:
                label1.setTextAppearance(this, R.style.GreenText);
                break;
            case 2:
                label1.setTextAppearance(this, R.style.BlueText);
                break;
            case 3:
                label1.setTextAppearance(this, R.style.PurpleText);
                break;
            case 4:
                label1.setTextAppearance(this, R.style.RedText);
                break;
        }
        rand = 1 + (int) (Math.random() * ((4 - 1) + 1));
        switch (rand) {
            case 1:
                label2.setTextAppearance(this, R.style.GreenText);
                break;
            case 2:
                label2.setTextAppearance(this, R.style.BlueText);
                break;
            case 3:
                label2.setTextAppearance(this, R.style.PurpleText);
                break;
            case 4:
                label2.setTextAppearance(this, R.style.RedText);
                break;
        }
        rand = 1 + (int) (Math.random() * ((4 - 1) + 1));
        switch (rand) {
            case 1:
                label3.setTextAppearance(this, R.style.GreenText);
                break;
            case 2:
                label3.setTextAppearance(this, R.style.BlueText);
                break;
            case 3:
                label3.setTextAppearance(this, R.style.PurpleText);
                break;
            case 4:
                label3.setTextAppearance(this, R.style.RedText);
                break;
        }

    }
}
