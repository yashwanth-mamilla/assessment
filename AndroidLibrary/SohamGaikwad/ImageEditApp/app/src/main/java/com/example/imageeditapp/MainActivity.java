package com.example.imageeditapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imageeditapp.R;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    Button resize, centrecrop, centreinside, fit,rotate, rotateLeft;
    ImageView iv;
    TextView tvProgressLabel;
    TextView tvProgressLabelSize;
    TextView tvProgressLabelCrop;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resize = findViewById(R.id.resize);
        centrecrop = findViewById(R.id.centrecrop);
        fit = findViewById(R.id.fit);
        rotate = findViewById(R.id.rotate);
        rotateLeft = findViewById(R.id.rotateLeft);
        iv = findViewById(R.id.iv);

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);

        int progress = seekBar.getProgress();
        tvProgressLabel = findViewById(R.id.textView);
        tvProgressLabel.setText("Rotate: " + progress);

        SeekBar seekBarSize = findViewById(R.id.seekBarSize);
        seekBarSize.setOnSeekBarChangeListener(seekBarSizeChangeListener);

        int progressSize = seekBarSize.getProgress();
        tvProgressLabelSize = findViewById(R.id.textViewSize);
        tvProgressLabelSize.setText("Sharpness: " + progressSize);

//        SeekBar seekBarCrop = findViewById(R.id.seekBarCrop);
//        seekBarCrop.setOnSeekBarChangeListener(seekBarCropChangeListener);
//
//        int progressCrop = seekBarCrop.getProgress();
//        tvProgressLabelCrop = findViewById(R.id.textViewCrop);
//        tvProgressLabelCrop.setText("Crop: " + progressCrop);

        getData();
    }

    private void getData() {

        resize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.get()
                        .load(R.drawable.defaultimage)
                        .resize(600, 200)// resizes the image to these dimensions (in pixel). does not respect aspect ratio
                        .into(iv);
                Toast.makeText(MainActivity.this, "Resize called ", Toast.LENGTH_SHORT).show();

            }
        });

        centrecrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.get()
                        .load(R.drawable.defaultimage)
                        .resize(100,100)
                        .centerCrop()
                        .into(iv);
                Toast.makeText(MainActivity.this, "Centrecrop called ", Toast.LENGTH_SHORT).show();
            }
        });

        fit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.

                        get()
                        .load(R.drawable.defaultimage)
                        .fit()
                        .into(iv);
                Toast.makeText(MainActivity.this, "Fit called ", Toast.LENGTH_SHORT).show();
            }
        });

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Picasso.get()

                        .load(R.drawable.defaultimage)

                        .rotate(90f)
                        // .rotate(45f, 220f,100f)

                        .into(iv);
                Toast.makeText(MainActivity.this, "Rotate Called", Toast.LENGTH_SHORT).show();


            }
        });


        rotateLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Picasso.get()

                        .load(R.drawable.defaultimage)

                        .rotate(-90f)

                        .into(iv);
                Toast.makeText(MainActivity.this, "Rotate Called", Toast.LENGTH_SHORT).show();


            }
        });



    }

    SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // updated continuously as the user slides the thumb
            tvProgressLabel.setText("Rotate: " + progress);

            Picasso.get()

                    .load(R.drawable.defaultimage)

                    .rotate(progress, 220f,100f)

                    .into(iv);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }
    };


    SeekBar.OnSeekBarChangeListener seekBarSizeChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBarSize, int progressSize, boolean fromUser) {
            // updated continuously as the user slides the thumb
            tvProgressLabelSize.setText("Sharpness: " + progressSize);

            Picasso.get()

                    .load(R.drawable.defaultimage)

                    .resize(6 * progressSize, 4 * progressSize)

                    .into(iv);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }
    };


    SeekBar.OnSeekBarChangeListener seekBarCropChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBarCrop, int progressCrop, boolean fromUser) {
            // updated continuously as the user slides the thumb
            tvProgressLabelCrop.setText("Crop: " + progressCrop);

            Picasso.get()

                    .load(R.drawable.defaultimage)
                    .resize(6 * progressCrop,4 * progressCrop)
                    .centerCrop()

                    .into(iv);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }
    };
}