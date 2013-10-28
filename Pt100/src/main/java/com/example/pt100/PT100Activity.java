package com.example.pt100;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class PT100Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt100);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pt100, menu);
        return true;

    }
    public void tipp(View v){
        final EditText editT = (EditText) findViewById(R.id.editT);
        String Temp = editT.getText().toString();
        System.out.println(Temp );
        final EditText editR = (EditText) findViewById(R.id.editR);
        editR.setText(TtoR(Temp));


    }
    private String TtoR(String Temp){
        double t=Double.parseDouble((Temp));
        double r=100*(1+ 0.00390263*t  -0.0000050925*t*t - 4.183e-12*(t-100)*t*t*t);
        int a=(int) (r*100.0);
        r=a/100.0;
        return (Double.toString( r));
    }
    private String RtoT(String Widerstand){
        double r=Double.parseDouble(Widerstand);

        double t=( -0.00000567*r*r*r+0.0024984*r*r+2.22764*r-242.078);
        int a=(int) (t*100.0);
        t=a/100.0;
        return (Double.toString(t));
    }

}
