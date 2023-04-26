package com.maxescobar.calculadoraconspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner seleccion;
    private EditText numeroA,numeroB;
    private TextView tviewResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numeroA = (EditText) findViewById(R.id.numeroA);
        numeroB = (EditText) findViewById(R.id.numeroB);
        tviewResultado = (TextView) findViewById(R.id.tvResultado);
        seleccion = (Spinner) findViewById(R.id.spinner);

        String []select = {"Sumar","Restar","Multiplicar","Dividir"};

        ArrayAdapter <String> seleccionOpciones = new ArrayAdapter<>(this, R.layout.spinner_item_color,select);

        seleccion.setAdapter(seleccionOpciones);
    }

    //Metodo del boton
    public void btnCalcular(View vista){

        //Parsear a String
        String valor_A = numeroA.getText().toString();
        String valor_B = numeroB.getText().toString();

        //Conversion a int
        int numeroA = Integer.parseInt(valor_A);
        int numeroB = Integer.parseInt(valor_B);

        //Trabajo con spinner
        String opcion = seleccion.getSelectedItem().toString();
        if (opcion.equals("Sumar")){
            int sumar = numeroA + numeroB;
            tviewResultado.setText(String.valueOf(sumar));
        }
        if(opcion.equals("Restar")){
            int restar = numeroA - numeroB;
            tviewResultado.setText(String.valueOf(restar));
        }
        if(opcion.equals("Multiplicar")){
            int multiplicar = numeroA * numeroB;
            tviewResultado.setText(String.valueOf(multiplicar));
        }
        if(opcion.equals("Dividir")){
            if (numeroB == 0){
                Toast.makeText(this,"¡¡No se puede dividir por cero!!",Toast.LENGTH_LONG).show();
            }else{
                int dividir = numeroA / numeroB;
                tviewResultado.setText(String.valueOf(dividir));
            }
        }
    }


}