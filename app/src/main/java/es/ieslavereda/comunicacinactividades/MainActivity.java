package es.ieslavereda.comunicacinactividades;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombreET;
    private Button bVerificar;
    private TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombreET= findViewById(R.id.nombreEditText);
        bVerificar=findViewById(R.id.buttonVerificar);
        textView=findViewById(R.id.textView);

        ActivityResultLauncher<Intent> lanzadorActividadResultado=
                registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        result -> {
                            if (result.getResultCode()==RESULT_CANCELED)
                                Toast.makeText(this, "Cancelado por el usuario",
                                Toast.LENGTH_LONG).show();
                            if (result.getResultCode()==RESULT_OK){
                                Intent data = result.getData();
                                String resultado =data.getExtras().getString("resultado");
                                textView.setText(resultado);
                            }
                        }
                );

        bVerificar.setOnClickListener( view ->{
            Intent intent=
                    new Intent(getApplicationContext(),MainActivity.class);
            intent.putExtra("nombre", nombreET.getText().toString());
            lanzadorActividadResultado.launch(intent);
        });
    }
}