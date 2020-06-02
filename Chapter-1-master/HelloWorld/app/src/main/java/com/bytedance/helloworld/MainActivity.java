package com.bytedance.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "MainActivity");
        Button btn1=findViewById(R.id.btn1);
        final ImageView image1=findViewById(R.id.imageView);
        final TextView text1=findViewById(R.id.textView);
        Switch swi1=findViewById(R.id.switch1);

        btn1.setOnClickListener(new View.OnClickListener() {
            int clock=0;
            @Override
            public void onClick(View view) {
                text1.setText("chapter1 correct");
                Log.d("chapter1_log","button connect");
                if(clock%2==0)
                image1.setVisibility(View.INVISIBLE);
                else
                    image1.setVisibility(View.VISIBLE);
                clock++;
            }
        }) ;
    }
}
