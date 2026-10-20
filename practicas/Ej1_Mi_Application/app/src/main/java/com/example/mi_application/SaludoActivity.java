package com.example.mi_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SaludoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saludo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Enlazamos con los nuevos IDs
        TextView tvMensajeSaludo = findViewById(R.id.tvMensajeSaludo);
        Button btnVolver = findViewById(R.id.btnVolver);

        Intent intent = getIntent();
        String mensaje = intent.getStringExtra("nombre");
        tvMensajeSaludo.setText(mensaje);

        // Botón para volver a LoginActivity
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Tu lógica al pulsar volver
                Intent intent1 = new Intent(SaludoActivity.this, LoginActivity.class);
                startActivity(intent1);
            }
        });
    }
}
