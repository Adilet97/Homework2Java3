package com.example.homework2java3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText email, subject, body;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.et1);
        subject = findViewById(R.id.et2);
        body = findViewById(R.id.et3);
        btn = findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!email.getText().toString().isEmpty() && !subject.getText().toString().isEmpty()
                        && !body.getText().toString().isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, new String[]{subject.getText().toString()});
                    intent.putExtra(Intent.EXTRA_TEXT, new String[]{body.getText().toString()});
                    intent.setType("message/rfc822");
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }else {Toast.makeText(MainActivity.this, "There is no application", Toast.LENGTH_SHORT);}
                } else {
                    Toast.makeText(MainActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}