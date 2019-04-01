package com.example.birthday_helper;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ChillrelaxFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View thisLayout = inflater.inflate(R.layout.fragment_chillrelax,container, false);
        Button button = (Button) thisLayout.findViewById(R.id.open_chillrelax);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Chillrelax_activity_list.class);
                ((MainActivity) getActivity()).startActivity(intent);
            }
        });
        return thisLayout;
    }
}
