# Simple App
This will just be the simplest app ever. It will allow to retrieve/store info from/to a database and not much more. I'm just building this to learn the most basic architecture of an app.

To get Simple App to run on a brand new machine in which you've cloned this repo, follow these steps:

Step 1: add this to the ~/.bashrc file:
    export SIMPLE_APP_HOME=/home/jose/simpleApp
    alias simplebuild="bash /home/jose/simpleApp/scripts/compile.sh"
    alias simplestart="java -cp /home/jose/simpleApp/bin com.simpleapp.server.SimpleAppServer"
    alias simpleclientstart="java -cp /home/jose/simpleApp/bin com.simpleapp.client.SimpleAppClient"

Step 2: source the ~/.bashrc file in every terminal that you have opened, or source it just once and then close all terminals you have opened and reopen them again.

Step 3: create these directories:
    $SIMPLE_APP_HOME/bin
    $SIMPLE_APP_HOME/log

Step 4: make sure all scripts in the $SIMPLE_APP_HOME/scripts folder have execution permissions.

Step 5: Compile the app by running
    simplebuild

Step 6: Run the server by executing
    simplestart

Step 7: Run the client by executing
    simpleclientstart

