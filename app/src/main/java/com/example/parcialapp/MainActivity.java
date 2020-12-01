package com.example.parcialapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("message");
    private Button enviarBtn;
    private EditText puntajeInput;
    private TextView preguntaText;
    private Pregunta pregunta;
    private int puntajeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        puntajeInput = findViewById(R.id.puntajeInput);
        preguntaText = findViewById(R.id.preguntaEdit);
        enviarBtn = findViewById(R.id.enviarBtn);
        enviarBtn.setOnClickListener(this);

        database.getReference().child("preguntas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){

                    for (DataSnapshot children: snapshot.getChildren()
                    ) {
                        pregunta = children.getValue(Pregunta.class);
                        preguntaText.setText(pregunta.getPreguntica());
                    }



                }

                else {

                    preguntaText.setText(" ");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.enviarBtn:
                puntajeIn = Integer.parseInt((puntajeInput.getText().toString()));
                if(puntajeIn>=0 && puntajeIn<=10) {
                    String id = UUID.randomUUID().toString();
                    DatabaseReference reference = database.getReference().child("puntajes/" + id);

                    Puntajes puntaje = new Puntajes(
                            id,
                            pregunta.getId(),
                            puntajeIn


                    );
                    reference.setValue(puntaje);
                }
                break;

                }


    }



}




