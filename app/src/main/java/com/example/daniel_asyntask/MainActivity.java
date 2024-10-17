package com.example.daniel_asyntask;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etUser, etPass;
    Button btn1;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etUser = findViewById(R.id.et1);
        etPass = findViewById(R.id.et2);

        btn1 = findViewById(R.id.btnIngresar);
        progressBar = findViewById(R.id.progressBar);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                new Task().execute(etUser.getText().toString());
            }
        });
    }

    class Task extends AsyncTask<String, Void, String>{

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            btn1.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();

            }
            return strings[0];
        }

        @Override
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.VISIBLE);
            btn1.setEnabled(true);
            Intent intent = new Intent(MainActivity.this, MainResultado.class);
            intent.putExtra("Usuario", etUser.getText().toString());
            startActivity(intent);
        }


    }
}