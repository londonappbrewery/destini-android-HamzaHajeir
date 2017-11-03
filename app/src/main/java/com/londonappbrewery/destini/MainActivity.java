package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mButtonTop;
    Button mButtonBottom;
    TextView mStoryTextView;
    int mStoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState!= null){
            mStoryIndex=savedInstanceState.getInt("storyIndex");
        }else {
            mStoryIndex=1;
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);


        updateStory(mStoryIndex);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStoryIndex==1){
                    mStoryIndex=2;
                } else if (mStoryIndex==2){
                    mStoryIndex=5;
                } else if (mStoryIndex==3){
                    mStoryIndex=2;
                }
            updateStory(mStoryIndex);
            }
        });




        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStoryIndex==1){
                    mStoryIndex=3;
                } else if (mStoryIndex==2){
                    mStoryIndex=6;
                } else if (mStoryIndex==3) {
                    mStoryIndex = 7;
                }
            updateStory(mStoryIndex);

            }
        });


    }

    public void updateStory(int storyIndex){
        switch (storyIndex) {
            case 1 :
                mButtonTop.setText(R.string.T1_Ans1);
                mButtonBottom.setText(R.string.T1_Ans2);
                mStoryTextView.setText(R.string.T1_Story);
                break;
            case 2 :
                mButtonTop.setText(R.string.T3_Ans1);
                mButtonBottom.setText(R.string.T3_Ans2);
                mStoryTextView.setText(R.string.T3_Story);
                break;
            case 3 :
                mButtonTop.setText(R.string.T2_Ans1);
                mButtonBottom.setText(R.string.T2_Ans2);
                mStoryTextView.setText(R.string.T2_Story);
                break;

            case 5 :
                mButtonTop.setVisibility(mStoryTextView.INVISIBLE);
                mButtonBottom.setVisibility(mStoryTextView.INVISIBLE);

                mStoryTextView.setText(R.string.T6_End);
                break;
            case 6 :
                mButtonTop.setVisibility(mStoryTextView.INVISIBLE);
                mButtonBottom.setVisibility(mStoryTextView.INVISIBLE);
                mStoryTextView.setText(R.string.T5_End);
                break;
            case 7 :
                mButtonTop.setVisibility(mStoryTextView.INVISIBLE);
                mButtonBottom.setVisibility(mStoryTextView.INVISIBLE);
                mStoryTextView.setText(R.string.T4_End);
                break;

        }
    }

    public void onSaveInstanceState(Bundle outState){
         super.onSaveInstanceState(outState);
         outState.putInt("storyIndex",mStoryIndex);

    }
}
