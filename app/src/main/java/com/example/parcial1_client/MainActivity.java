package com.example.parcial1_client;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parcial1_client.model.Particle;
import com.google.gson.Gson;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private TextView titleGen,subTitle1,subTitle2,subTitle3,subTitle4;
private EditText editName,editQuant,editX,editY;
private Button redBtn,greenBtn,blueBtn,createBtn,deleteBtn;
private TCPSingleton tcp;
private float posX,posY;
private int r,g,b,parNum;
private String grupo;
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
        redBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
        blueBtn.setOnClickListener(this);
        editQuant.setInputType(2);
        editQuant.setFilters(new InputFilter[] { new InputFilter.LengthFilter(2) });
        editX.setInputType(2);
        editX.setFilters(new InputFilter[] { new InputFilter.LengthFilter(3) });
        editY.setInputType(2);
        editY.setFilters(new InputFilter[] { new InputFilter.LengthFilter(3) });

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.redBtn:
                redBtn.setText("✓");
                greenBtn.setText("");
                blueBtn.setText("");
                 r = 193;
                 g = 29;
                 b = 29;
                break;
            case R.id.greenBtn:
                redBtn.setText("");
                greenBtn.setText("✓");
                blueBtn.setText("");
                r = 76;
                g = 175;
                b = 80;
                break;
            case R.id.blueBtn:

                redBtn.setText("");
                greenBtn.setText("");
                blueBtn.setText("✓");
                r = 63;
                g = 81;
                b = 181;
                break;
            case R.id.createBtn:
                     if(!editName.getText().toString().replaceAll("\\s","").isEmpty()&&
                        !editQuant.getText().toString().replaceAll("\\s","").isEmpty()&&
                             !editX.getText().toString().replaceAll("\\s","").isEmpty()&&
                             !editY.getText().toString().replaceAll("\\s","").isEmpty()) {
                    Gson gson = new Gson();
                    posX = Float.parseFloat(editX.getText().toString());
                    posY = Float.parseFloat(editY.getText().toString());
                    grupo = editName.getText().toString();
                    parNum = Integer.parseInt(editQuant.getText().toString());
                    Particle obj = new Particle(posX, posY, r, g, b, grupo, parNum);
                    String json = gson.toJson(obj);
                    tcp.sendMessage(json);
                }else{
                         Toast.makeText(this, "Por favor, llena todos los datos", Toast.LENGTH_SHORT).show();
                     }
                break;
        }
    }
}