package com.example.birthday_helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserFragment extends Fragment {

    Button savebutton;
    EditText money_input;
    EditText hour_input;
    View thisLayout;
    private SharedPreferences mpreference;
    private SharedPreferences.Editor editor;
    public static final String Share_pref = "Share_pref";
    public static final String key_count1 = "title ";
    public static final String key_count3 ="displaydate";
    public static final String key_count4 = "displaytime ";
    public static final String key_count5 = "hour ";
    public static final String key_count6 = "money ";
    String text,text2,text3,text4,text5;

    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        thisLayout = inflater.inflate(R.layout.activity_userinfo,container, false);
        savebutton = (Button) thisLayout.findViewById(R.id.save_id);
        money_input = thisLayout.findViewById(R.id.money_inputid);
        hour_input = thisLayout.findViewById(R.id.hour_inputid);

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Question.class);
                ((MainActivity) getActivity()).startActivity(intent);

            }
        });
        return thisLayout;
    }


}
