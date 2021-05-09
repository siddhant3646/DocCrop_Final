package com.example.acewithpace2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.applozic.mobicomkit.api.account.register.RegistrationResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.List;

import io.kommunicate.KmConversationBuilder;
import io.kommunicate.Kommunicate;
import io.kommunicate.callbacks.KMLoginHandler;
import io.kommunicate.callbacks.KmCallback;

public class MainActivity5 extends AppCompatActivity {



    Context context = MainActivity5.this;

    public static final String APP_ID = "3cede02c39e345e77f1ef6e3f48abb579";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        Kommunicate.init(context, APP_ID);

        FloatingActionButton fab = findViewById(R.id.floating_action_button);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kommunicate.loginAsVisitor(context, new KMLoginHandler() {
                    @Override
                    public void onSuccess(RegistrationResponse registrationResponse, Context context) {
                        // You can perform operations such as opening the conversation, creating a new conversation or update user details on success
                        Kommunicate.openConversation(context);

                        List<String> botIds = new ArrayList<>();
                        botIds.add("doc-crop-euxdc"); // Add BOT_ID(s) to this list. Go to Manage Bots(https://dashboard.kommunicate.io/bots/manage-bots) -> Copy botID

                        new KmConversationBuilder(context)
                                .setSingleConversation(true) // Pass false if you would like to create new conversation every time user starts a chat. This is true by default which means only one conversation will open for the user every time the user starts a chat.
                                .setConversationTitle("My Title")
                                .setBotIds(botIds) // The conversation will be created with these bot(s)
                                .createConversation(new KmCallback() {
                                    @Override
                                    public void onSuccess(Object message) {
                                        Toast.makeText(context,"SUCCESS",Toast.LENGTH_LONG).show();
                                    }

                                    @Override
                                    public void onFailure(Object error) {
                                        Toast.makeText(context,"FAILURE",Toast.LENGTH_LONG).show();

                                    }
                                });

                    }

                    @Override
                    public void onFailure(RegistrationResponse registrationResponse, Exception exception) {
                        // You can perform actions such as repeating the login call or throw an error message on failure
                    }
                });
            }
        });



        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

}