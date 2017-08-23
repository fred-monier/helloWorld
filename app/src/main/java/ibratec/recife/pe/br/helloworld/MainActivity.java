package ibratec.recife.pe.br.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editToastValue;
    Button buttonToast;
    Button buttonStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


    private class StudentClick implements View.OnClickListener {

        MainActivity mAct;

        public StudentClick(MainActivity mAct) {
            super();
            this.mAct = mAct;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(this.mAct, StudentActivity.class);
            startActivity(intent);
        }
    }
}
