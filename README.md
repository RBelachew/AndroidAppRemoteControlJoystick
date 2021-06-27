# Android App Remote Control Joystick
<img src="https://user-images.githubusercontent.com/49268743/123528784-f2457500-d6f2-11eb-9071-981fbf42692c.png">

    About The Application Android

The app is a very simple application, and there is one action that can be performed.\
In the application it will be possible to connect to the IP where the flight simulator is running, and to specify the simulator listening, with a login button.\
The app has two seek bars for the Throttle and Rudder, as well as a virtual joystick that communicates with the simulator,\
the x-axis for the elevators and the y-axis for the ailerons.

    Directory Hierarchy
    
Model:\
        *Model class -.\

View:\
   *views folder:\
-Joystick class\
-VerticalSeekBar class\
-MainActivity class\
   *res/layout folder:\
-activity_main.xml

ViewModel:\
        *ViewModel class

    Installation and Running Instructions

As a client of the app you need to run the android app and to connect the server of FlightGear as mentioned, with IP and Port.

As a developer you need an IDE suitable for running Android Application (I used Android Studio).\
In addition, when you open the flight simulator, you can set the following setting in the Settings Additional tab:
--telnet = socket, in, 10,127.0.0.1,6400, tcp
This setting instructs the flight simulator to open a server over IP / TCP, localhost and port 6400.
The setting in defines that the flight simulator serves as a server side, which will expect to read information from clients that connect to it.
you can download and install with the following link: https://www.flightgear.org/download/ .

    Documentation/UML
    
There is a link to UML charts of the main classes https://lucid.app/lucidchart/8d5ab3a0-95f6-4fae-9831-047a0e0129cd/view?page=0_0#https://lucid.app/lucidchart/8d5ab3a0-95f6-4fae-9831-047a0e0129cd/view?page=0_0%23 .Of course for developers there is also documentation of the code in the code files.

    Video

There is a link to a video where I demonstrate the use of the android application:


