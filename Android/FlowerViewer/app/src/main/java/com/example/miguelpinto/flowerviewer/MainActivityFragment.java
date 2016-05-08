package com.example.miguelpinto.flowerviewer;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivityFragment extends Fragment {

    private Integer[] flowers = new Integer[]{R.drawable.bouquet, R.drawable.pinkflower, R.drawable.purpleflower, R.drawable.randomflowers, R.drawable.redflower};
    private int x = 0;
    private Button prev, next;
    private ImageView imgVw;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        imgVw = (ImageView) rootView.findViewById(R.id.imgVw);
        prev = (Button) rootView.findViewById(R.id.prev_btn);
        next = (Button) rootView.findViewById(R.id.next_btn);

        prev.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("MainActivityFragment", "The previous button was clicked.");
                        Toast prevToast = Toast.makeText(getActivity().getApplicationContext(),"Previous", Toast.LENGTH_SHORT);
                        prevToast.show();
                        x--;
                        if (x < 0) {x = flowers.length - 1;}
                        imgVw.setImageResource(flowers[x]);
                    }
                }
        );

        next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("MainActivityFragment", "The next button was clicked.");
                        Toast nextToast = Toast.makeText(getActivity().getApplicationContext(),"Next", Toast.LENGTH_SHORT);
                        nextToast.show();
                        x++;
                        if (x > (flowers.length - 1)) {x = 0;}
                        imgVw.setImageResource(flowers[x]);
                    }
                }
        );

        return rootView;
    }
}