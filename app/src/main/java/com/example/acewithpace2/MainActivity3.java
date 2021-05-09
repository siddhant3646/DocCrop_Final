package com.example.acewithpace2;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
public class MainActivity3 extends AppCompatActivity {
    private EditText editTextMobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        editTextMobile = findViewById(R.id.mobilemum);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobile = editTextMobile.getText().toString().trim();

                if(mobile.isEmpty() || mobile.length() < 10){
                    editTextMobile.setError("Enter a valid mobile");
                    return;
                }

                Intent intent = new Intent(MainActivity3.this,MainActivity4.class);
                intent.putExtra("mobile", mobile);
                startActivity(intent);
            }
        });
    }
}