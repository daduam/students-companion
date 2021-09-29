package me.kwadjo.studentscompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ArrayAdapter;

import com.google.android.material.slider.Slider;
import com.google.android.material.sldier.LabelFormatter;

public class MainActivity extends AppCompatActivity {

    private static String[] colleges = { "College of Health Sciences", "College of Basic and Applied Sciences",
            "College of Humanities", "College of Education" };

    EditText mName;
    EditText mIndexNumber;
    AutoCompleteTextView mCollege;
    String level;
    Slider mGpaSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = findViewById(R.id.form_name_input).editText;
        mIndexNumber = findViewById(R.id.form_index_number_input).editText;
        mCollege = (AutoCompleteTextView) findViewById(R.id.form_college_spinner).editText;
        mGpaSlider = findViewById(R.id.form_gpa_slider);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.list_item, colleges);
        mCollege.setAdapter(adapter);

        mGpaSlider.setLabelFormatter(new LabelFormatter() {
            @NonNull
            @Override
            public String getFormattedValue(float value) {
                DecimalFormat df = new DecimalFormat("0.00");
                return df.format(value);
            }
        });
    }

    public void saveDetails(View view) {
        StringBuilder sb = new StringBuilder("");

        String name = mName.getText().toString();
        String indexNumber = mIndexNumber.getText().toString();
        String college = colleges[mCollege.getListSelection()];
        String gpa = mGpaSlider.getValue();

        sb.append("Name: " + name + "\n");
        sb.append("Index Number: " + indexNumber + "\n");
        sb.append("College: " + college + "\n");
        sb.append("Level: " + level + "\n");
        sb.append("GPA: " + gpa + "\n");

        Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
    }

    public void setLevel(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.form_level_100:
                if (checked)
                    this.level = "100";
                break;
            case R.id.form_level_200:
                if (checked)
                    this.level = "200";
                break;
            case R.id.form_level_300:
                if (checked)
                    this.level = "300";
                break;
            case R.id.form_level_400:
                if (checked)
                    this.level = "400";
                break;
        }
    }
}