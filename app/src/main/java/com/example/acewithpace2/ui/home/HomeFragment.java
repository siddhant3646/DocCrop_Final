package com.example.acewithpace2.ui.home;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.applozic.mobicomkit.api.account.register.RegistrationResponse;
import com.applozic.mobicommons.commons.core.utils.Utils;
import com.example.acewithpace2.MainActivity5;
import com.example.acewithpace2.R;

import java.util.ArrayList;
import java.util.List;

import io.kommunicate.KmConversationBuilder;
import io.kommunicate.Kommunicate;
import io.kommunicate.callbacks.KMLoginHandler;
import io.kommunicate.callbacks.KmCallback;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    Button Cbot;
    Context context = getContext();

    public static final String APP_ID = "3cede02c39e345e77f1ef6e3f48abb579";



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Kommunicate.init(getContext(), APP_ID);


        View v = inflater.inflate(R.layout.fragment_home ,container,false);

       //Cbot = v.findViewById(R.id.chatbot_button);

        Button btnEnter = (Button) v.findViewById(R.id.button3);

        // Listening to register new account link
        btnEnter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // if play name already exists
                AlertDialog alert = new AlertDialog.Builder(getActivity()).create();
                alert.setCancelable(false);
                alert.setIcon(R.drawable.login_icon);
                alert.setMessage("Choose a Class");
                alert.setButton(Dialog.BUTTON_POSITIVE,"insect",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=getActivity().getPackageManager().getLaunchIntentForPackage("org.tensorflow.lite.examples.detection");
                        startActivity(i);
                    }
                });
                alert.setButton(Dialog.BUTTON_NEGATIVE, "disease", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=getActivity().getPackageManager().getLaunchIntentForPackage("org.awesome.awesome22.awesome33.awesome44");
                        startActivity(i);
                    }
                });
                alert.show();
            }
        });

        return v;



    }


}