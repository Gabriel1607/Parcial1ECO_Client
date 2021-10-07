package com.example.parcial1_client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView titleGen,subTitle1,subTitle2,subTitle3,subTitle4;
private EditText editName,editQuant,editX,editY;
private Button redBtn,greenBtn,blueBtn,createBtn,deleteBtn;
private TCPSingleton tcp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleGen = titleGen.findViewById(R.id.titleGen);
        subTitle1 = subTitle1.findViewById(R.id.subTitle1);
        subTitle2 = subTitle2.findViewById(R.id.subTitle2);
        subTitle3 = subTitle3.findViewById(R.id.subTitle3);
        subTitle4 = subTitle4.findViewById(R.id.subTitle4);
        editName = editName.findViewById(R.id.editName);
        editQuant = editQuant.findViewById(R.id.editQuant);
        editX = editX.findViewById(R.id.editX);
        editY = editY.findViewById(R.id.editY);
        redBtn = redBtn.findViewById(R.id.redBtn);
        greenBtn = greenBtn.findViewById(R.id.greenBtn);
        blueBtn = blueBtn.findViewById(R.id.blueBtn);
        createBtn = createBtn.findViewById(R.id.createBtn);
        deleteBtn = deleteBtn.findViewById(R.id.deleteBtn);
        tcp = TCPSingleton.getInstance();


    }
}