package ibratec.recife.pe.br.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentActivity extends AppCompatActivity {

    EditText editNomeStudent;
    Button btnConfirma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);


        editNomeStudent  = (EditText) findViewById(R.id.nomeStudent);

        btnConfirma = (Button) findViewById(R.id.btnIncluirStudent);
        btnConfirma.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   if (!editNomeStudent.getText().toString().equals("")) {
                       Intent devolve = new Intent();
                       devolve.putExtra(MainActivity.VAR_NOME_STUDENT, editNomeStudent.getText().toString());
                       setResult(Activity.RESULT_OK, devolve);
                       finish();
                   } else {
                       Toast toast = Toast.makeText(getApplicationContext(), "Digite um nome, boy!", Toast.LENGTH_SHORT);
                       toast.show();
                   }

               }
        });

    }




}
