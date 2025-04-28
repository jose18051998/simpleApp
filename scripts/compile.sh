#!/bin/bash

DB_CONN_JAR_PATH="$SIMPLE_APP_HOME/lib/postgresql-42.7.5.jar"
SRC_DIR="$SIMPLE_APP_HOME/src"
BIN_DIR="$SIMPLE_APP_HOME/bin"

cd $SIMPLE_APP_HOME


javac -d "$BIN_DIR" "$SRC_DIR/com/simpleapp/common/"*.java
javac -cp "$BIN_DIR:$DB_CONN_JAR_PATH" -d "$BIN_DIR" "$SRC_DIR/com/simpleapp/server/"*.java
javac -cp "$BIN_DIR" -d "$BIN_DIR" "$SRC_DIR/com/simpleapp/client/"*.java

echo "Compilation completed."
