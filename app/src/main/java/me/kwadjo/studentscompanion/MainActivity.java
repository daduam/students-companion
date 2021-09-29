package me.kwadjo.studentscompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    String[] colleges = { "College of Health Sciences", "College of Basic and Applied Sciences",
            "College of Humanities", "College of Education" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, R.layout.x, colleges);
        TextInputLayout collegesSpinner = (TextInputLayout) findViewById(R.id.form_college_spinner);
        collegesSpinner.setAdapter(arrayAdapter);
    }

    public void saveDetails(View view) {
        Toast.makeText(this, "Details saved", Toast.LENGTH_LONG).show();
    }
}