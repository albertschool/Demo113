package com.example.demo113;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author		Albert Levy <albert.school2015@gmail.com>
 * @version     1.0
 * @since		14/12/2019
 * Basic application to demonstrate writing & reading file from internal storage
 */
public class MainActivity extends AppCompatActivity {

    EditText eT;
    TextView tV;

    String strwr, line, strrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eT=(EditText)findViewById(R.id.eT);
        tV=(TextView)findViewById(R.id.tV);
    }

    /**
     * Writing to text file "test.txt" from the text the user typed
     * <p>
     *
     * @param view
     */
    public void write(View view) {
        strwr=eT.getText().toString();
        try {
            FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(strwr);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Clearing the text file "test.txt" to null
     * <p>
     *
     * @param view
     */
    public void reset(View view) {
        try {
            FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write("");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        eT.setText("");
        tV.setText("");
    }

    /**
     * Reading the text file "test.txt" to the textview widget in the screen
     * <p>
     *
     * @param view
     */
    public void read(View view) {
        try {
            FileInputStream fis= openFileInput("test.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            line = br.readLine();
            while (line != null) {
                sb.append(line+'\n');
                line = br.readLine();
            }
            strrd=sb.toString();
            isr.close();
            tV.setText(strrd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
