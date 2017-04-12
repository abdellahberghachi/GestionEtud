package com.abdo.gestionetu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button add,listall ;
    EtudiantBDD bdd;
    EtudiantAdapter adapter;;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=(Button)findViewById(R.id.add);
        listall=(Button)findViewById(R.id.listall) ;
        bdd = new EtudiantBDD(this);
        list = (ListView) findViewById(R.id.list);
        Intent i =getIntent();
        String mode;
        mode="noreload";


        if( i.getStringExtra("mode")!=null){
            adapter = new EtudiantAdapter(getApplicationContext(), R.layout.list_item_etudiant, bdd.getListEtudiant());


            list.setAdapter(adapter);
        }
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Student_detail.class);
                i.putExtra("mode", "2");
                startActivity(i);
            finish();
            }
        });
        listall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                adapter = new EtudiantAdapter(getApplicationContext(), R.layout.list_item_etudiant, bdd.getListEtudiant());


                list.setAdapter(adapter);





            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, int i, long l) {
                final View vId = adapterView.getChildAt(i).findViewById(R.id.id);
                final TextView tvId = (TextView) vId;

                Intent intent = new Intent(getApplicationContext(), Student_detail.class);
                intent.putExtra("id", tvId.getText().toString());
                intent.putExtra("mode", "1");
                startActivity(intent);
            }
        });
    }
}
