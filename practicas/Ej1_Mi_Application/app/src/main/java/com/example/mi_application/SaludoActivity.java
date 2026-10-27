package com.example.mi_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
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

        ListView view = findViewById(R.id.lista);
        String[] valores = {intent.getStringExtra("nombre"), intent.getStringExtra("pass_registrado"), intent.getStringExtra("direccion_registrado"), intent.getStringExtra("telefono_registrado"), intent.getStringExtra("cp_registrado")};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, valores);
        view.setAdapter(adapter);
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
