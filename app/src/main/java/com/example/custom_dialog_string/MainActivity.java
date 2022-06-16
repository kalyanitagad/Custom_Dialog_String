package com.example.custom_dialog_string;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button btnSubmit;
    private String msg;
    private TextView dialogtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
        setBtnListener();
    }
    private void initViews()
    {
        editText = findViewById(R.id.edtMsg);
        btnSubmit = findViewById(R.id.btnSubmit);

    }
    private void setBtnListener() {
        btnSubmit.setOnClickListener(new BtnSubmitClickListener());

    }
    private class BtnSubmitClickListener implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
       DialogActivity dialogSubmit = new DialogActivity(MainActivity.this);
       dialogSubmit.setStringDialog(new StringDialogListener());
       dialogtxt = dialogSubmit.findViewById(R.id.txtDialog);
       msg = editText.getText().toString();
       dialogtxt.setText(msg);
       dialogSubmit.show();
        }
    }
    class StringDialogListener implements DialogActivity.stringDialog
    {

        @Override
        public void finishSuccess() {
        String msg = dialogtxt.getText().toString();
        editText.setText(msg);
        }
    }

}
