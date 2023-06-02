package com.example.aquariumrestaurant.ChefMeals;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.aquariumrestaurant.R;
public class ChefProfileFragment extends Fragment {

    Button post;
    ConstraintLayout bgimage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chef_profile, container, false);
        getActivity().setTitle("Post Dish");
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image1), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image2), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image3), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image4), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image5), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image6), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image7), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image8), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image9), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image10), 3000);




        animationDrawable.setOneShot(false);
        animationDrawable.setEnterFadeDuration(850);
        animationDrawable.setExitFadeDuration(1600);
        bgimage = v.findViewById(R.id.back1);
        bgimage.setBackgroundDrawable(animationDrawable);
        animationDrawable.start();

        post = (Button) v.findViewById(R.id.post_dish);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ChefPostDish.class));
            }
        });

        return v;
    }
}