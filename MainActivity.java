package cz.janik.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private Button button;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.editText);
        checkBox = findViewById(R.id.checkBox);





    }


    public void clicked(View view) {
        Toast.makeText(this, String.valueOf(checkBox.isChecked()), Toast.LENGTH_LONG).show();


        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("emailll", emailEditText.getText().toString());

        startActivity(i);

        emailEditText.setText("");

    }

    public void checked(View view) {
        emailEditText.setText(emailEditText.getText().toString() + "@");
    }
}
