package com.example.even3android.viewmodel;

import androidx.databinding.BaseObservable;

import com.example.even3android.model.Model;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//a class which holds a field of a Model and sends to model the values it gets from view.
public class ViewModel extends BaseObservable { //related problem?
    private final Model model;

    //constructor
    public ViewModel() {
        model = new Model();
    }
    //send to model the ip and port the client write
    public boolean connectServer(String ip,String port) throws IOException {
        if (isIP(ip)&&isPort(port)){
            model.connect(ip,port);
            return true;
        } else{
            return false;
        }
    }
    //set values of the movement of rudder
    public void setRudder(double rudder) {
        //(OldMax - OldMin)
        double oldRange = 100;
        //(NewMax - NewMin)
        double newRange = 2;
        //(((OldValue - OldMin) * NewRange) / OldRange) + NewMin
        double newRudder = (((rudder - 0) * newRange) / oldRange) + (-1);
        model.addCommand("set /controls/flight/rudder "+newRudder+"\r\n");
    }
    //set values of the movement of throttle
    public void setThrottle(double throttle) {
        //(OldMax - OldMin)
        double oldRange = 100;
        //(NewMax - NewMin)
        double newRange = 1;
        //(((OldValue - OldMin) * NewRange) / OldRange) + NewMin
        double newThrottle = (((throttle - 0) * newRange) / oldRange) + 0;
        model.addCommand("set /controls/engines/current-engine/throttle "+newThrottle+"\r\n");
    }
    //set values of the movement of aileron
    public void setAileron(double aileron) {
        //(OldMax - OldMin)
        double oldRange = 100;
        //(NewMax - NewMin)
        double newRange = 2;
        //(((OldValue - OldMin) * NewRange) / OldRange) + NewMin
        double newAileron = (((aileron - 0) * newRange) / oldRange) + (-1);
        model.addCommand("set /controls/flight/aileron "+newAileron+"\r\n");
    }
    //set values of the movement of elevator
    public void setElevator(double elevator) {
        //(OldMax - OldMin)
        double oldRange = 100;
        //(NewMax - NewMin)
        double newRange = 2;
        //(((OldValue - OldMin) * NewRange) / OldRange) + NewMin
        double newElevator = (((elevator - 0) * newRange) / oldRange) + (-1);
      model.addCommand("set /controls/flight/elevator "+newElevator+"\r\n");
    }
    //check if ip is valid
    public static boolean isIP(final String ip) {
        String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
        return ip.matches(PATTERN);
    }
    //check if port is valid
    public static boolean isPort(String portStr) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(portStr);
        if (isNum.matches() && portStr.length() < 6 && Integer.valueOf(portStr) >= 1
                && Integer.valueOf(portStr) <= 65535) {
            return true;
        }
        return false;
    }

}
