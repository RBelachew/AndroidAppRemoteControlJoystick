package com.example.even3android.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.even3android.R;
import com.example.even3android.databinding.ActivityMainBinding;
import com.example.even3android.viewmodel.ViewModel;

import java.io.IOException;

//a class which updates the ViewModel about values the user sends (ip/port and throttle/rudder/elevator/aileron).
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ViewModel viewModel=new ViewModel();
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(viewModel);
        activityMainBinding.executePendingBindings();
        //all inputs from client
        final SeekBar rudderBar=(SeekBar)findViewById(R.id.rudderBar);
        final SeekBar throttleBar=(SeekBar)findViewById(R.id.throttleBar);
        final Joystick joystick=(Joystick) findViewById(R.id.inJoystick);
        final EditText ip=(EditText) findViewById(R.id.inIp);
        final EditText port=(EditText) findViewById(R.id.inPort);
        final Button connect=(Button) findViewById(R.id.inConnect);

        //send to ViewModel the rudder value
        rudderBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                viewModel.setRudder(progress);
            }
        });
        //send to ViewModel the throttle value
        throttleBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                viewModel.setThrottle(progress);
            }
        });
        //send to ViewModel the aileron and elevator values
        joystick.setOnMoveListener((angle,length)->{
            double x=length*Math.cos(angle);
            double y=length*Math.sin(angle);
            viewModel.setAileron(x);
            viewModel.setElevator(y);
        },10);

        //send to ViewModel the ip and port values
        connect.setOnClickListener((o)->{
            try {
                viewModel.connectServer(ip.getText().toString(),port.getText().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        //connect to server
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try {
                    boolean valid=viewModel.connectServer(ip.getText().toString(),port.getText().toString());
                    // Displaying Toast message if data is wrong
                    if(!valid){
                        Toast.makeText(getApplicationContext(), "IP or Port is not valid", Toast.LENGTH_LONG).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
