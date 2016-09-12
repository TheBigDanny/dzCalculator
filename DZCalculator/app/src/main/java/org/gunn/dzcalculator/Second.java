package org.gunn.dzcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Joshua on 9/7/2016.
 */
public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent a = getIntent();
        String s = a.getExtras().getString("info");

        TextView v = (TextView) findViewById(R.id.newtext);
        v.setText("Answer is " + s);

    }
}
