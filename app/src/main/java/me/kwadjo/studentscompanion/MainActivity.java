package me.kwadjo.studentscompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ArrayAdapter;
    
import com.google.android.material.slider.Slider;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final String[] colleges = {"College of Health Sciences", "College of Basic and Applied Sciences", "College of Humanities", "College of Education"};

    EditText mName;
    EditText mIndexNumber;
    AutoCompleteTextView mCollege;
    String level;
    Slider mGpaSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = findViewById(R.id.form_name_input);
        mIndexNumber = findViewById(R.id.form_index_number_input);
        mCollege = findViewById(R.id.form_college_spinner);
        mGpaSlider = findViewById(R.id.form_gpa_slider);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, colleges);
        mCollege.setAdapter(adapter);

        mGpaSlider.setLabelFormatter(value -> {
            DecimalFormat df = new DecimalFormat("0.00");
            return df.format(value);
        });
    }

    public void saveDetails(View view) {
        StringBuilder sb = new StringBuilder();

        String name = mName.getText().toString();
        String indexNumber = mIndexNumber.getText().toString();
        String college = colleges[mCollege.getListSelection()];
        String gpa = String.valueOf(mGpaSlider.getValue());

        sb.append("Name: ").append(name).append("\n");
        sb.append("Index Number: ").append(indexNumber).append("\n");
        sb.append("College: ").append(college).append("\n");
        sb.append("Level: ").append(level).append("\n");
        sb.append("GPA: ").append(gpa).append("\n");

        Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
    }

    public void setLevel(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        int viewId = view.getId();
        if (checked) {
            if (viewId == R.id.form_level_100) {
                this.level = "100";
            } else if (viewId == R.id.form_level_200) {
                this.level = "200";
            } else if (viewId == R.id.form_level_300) {
                this.level = "300";
            } else if (viewId == R.id.form_level_400) {
                this.level = "400";
            }
        }
    }
}