package com.example.android.cricketscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static com.example.android.cricketscorekeeper.R.id.HomeSpinner;
import static com.example.android.cricketscorekeeper.R.id.VenueSpinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public Spinner homeSpinner, awaySpinner, venueSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateHomeAndAwaySpinners();
    }

    protected void populateHomeAndAwaySpinners() {
        // Populate Home Team Spinner
        homeSpinner = (Spinner) findViewById(HomeSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.hometeam_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        homeSpinner.setAdapter(adapter);
        homeSpinner.setOnItemSelectedListener(this);

        // Populate Away Team Spinner
        awaySpinner = (Spinner) findViewById(R.id.AwaySpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        adapter = ArrayAdapter.createFromResource(this,
                R.array.awayteam_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        awaySpinner.setAdapter(adapter);
    }



    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        venueSpinner = (Spinner) findViewById(VenueSpinner);
        String home = homeSpinner.getSelectedItem().toString();
        ArrayAdapter<CharSequence> adapter = null;
        switch(home) {
            case "India":
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.stadium_India, android.R.layout.simple_spinner_item);
                break;
            case "England":
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.stadium_England, android.R.layout.simple_spinner_item);
                break;
            case "Australia":
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.stadium_Australia, android.R.layout.simple_spinner_item);
                break;
            case "South Africa":
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.stadium_India, android.R.layout.simple_spinner_item);
                break;
            case "West Indies":
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.stadium_India, android.R.layout.simple_spinner_item);
                break;
            case "Pakistan":
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.stadium_India, android.R.layout.simple_spinner_item);
                break;
            case "New Zealand":
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.stadium_India, android.R.layout.simple_spinner_item);
                break;
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        venueSpinner.setAdapter(adapter);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
