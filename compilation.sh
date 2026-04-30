# /bin/bash

rm -f *.class
find * -name "*.java" > sources.txt
javac @sources.txt