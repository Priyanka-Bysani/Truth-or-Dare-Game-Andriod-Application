package in.nirajwaghtech.truthordare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView img_bottle, img_circle;
    private int lastPosition, newPosition, maxRotationPos, minRotationPos, rotationDurationPos, duration, minRotation, maxRotation;
    private Random random=new Random();
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private int[] imgCircleIds={R.drawable.circle2, R.drawable.circle3, R.drawable.circle4, R.drawable.circle5, R.drawable.circle6};
    private final Integer[] minRotationsList ={1,3,5,7,9,11,13};
    private final Integer[] maxRotationsList ={2,4,6,8,10,12,14,16};
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

        img_bottle=findViewById(R.id.img_bottle);
        img_circle=findViewById(R.id.img_circle);
        navigationView=findViewById(R.id.navigationView);
        drawerLayout=findViewById(R.id.drawerLayout);

        sharedPreferences=getSharedPreferences("settings", MODE_PRIVATE);
        editor= sharedPreferences.edit();

        img_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newPosition=random.nextInt(maxRotation-minRotation)+minRotation;
                int pivoitX=img_bottle.getWidth()/2;
                int pivoitY=img_bottle.getHeight()/2;
                Animation rotate= new RotateAnimation(lastPosition, newPosition, pivoitX, pivoitY);
                rotate.setDuration(duration);
                rotate.setFillAfter(true);
                img_bottle.startAnimation(rotate);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.menuSettings:
                        Intent intentSettings=new Intent(MainActivity.this, AppSettings.class);
                        startActivity(intentSettings);
                        break;

                    case R.id.menuAbout:
                        Intent intentAbout=new Intent(MainActivity.this, AppAbout.class);
                        startActivity(intentAbout);
                        break;

                }
                return false;
            }
        });
    }


    public void openMenu(View view) {
        drawerLayout.openDrawer(Gravity.LEFT);
    }

    public void openSettings(View view) {
        Intent intent=new Intent(this, AppSettings.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        int playersCountPosition=sharedPreferences.getInt("playersCountPosition", 0);
        img_circle.setImageResource(imgCircleIds[playersCountPosition]);
        minRotationPos=sharedPreferences.getInt("minRotationPos", 1);
        maxRotationPos=sharedPreferences.getInt("maxRotationPos", 4);
        rotationDurationPos=sharedPreferences.getInt("rotationDurationPos", 1);
        duration=((rotationDurationPos+1)*2)*1000;
        minRotation=minRotationsList[minRotationPos]*360;
        maxRotation=maxRotationsList[maxRotationPos]*360;

    }

    public void openTruth(View view) {
        Button truth_add =(Button)findViewById(R.id.btn_truth);
        truth_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TruthActivity.class);
                startActivity(intent);
            }
        });
    }

    public void openDare(View view) {
        Button dare_add =(Button)findViewById(R.id.btn_dare);
        dare_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DareActivity.class);
                startActivity(intent);
            }
        });
    }
}
