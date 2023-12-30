package com.Horizon_Adventure_App.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.com.Horizon_Adventure_App.Activity.R;


public class Feedback extends Fragment {

    RatingBar ratings;
    TextView status;
    Button publishBu;
    EditText eText1;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view =inflater.inflate(R.layout.activity_feedback,container,false);

            ratings = view.findViewById(R.id.ratingBar);
            status = view.findViewById(R.id.statusR);
            publishBu = view.findViewById(R.id.publishB);
            eText1 = view.findViewById(R.id.textFeedback);

            ratings.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                    status.setText(String.valueOf(v));

                    //From each star rating, will get a text
                    switch ((int) ratingBar.getRating()) {
                        case 0:
                            status.setText("Very bad");
                            break;
                        case 1:
                            status.setText("bad");
                            break;
                        case 2:
                            status.setText("Need some improvement");
                            break;
                        case 3:
                            status.setText("Good");
                            break;
                        case 4:
                            status.setText("Great");
                            break;
                        case 5:
                            status.setText("Awesome. I love it");
                            break;
                        default:
                            status.setText("");
                    }
                }
            });



            //button message
            publishBu.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (status.getText().toString().isEmpty() || eText1.getText().toString().isEmpty()) {
                        Toast.makeText(getActivity(), "Please fill in feedback text box", Toast.LENGTH_LONG).show();

                    } else {
                        eText1.setText("");
                        status.setText("");
                        ratings.setRating(0);
                        Toast.makeText(getActivity(), "Thank you for sharing your feedback", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            return view;
        }
}
