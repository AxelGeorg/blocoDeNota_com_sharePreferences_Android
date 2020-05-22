package br.ifsc.edu.myblocodenotas;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor edit;
    EditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.editText);
        sharedPreferences = getSharedPreferences("MinhasNotasDB", MODE_PRIVATE);
        edit=sharedPreferences.edit();
        
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!text.getText().toString().trim().isEmpty()){
                    edit.putString("nota", text.getText().toString());
                    edit.commit();
                }else{
                    Toast.makeText(getApplicationContext(), "Não é possivel adicionar notas vazias!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void recuperar(View view) {
        if(sharedPreferences.contains("nota")){

        text.setText(sharedPreferences.getString("nota",""));
    }else{
        Toast.makeText(getApplicationContext(), "Não foi foi possivel encontra notas!!!", Toast.LENGTH_SHORT).show();
    }
    }
}
