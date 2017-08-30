package ibratec.recife.pe.br.helloworld;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String VAR_NOME_STUDENT = "nomeStudent";

    private static final int INSERIR_ESTUDANTE = 1;
    private static final String LISTA_ESTUDANTES = "listaStudents";

    EditText editToastValue;
    Button buttonToast;
    Button buttonStudent;

    ArrayList<String> listaStudents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            listaStudents = savedInstanceState.getStringArrayList(LISTA_ESTUDANTES);
            this.montarLista();
        } else {
            listaStudents = new ArrayList<String>();
        }

        editToastValue  = (EditText) findViewById(R.id.editText);

        buttonToast = (Button) findViewById(R.id.button1);
        buttonToast.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Toast toast = Toast.makeText(getApplicationContext(), editToastValue.getText(), Toast.LENGTH_SHORT);
                   toast.show();
               }
           }
        );

        buttonStudent = (Button) findViewById(R.id.button2);
        buttonStudent.setOnClickListener(new StudentClick(this));
        /*
        buttonStudent.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                   Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                   startActivity(intent);
              }
          }
        );
        */
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(LISTA_ESTUDANTES, listaStudents);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.opcoes_estudante, menu);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == INSERIR_ESTUDANTE) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {

                String nomeStudent = data.getStringExtra(MainActivity.VAR_NOME_STUDENT);
                listaStudents.add(nomeStudent);
                this.montarLista();
            }
        }
    }

    private void montarLista() {
        ArrayAdapter<String> listaStudentsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1
                ,listaStudents);
        ListView listaStudentsView = (ListView) findViewById(R.id.listview1);
        listaStudentsView.setAdapter(listaStudentsAdapter);

        registerForContextMenu(listaStudentsView);
    }

    private class StudentClick implements View.OnClickListener {

        MainActivity mAct;

        public StudentClick(MainActivity mAct) {
            super();
            this.mAct = mAct;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(this.mAct, StudentActivity.class);
            startActivityForResult(intent, INSERIR_ESTUDANTE);
        }
    }
}
