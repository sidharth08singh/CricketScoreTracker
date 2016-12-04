package com.example.android.cricketscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View.OnClickListener;


import static com.example.android.cricketscorekeeper.R.id.HomeSpinner;
import static com.example.android.cricketscorekeeper.R.id.VenueSpinner;

public class MainActivity extends AppCompatActivity {

    private Spinner homeSpinner, awaySpinner, venueSpinner;
    private Button btnStartTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateHomeAndAwaySpinners();
    }

    protected void populateHomeAndAwaySpinners() {
        homeSpinner = (Spinner) findViewById(HomeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.hometeam_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        homeSpinner.setAdapter(adapter);
        homeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                venueSpinner = (Spinner) findViewById(VenueSpinner);
                String home = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), home, Toast.LENGTH_SHORT).show();

                populateVenueSpinner(venueSpinner, home);
            }

            public void onNothingSelected(AdapterView<?> parent) {
                //@ToDo
            }
        });

        awaySpinner = (Spinner) findViewById(R.id.AwaySpinner);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.awayteam_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        awaySpinner.setAdapter(adapter);

        addListenerOnButton(homeSpinner, awaySpinner, venueSpinner);
    }

    protected void addListenerOnButton(final Spinner homeSpinner, final Spinner awaySpinner, final Spinner venueSpinner) {
        Button btnStartTrack = (Button) findViewById(R.id.track_btn);
        btnStartTrack.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),
                        "Selected All",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void populateVenueSpinner(Spinner venueSpinner, String home) {
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
}
