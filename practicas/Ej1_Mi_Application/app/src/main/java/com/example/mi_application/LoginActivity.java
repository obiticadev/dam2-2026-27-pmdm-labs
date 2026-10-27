package com.example.mi_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private String user_registrado;
    private String pass_registrado;
    private String direccion_registrado;
    private String telefono_registrado;
    private String cp_registrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Vistas enlazadas con los nuevos IDs
        EditText etUser = findViewById(R.id.etUser);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        TextView tvRegistrarse = findViewById(R.id.tvRegistrarse);

        // Recoger los datos enviados desde RegisterActivity con getIntent()
        Intent intent2 = getIntent();
        if (intent2 != null && intent2.hasExtra("user_registrado")) {
            user_registrado = intent2.getStringExtra("user_registrado");
            etUser.setText(user_registrado);

            pass_registrado = intent2.getStringExtra("pass_registrado");
            direccion_registrado = intent2.getStringExtra("direccion_registrado");
            telefono_registrado = intent2.getStringExtra("telefono_registrado");
            cp_registrado = intent2.getStringExtra("cp_registrado");
        }

        // Navegación a la pantalla de Registro
        tvRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        // Botón Login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SaludoActivity.class);

                String content = etUser.getText().toString();
                String content_pass = etPassword.getText().toString();

                intent.putExtra("nombre", content);
                intent.putExtra("pass_registrado", content_pass);

                if (intent2 != null && intent2.hasExtra("direccion_registrado")) {
                    intent.putExtra("direccion_registrado", direccion_registrado);
                }
                if (intent2 != null && intent2.hasExtra("telefono_registrado")) {
                    intent.putExtra("telefono_registrado", telefono_registrado);
                }
                if (intent2 != null && intent2.hasExtra("cp_registrado")) {
                    intent.putExtra("cp_registrado", cp_registrado);
                }

                startActivity(intent);
            }
        });
    }
}
