package com.example.daniel_asyntask;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainResultado extends AppCompatActivity {

    TextView txtBienvenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_resultado);

        txtBienvenido = findViewById(R.id.txtBienvenido);
        String userName = getIntent().getStringExtra("Usuario");

        txtBienvenido.setText("Bienvenido " + userName);
    }
}