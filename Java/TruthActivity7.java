package in.nirajwaghtech.truthordare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TruthActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truth7);
        Button return_btn = (Button) findViewById(R.id.return_btn);
        return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TruthActivity7.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}