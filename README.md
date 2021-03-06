# Android App Remote Control Joystick
<img src="https://user-images.githubusercontent.com/49268743/123528784-f2457500-d6f2-11eb-9071-981fbf42692c.png">

    About The Application Android

The app is a very simple application, and there is one action that can be performed.\
In the application it will be possible to connect to the IP where the flight simulator is running, and to specify the simulator listening, with a login button.\
The app has two seek bars for the throttle (the vertical one) and rudder (the horizontal one), as well as a virtual joystick that communicates with the simulator,\
the x-axis for the elevators and the y-axis for the ailerons.

    Directory Hierarchy
    
Model:\
        *Model class- a class which connects to the flight simulator (the FlightGear app) with ip/port and sends commands of movement it gets from ViewModel.

View:\
   *views folder:\
-Joystick class- a class which determines all components that joystick needs.\
-VerticalSeekBar class- a class which declares custom of vertical seek bar (for the throttle).\
-MainActivity class- a class which updates the ViewModel about values the user sends (ip/port and throttle/rudder/elevator/aileron).

ViewModel:\
        *ViewModel class- a class which holds a field of a Model and sends to model the values it gets from view.

    Installation and Running Instructions

As a client of the app you need to run the android app and to connect the server of FlightGear as mentioned, with IP and Port.

As a developer you need an IDE suitable for running Android Application (I used Android Studio).\
In addition, you need to download and install the FlightGear application with the following link: https://www.flightgear.org/download/ .\
When you open the flight simulator, you can set the following setting in the Settings Additional tab:\
--telnet = socket, in, 10,127.0.0.1,6400, tcp\
This setting instructs the flight simulator to open a server over IP / TCP, localhost and port 6400.\
The setting in defines that the flight simulator serves as a server side, which will expect to read information from clients that connect to it.

    Documentation/UML
    
There is a link to UML charts of the main classes https://lucid.app/documents/view/36b91a42-ddf2-4d6d-8af7-557503366d29 .Of course for developers there is also documentation of the code in the code files.

    Video

There is a link to a video where I demonstrate the use of the android application: https://drive.google.com/file/d/1NajSb5NwlHkhuQtlIjRQGBfBiL5vWpXB/view?usp=sharing .\
*Note: In the video it is said that in class MainActivity there is a field of ViewModel but in fact, MainActivity has no fields at all but it defines a ViewModel variable within an onCreate function through which it passes the data from user to ViewModel.


