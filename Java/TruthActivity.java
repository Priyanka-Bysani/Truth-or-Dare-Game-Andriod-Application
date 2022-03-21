package in.nirajwaghtech.truthordare;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class TruthActivity extends AppCompatActivity {

    private EditText input_truth;
    private ArrayList<String> truth_values = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView simpleListView;
        setContentView(R.layout.activity_truth);
        simpleListView = (ListView) findViewById(R.id.simpleListView);

        String items[] = {"What does your dream boy or girl look like?",
                "Would you rather live with no internet or no A/C or heating?",
                "If you could go back in time in erase one thing you said or did, what would it be?",
                "Have you ever waved at someone thinking they saw you when really they didn't? What did you do when you realized it?",
                "Describe the strangest dream you've ever had. Did you like it?",
                "The world ends next week, and you can do anything you want (even if it's illegal). What would you do?",
                "How far would you go to land the guy or girl of your dreams?",
                "What is the most childish thing that you still do?"};
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);

        truth_values = new ArrayList<>(Arrays.asList(items));

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.item_view, R.id.itemTextView, truth_values);
        simpleListView.setAdapter(arrayAdapter);
        input_truth = (EditText) findViewById(R.id.input_truth);
        Button btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newItem = input_truth.getText().toString();

                if (newItem == null || newItem.length() == 0) {
                    Toast.makeText(TruthActivity.this, "Please add a truth.", Toast.LENGTH_LONG).show();
                } else {
                    truth_values.add(newItem);
                    input_truth.setText("");
                    Toast.makeText(TruthActivity.this, "Truth added!", Toast.LENGTH_LONG).show();
                }
                arrayAdapter.notifyDataSetChanged();
            }
        });
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(view.getContext(), TruthActivity1.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(view.getContext(), TruthActivity2.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(view.getContext(), TruthActivity3.class);
                    startActivity(intent);
                }
                if (i == 3) {
                    Intent intent = new Intent(view.getContext(), TruthActivity4.class);
                    startActivity(intent);
                }
                if (i == 4) {
                    Intent intent = new Intent(view.getContext(), TruthActivity5.class);
                    startActivity(intent);
                }
                if (i == 5) {
                    Intent intent = new Intent(view.getContext(), TruthActivity6.class);
                    startActivity(intent);
                }
                if (i == 6) {
                    Intent intent = new Intent(view.getContext(), TruthActivity7.class);
                    startActivity(intent);
                }
                if (i == 7) {
                    Intent intent = new Intent(view.getContext(), TruthActivity8.class);
                    startActivity(intent);
                }
            }
        });
    }
}