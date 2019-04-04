mvn clean install
if [ $# -eq 0 ]
  then
    echo "No arguments supplied"
    echo "This is Interactive Shell"
    java -cp target/parking-lot-0.0.1-jar-with-dependencies.jar com.zest.parkinglot.command.InputCode
fi
if [ $# -eq 1 ]
  then
    echo "Please make sure that complete path of input file is provided and not just file name"
    echo "This is File Mode"
    echo Sample Command "./parking_lot.sh src/main/resources/ParkingInput1.txt"
    java -cp target/parking-lot-0.0.1-jar-with-dependencies.jar com.zest.parkinglot.command.InputCode $1
fi

