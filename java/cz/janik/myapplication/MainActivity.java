package cz.janik.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView pocetView;
    private EditText editTextView;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pocetView = findViewById(R.id.pocet);
        editTextView = findViewById(R.id.editTextView);
        buttonView = findViewById(R.id.buttonView);

        Hawk.init(this).build();

        /*int pocet_spusteni = Hawk.get("pocet_spusteni",0);
        pocetView.setText(String.valueOf(pocet_spusteni));
        Hawk.put("pocet_spusteni", pocet_spusteni + 1);*/

        /*//pro mince a tutorial pri prvnim spusteni
        SharedPreferences pref = getSharedPreferences("global",0);
        int pocet = pref.getInt("pocet",1);
        pocetView.setText(String.valueOf(pocet));

        *//*SharedPreferences.Editor editor = pref.edit();
        editor.putInt("pocet", pocet + 1);
        editor.apply();*//*

        pref.edit().putInt("pocet", pocet + 1).apply();*/

        /*pref.getString("jmeno","not available");*/
        //editor.commit();
        /*editor.putInt("pocet", 1)*/


        /*emailEditText = findViewById(R.id.editText);
        checkBox = findViewById(R.id.checkBox);*/

    }

    public void zmacknuti(View view) {
        String text = editTextView.getText().toString();
        ArrayList<String> kosik = Hawk.get("kosik", new ArrayList<String>());
        if (kosik.contains(text)) {
            Toast.makeText(this, "Uz to tam je", Toast.LENGTH_LONG).show();
            return;
        }

        kosik.add(text);
        Hawk.put("kosik",kosik);
        for (String polozka: kosik) {
            Log.d("Kosik", polozka);
        }
    }

    public void smazat(View view) {
        Hawk.delete("kosik");
        Hawk.deleteAll();
    }


   /* public void clicked(View view) {
        Toast.makeText(this, String.valueOf(checkBox.isChecked()), Toast.LENGTH_LONG).show();


        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("emailll", emailEditText.getText().toString());

        startActivity(i);

        emailEditText.setText("");

    }

    public void checked(View view) {
        emailEditText.setText(emailEditText.getText().toString() + "@");
    }
*/
}