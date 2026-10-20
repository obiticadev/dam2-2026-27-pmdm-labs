package com.example.mi_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {
    private EditText etName, etPassword, etDireccion, etTelefono, etCp;
    private CheckBox cbHombre, cbMujer;
    private RadioButton rbEmpleado;
    private ToggleButton tbAdmin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.register_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        etDireccion = findViewById(R.id.etDireccion);
        etTelefono = findViewById(R.id.etTelefono);
        etCp = findViewById(R.id.etCp);
        cbHombre = findViewById(R.id.cbHombre);
        cbMujer = findViewById(R.id.cbMujer);
        rbEmpleado = findViewById(R.id.rbEmpleado);
        tbAdmin = findViewById(R.id.tbAdmin);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);

                intent.putExtra("user_registrado", etName.getText().toString().trim());
                intent.putExtra("pass_registrado", etPassword.getText().toString().trim());
                intent.putExtra("direccion_registrado", etDireccion.getText().toString().trim());
                intent.putExtra("telefono_registrado", etTelefono.getText().toString().trim());
                intent.putExtra("cp_registrado", etCp.getText().toString().trim());

                startActivity(intent);
                finish();
            }
        });
    }
}
