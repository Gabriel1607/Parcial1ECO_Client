package com.example.parcial1_client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.parcial1_client.model.Particle;
import com.google.gson.Gson;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private TextView titleGen,subTitle1,subTitle2,subTitle3,subTitle4;
private EditText editName,editQuant,editX,editY;
private Button redBtn,greenBtn,blueBtn,createBtn,deleteBtn;
private TCPSingleton tcp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleGen = findViewById(R.id.titleGen);
        subTitle1 = findViewById(R.id.subTitle1);
        subTitle2 = findViewById(R.id.subTitle2);
        subTitle3 = findViewById(R.id.subTitle3);
        subTitle4 = findViewById(R.id.subTitle4);
        editName = findViewById(R.id.editName);
        editQuant = findViewById(R.id.editQuant);
        editX = findViewById(R.id.editX);
        editY = findViewById(R.id.editY);
        redBtn = findViewById(R.id.redBtn);
        greenBtn = findViewById(R.id.greenBtn);
        blueBtn = findViewById(R.id.blueBtn);
        createBtn = findViewById(R.id.createBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
        tcp = TCPSingleton.getInstance();
        createBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.createBtn:
                Gson gson = new Gson();
                float posX = 50.5F;
                float posY = 12.5F;
                int r= 255;
                int g = 0;
                int b = 0;
                String grupo = "Grupo 1";
                int parNum = 3;
                Particle obj = new Particle(posX,posY,r,g,b,grupo,parNum);
                String json = gson.toJson(obj);
                tcp.sendMessage(json);
                break;
        }
    }
}