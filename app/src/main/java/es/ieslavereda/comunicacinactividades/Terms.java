package es.ieslavereda.comunicacinactividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Terms extends AppCompatActivity {
    private Button aceptarB;
    private Button cancelarB;
    private TextView textoTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);
        aceptarB= findViewById(R.id.buttonAcept);
        cancelarB= findViewById(R.id.buttonDecline);
        textoTV= findViewById(R.id.conditions);

        Bundle extras = getIntent().getExtras();
        String s = extras.getString("nombre");
        textoTV.setText("Hola "+s+" ¿Aceptas las condiciones?");

        aceptarB.setOnClickListener( view -> {
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            intent.putExtra("resultado", "Ha aceptado las condiciones");
            finish();
        });

        cancelarB.setOnClickListener( view -> {
            Intent intent = new Intent();
            setResult(RESULT_CANCELED, intent);
            intent.putExtra("resultado", "Ha cancelado las condiciones");
            finish();
        });
    }
}
