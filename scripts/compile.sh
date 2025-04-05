#!/bin/bash

cd $SIMPLE_APP_HOME

javac -d bin src/com/simpleapp/common/SimpleAppInterface.java
javac -cp bin src/com/simpleapp/server/SimpleAppServer.java
javac -cp bin src/com/simpleapp/client/SimpleAppClient.java

echo "Compilation completed."
