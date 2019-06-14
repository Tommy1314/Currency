package com.home.currency;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ntd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        ntd = findViewById(R.id.ed_ntd);

        }

    public void go(View view) {
        String nd = ntd.getText().toString();
        if (nd.matches("")){            /*布林 Boolean editText use .getText判斷空值*/
//        ntd.getText().toString().matches("");{
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.problem))
                    .setMessage(getString(R.string.please_enter_your_ntd_amount))
                    .setPositiveButton(getString(R.string.ok), null)
                    .show();
        }else {
            float ndc = Float.parseFloat(nd);
            float go = ndc / 30.9f;
            Log.d("MainActivity", "USD is " + go);
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.result))
                    .setMessage(getString(R.string.usd_is) + go)
                    .setPositiveButton((getString(R.string.ok)), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ntd.setText("");
                        }
                    })
                    .show();
        }
    }
}