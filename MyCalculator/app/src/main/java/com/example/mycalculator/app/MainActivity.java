package com.example.mycalculator.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.lang.String;

public class MainActivity extends ActionBarActivity {

    //ArrayList display = new ArrayList(10);
    Boolean isDecimalUsed = false;
    Boolean secondNumber = false;
    Boolean overwrite = false;
    double decimalLeadingZeroes = 0;
    static String EMPTY = "";
    static String ONE = "1";
    static String TWO = "2";
    static String THREE = "3";
    static String FOUR = "4";
    static String FIVE = "5";
    static String SIX = "6";
    static String SEVEN = "7";
    static String EIGHT = "8";
    static String NINE = "9";
    static String ZERO = "0";
    static String MULTIPLY = "*";
    static String DIVIDE = "/";
    static String ADD = "+";
    static String SUBTRACT = "-";
    static String EQUAL = "=";
    static String DECIMAL = ".";
    static String CLR = "CLR";
    String op = EMPTY;
    double num1 = 0;
    double num2 = 0;

    double current_value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    //calculator function
    public void one (View view) {
        updateScreen(ONE);
    }

    //calculator function
    public void two (View view) {
        updateScreen(TWO);
    }

    //calculator function
    public void three (View view) {
        updateScreen(THREE);
    }

    //calculator function
    public void four (View view) {
        updateScreen(FOUR);
    }

    //calculator function
    public void five (View view) {
        updateScreen(FIVE);
    }

    //calculator function
    public void six (View view) {
        updateScreen(SIX);
    }

    //calculator function
    public void seven (View view) {
        updateScreen(SEVEN);
    }

    //calculator function
    public void eight (View view) {
        updateScreen(EIGHT);
    }

    //calculator function
    public void nine (View view) {
        updateScreen(NINE);
    }

    //calculator function
    public void zero (View view) {
        updateScreen(ZERO);
    }

    //calculator function
    public void multiply (View view) {
        updateScreen(MULTIPLY);
    }

    //calculator function
    public void divide (View view) {
        updateScreen(DIVIDE);
    }

    //calculator function
    public void add (View view) {
        updateScreen(ADD);
    }

    //calculator function
    public void subtract (View view) {
        updateScreen(SUBTRACT);
    }

    //calculator function
    public void equal (View view) {
        updateScreen(EQUAL);
    }

    public void decimal (View view){
        updateScreen(DECIMAL);
    }

    //calculator function
    public void clear (View view) {
        updateScreen(CLR);
    }

    public void useOp(String op)
    {
        //num1 = Double.parseDouble((String) display.get(0));
        //num2 = Double.parseDouble((String) display.get(1));
        if (this.op.equals(MULTIPLY))
        {
            //display.add(0, String.valueOf(num1 * num2));
            num1 = num1 * num2;
        }
        else if (this.op.equals(ADD))
        {
            //display.add(0, String.valueOf(num1 + num2));
            num1 = num1 + num2;
        }
        else if (this.op.equals(SUBTRACT))
        {
            //display.add(0, String.valueOf(num1 - num2));
            num1 = num1 - num2;
        }
        else if (this.op.equals(DIVIDE))
        {
            //display.add(0, String.valueOf(num1 / num2));
            if (num2 == 0)
            {
                num1 = Double.POSITIVE_INFINITY;
            }
            else
            {
                num1 = num1 / num2;
            }
        }
        secondNumber = false;
        op = EMPTY;
    }

    public void updateScreen(String command)
    {
        double temp = 0;
        TextView textview = (TextView) findViewById(R.id.results);

        if (command.equals(CLR))
        {
            //display.clear();
            //display.add(0, "0");
            num1 = 0;
            num2 = 0;
            isDecimalUsed = false;
            secondNumber = false;
            decimalLeadingZeroes = 0;
            op = EMPTY;
            overwrite = false;
        }
        else if (command.equals(EQUAL))
        {
            //display.clear();
            useOp(op);
            op = EMPTY;
            isDecimalUsed = false;
            decimalLeadingZeroes = 0;
            secondNumber = false;
            overwrite = true;
            num2 = 0;
        }
        else if (command.equals(MULTIPLY) ||
                command.equals(ADD) ||
                command.equals(SUBTRACT) ||
                command.equals(DIVIDE))
        {
            useOp(op); //in case there was another operation before
            op = command;
            isDecimalUsed = false;
            decimalLeadingZeroes = 0;
            secondNumber = false;
            overwrite = false;
            num2 = 0;
        }
        else if (command.equals(DECIMAL))
        {
            isDecimalUsed = true;
        }
        else
        {
            temp = Double.parseDouble(command);
            if (overwrite)
            {
                num1 = 0;
            }
            if (op.equals(EMPTY))
            {
                if (isDecimalUsed)
                {
                    if (temp == 0)
                    {
                        decimalLeadingZeroes = decimalLeadingZeroes + 1;
                    }
                    else
                    {
                        for (int i = 0; i < decimalLeadingZeroes; i++)
                        {
                            temp = temp / 10;
                        }
                        num1 = num1 + temp;
                        decimalLeadingZeroes = 0;
                    }
                }
                else
                {
                    //display.add(0, display.get(0) + command);
                    num1 = (num1 * 10) + temp;
                }
            }
            else
            {
                secondNumber = true;
                if (isDecimalUsed)
                {
                    //display.add(1, display.get(1) + command);
                    if (temp == 0)
                    {
                        decimalLeadingZeroes = decimalLeadingZeroes + 1;
                    }
                    else
                    {
                        for (int i = 0; i < decimalLeadingZeroes; i++)
                        {
                            temp = temp / 10;
                        }
                        num2 = num2 + temp;
                        decimalLeadingZeroes = 0;
                    }
                }
                else
                {
                    //display.add(1, display.get(1) + command);
                    num2 = (num2 * 10) + temp;
                }
            }
        }
        if (op.equals(EMPTY))
        {
            textview.setText(String.valueOf(num1));
        }
        else if (!secondNumber)
        {
            textview.setText(String.valueOf(num1) + op);
        }
        else
        {
            textview.setText(String.valueOf(num1) + op + String.valueOf(num2));
        }
    }
}
