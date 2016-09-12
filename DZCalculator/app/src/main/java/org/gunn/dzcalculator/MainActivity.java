package org.gunn.dzcalculator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static class ids{
        static TextView result;
        static TextView equation;
        static EditText userOperand1;
        static EditText userOperand2;
        static Button multiply;
        static Button divide;
        static Button add;
        static Button subtract;
    }


    public double userOperand1Value;
    public double userOperand2Value;
    public double answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ids.userOperand1 = (EditText)findViewById(R.id.userOperand1);
        ids.userOperand2 = (EditText)findViewById(R.id.userOperand2);
        ids.result = (TextView)findViewById(R.id.result);
        ids.equation = (TextView)findViewById(R.id.equation);
        userOperand1Value = 0.0;
        userOperand2Value = 0.0;
        answer = 0.0;
    }

    public void clicked(View v) {
        //Explicit Intent
        Intent i = new Intent(this, Second.class);
        i.putExtra("info", answer);
        startActivity(i);
    }

    public void clicked2(View v) {

        String url = "http://gunn.pausd.org/ ";
        Intent i2 = new Intent(Intent.ACTION_VIEW);
        i2.setData(Uri.parse(url));
        if(i2.resolveActivity(getPackageManager()) != null) {
            startActivity(i2);
        }
    }

    public void clearing(View view) {
        ids.result.setText("");
        ids.equation.setText("");
        ids.userOperand1.setText("");
        ids.userOperand2.setText("");
    }


    public void addNums(View view) {
        if( (ids.userOperand1.getText().toString().isEmpty()) || (ids.userOperand2.getText().toString().isEmpty()) ) {
            ids.equation.setText("Error: Did not input operand values");
        } else {
            userOperand1Value = Double.parseDouble(ids.userOperand1.getText().toString());
            userOperand2Value = Double.parseDouble(ids.userOperand2.getText().toString());
            ids.equation.setText(userOperand1Value + " + " + userOperand2Value);
            ids.result.setText(Double.toString(userOperand1Value + userOperand2Value));
            answer = userOperand1Value + userOperand2Value;
            System.out.println(answer);
        }


    }

    public void subtractNums(View view) {
        if( (ids.userOperand1.getText().toString().isEmpty()) || (ids.userOperand2.getText().toString().isEmpty()) ) {
            ids.equation.setText("Error: Did not input operand values");
        }
        userOperand1Value = Double.parseDouble(ids.userOperand1.getText().toString());
        userOperand2Value = Double.parseDouble(ids.userOperand2.getText().toString());

            ids.equation.setText(userOperand1Value + " - " + userOperand2Value);
            ids.result.setText(Double.toString(userOperand1Value - userOperand2Value));
            answer = userOperand1Value - userOperand2Value;
    }

    public void multiplyNums(View view) {
        if( (ids.userOperand1.getText().toString().isEmpty()) || (ids.userOperand2.getText().toString().isEmpty()) ) {
            ids.equation.setText("Error: Did not input operand values");
        }
        userOperand1Value = Double.parseDouble(ids.userOperand1.getText().toString());
        userOperand2Value = Double.parseDouble(ids.userOperand2.getText().toString());

            ids.equation.setText(userOperand1Value + " * " + userOperand2Value);
            ids.result.setText(Double.toString(userOperand1Value * userOperand2Value));
            answer = userOperand1Value * userOperand2Value;
    }

    public void divideNums(View view) {
       if( (ids.userOperand1.getText().toString().isEmpty()) || (ids.userOperand2.getText().toString().isEmpty()) ) {
           ids.equation.setText("Error: Did not input operand values");
       }
        userOperand1Value = Double.parseDouble(ids.userOperand1.getText().toString());
        userOperand2Value = Double.parseDouble(ids.userOperand2.getText().toString());
        ids.equation.setText(userOperand1Value + " / " + userOperand2Value);

            if (userOperand2Value == 0) {
                ids.result.setText("Error: Trying to divide by zero");
            } else {
                ids.result.setText(Double.toString(userOperand1Value / userOperand2Value));
            }
            answer = userOperand1Value / userOperand2Value;

    }




}
