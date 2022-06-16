package com.example.custom_dialog_string;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class DialogActivity  extends Dialog {

    private TextView txtDialog;
    private RadioGroup stringRadioGroup;
    private CheckBox checkReverse;
    private String txtMsg;
    private Button btnFinish;
    private char reverseArray[];
    private boolean ischecked;
    private String reverseMsg = "";


    public interface stringDialog {
        void finishSuccess();

    }

    private stringDialog stringDialog;
    public void setStringDialog(stringDialog stringDialog){
        this.stringDialog = stringDialog;
    }

    public DialogActivity(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_layout);

        initViews();
        initListener();
    }


    private  void initViews()
    {
        txtDialog = findViewById(R.id.txtDialog);
        stringRadioGroup = findViewById(R.id.stringRadioGroup);
        checkReverse = findViewById(R.id.checkreverse);
        btnFinish = findViewById(R.id.btnfinish);

    }
    private void initListener()
    {
        btnFinish.setOnClickListener(new btnFisnishClickListener());
        checkReverse.setOnCheckedChangeListener(new checkReverseClick());
        stringRadioGroup.setOnCheckedChangeListener(new radioClickListener());
    }
    private class btnFisnishClickListener implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
         stringDialog.finishSuccess();
         dismiss();
        }
    }
    private class checkReverseClick implements CompoundButton.OnCheckedChangeListener
    {

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            ischecked = checkReverse.isChecked();
            if(ischecked)
            {
                txtMsg=txtDialog.getText().toString();
                reverseArray = txtMsg.toCharArray();
                for (int i = reverseArray.length-1;i>=0;i--)
                {
                    reverseMsg = reverseMsg+reverseArray[i];
                }
                txtDialog.setText(reverseMsg);
            }

        }
    }
    private class radioClickListener implements RadioGroup.OnCheckedChangeListener
    {

        @Override
        public void onCheckedChanged(RadioGroup radiogroup, int i) {

            switch (i)
            {
                case R.id.radiobtnuppercase:
                    txtMsg = txtDialog.getText().toString().toUpperCase();
                    txtDialog.setText(txtMsg);
                    break;

                case R.id.radiobtnlowercase:
                    txtMsg = txtDialog.getText().toString().toLowerCase();
                    txtDialog.setText(txtMsg);
                    break;
                case R.id.radiobtnincapital:
                    txtMsg = txtDialog.getText().toString();
                    txtMsg = txtMsg.substring(0,1).toUpperCase()+txtMsg.substring(1).toLowerCase();
                    txtDialog.setText(txtMsg);
                    break;
            }

        }
    }
}
