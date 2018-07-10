package sg.edu.rp.c346.practicalquiz;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView etName;
    TextView etAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.editTextName);
        etAge=findViewById(R.id.editTextAge);
        etName.requestFocus();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (!etAge.getText().toString().isEmpty()||!etName.getText().toString().isEmpty()) {
            int Age = Integer.parseInt(etAge.getText().toString());
            String name= etName.getText().toString();
            //step1 :Obtain an instance of the SharedPrefences
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            //step2: Obtain an instance of the sharedpreference Editor for the update later
            SharedPreferences.Editor prefEdit = prefs.edit();
            //step3:Add the key-value pair
            prefEdit.putString("name1", name);
            prefEdit.putInt("age1", Age);
            //step4:call commit(0 method to save the changes into the Sharedpreferences
            prefEdit.commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String name = prefs.getString("name1","");
        int age=prefs.getInt("age1",0);
        etAge.setText(String.valueOf(age));
        etName.setText(name);

    }
}
