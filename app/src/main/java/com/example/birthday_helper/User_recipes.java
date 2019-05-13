package com.example.birthday_helper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class User_recipes extends AppCompatActivity implements User_recipes_customfragment.OnInputListener{
    private static final String TAG = "User_recipes";

    @Override
    public void sendInput(String input) {
        Log.d(TAG, "sendInput: got the input: " + input);

        mInput = input;

        setInputToTextView();
    }
    //widgets
    private Button mOpenDialog;
    public TextView mInputDisplay;

    //vars
    public String mInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_recipes);
        mOpenDialog = findViewById(R.id.open_dialog);
        mInputDisplay = findViewById(R.id.input_display);

        Toolbar toolbar = findViewById(R.id.toolbar_user_recipe);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("User's Recipes");

        mOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: open dialog.");

                User_recipes_customfragment dialog = new User_recipes_customfragment();
                dialog.show(getFragmentManager(),"User_recipes_customfragment");
            }
        });
    }
    private void setInputToTextView(){
        mInputDisplay.setText(mInput);

    }
}
