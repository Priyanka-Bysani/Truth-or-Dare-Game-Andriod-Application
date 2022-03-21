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
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class DareActivity extends AppCompatActivity {

    private EditText input_dare;
    private ArrayList<String> dare_values = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView simpleListView;
        setContentView(R.layout.activity_dare);
        simpleListView = (ListView) findViewById(R.id.simpleListView);


        // array objects
    String items[] = {"Rate everyone in the room from 1 to 10, with 10 being the best personality.",
            "Go to next door with a measuring cup and ask for a cup of sugar.",
            "Open Facebook,go to the account of the first person you see, and like every post on their wall going back to a year.",
            "Call your crush.",
            "Eat a spoonful of mustard.",
            "Write a letter to your doctor describing an embarrassing rash you have,and post it on Facebook.",
            "Let the group choose three random things from the refrigerator and mix them together.Then you have to eat it.",
            "Dig through the trash and name everything you find.",
            "Call a NY-style pizza place and ask them what the difference is between NY pizza and real pizza.",
            "Take a selfie with the pet and post it online."
            };
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);

        dare_values = new ArrayList<>(Arrays.asList(items));

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.item_view_dare, R.id.itemTextView, dare_values);
        simpleListView.setAdapter(arrayAdapter);
        input_dare = (EditText) findViewById(R.id.input_dare);
        Button btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newItem = input_dare.getText().toString();

                if (newItem == null || newItem.length() == 0) {
                    Toast.makeText(DareActivity.this, "Please add a dare.", Toast.LENGTH_LONG).show();
                } else {
                    dare_values.add(newItem);
                    input_dare.setText("");
                    Toast.makeText(DareActivity.this, "Dare added!", Toast.LENGTH_LONG).show();
                }
                arrayAdapter.notifyDataSetChanged();
            }
        });
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(view.getContext(), DareActivity1.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(view.getContext(), DareActivity2.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(view.getContext(), DareActivity3.class);
                    startActivity(intent);
                }
                if (i == 3) {
                    Intent intent = new Intent(view.getContext(), DareActivity4.class);
                    startActivity(intent);
                }
                if (i == 4) {
                    Intent intent = new Intent(view.getContext(), DareActivity5.class);
                    startActivity(intent);
                }
                if (i == 5) {
                    Intent intent = new Intent(view.getContext(), DareActivity6.class);
                    startActivity(intent);
                }
                if (i == 6) {
                    Intent intent = new Intent(view.getContext(), DareActivity7.class);
                    startActivity(intent);
                }
                if (i == 7) {
                    Intent intent = new Intent(view.getContext(), DareActivity8.class);
                    startActivity(intent);
                }
                if (i == 8) {
                    Intent intent = new Intent(view.getContext(), DareActivity9.class);
                    startActivity(intent);
                }
                if (i == 9) {
                    Intent intent = new Intent(view.getContext(), DareActivity10.class);
                    startActivity(intent);
                }
            }
        });

    }
}