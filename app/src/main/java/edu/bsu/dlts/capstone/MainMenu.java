package edu.bsu.dlts.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class MainMenu extends AppCompatActivity {
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        configureTourButton();
        configureBrowseToursButton();
        configureLogOutButton();
        configureYGButton();
    }

    private void configureTourButton(){
        Button startTour = (Button) findViewById(R.id.button4);
        startTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainMenu.this, TourActivity.class);
                startActivity(intent2);
            }
        });
    }

    private void configureYGButton(){
        Button YG = (Button) findViewById(R.id.YGbutton);
        YG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent30 = new Intent(MainMenu.this, BrandNewGroupActivity.class);
                startActivity(intent30);
            }
        });
    }

    private void configureBrowseToursButton(){
        Button prevTour = (Button) findViewById(R.id.button5);
        prevTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainMenu.this, PreviousTours.class);
                startActivity(intent3);
            }
        });
    }

    private void configureLogOutButton(){
        Button LogOut = (Button) findViewById(R.id.button7);
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
                FirebaseAuth.getInstance().signOut();
                Intent intent11 = new Intent(MainMenu.this, LoginActivity.class);
                startActivity(intent11);
            }
        });
    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                    }
                });
    }

}
