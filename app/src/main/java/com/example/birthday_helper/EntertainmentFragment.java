package com.example.birthday_helper;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class EntertainmentFragment extends Fragment {
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View thisLayout = inflater.inflate(R.layout.fragment_entertainment,container, false);
    Button button = (Button) thisLayout.findViewById(R.id.open_map);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getActivity(),Entertainment_map.class);
        ((MainActivity) getActivity()).startActivity(intent);
      }
    });
    return thisLayout;
  }
}