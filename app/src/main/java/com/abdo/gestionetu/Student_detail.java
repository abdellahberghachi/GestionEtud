package com.abdo.gestionetu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Student_detail extends AppCompatActivity {
Button save,close,delete;
 EtudiantBDD ebdd;
    Etudiant e ;
    EditText nom,email,age;
    Intent i;
    Etudiant m;
    String mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);
         i = getIntent();
         mode=i.getStringExtra("mode");
        nom=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        age=(EditText)findViewById(R.id.age);
        ebdd = new EtudiantBDD(this);
        save = (Button)findViewById(R.id.save);
        close=(Button)findViewById(R.id.close);
        delete=(Button)findViewById(R.id.delete);
        if(mode.equals("1")){
             m = ebdd.getEtudiantById(i.getStringExtra("id"));
            nom.setText(m.getNom());
            email.setText(m.getEmail());
            age.setText(""+m.getAge());
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mode.equals("1")){
                    m.setNom(nom.getText().toString());
                    m.setEmail(email.getText().toString());
                    m.setAge(Integer.parseInt(age.getText().toString()));
                    ebdd.updateMovie(m,i.getStringExtra("id"),getApplicationContext());
                    finish();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    i.putExtra("mode","reload");
                    startActivity(i);
                }
                if(mode.equals("2")){
                e=new Etudiant(nom.getText().toString(),email.getText().toString(),Integer.parseInt(age.getText().toString()));
                ebdd.insertEtudiant(e,getApplicationContext());
                finish();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    i.putExtra("mode","reload");
                    startActivity(i);}

            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ebdd.removeMovie(Integer.parseInt(i.getStringExtra("id")),getApplicationContext());
                finish();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("mode","reload");
                startActivity(i);
            }
        });

    }
}
