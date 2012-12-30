a dummy repo for the Java-Websocket maven dependency
see http://stackoverflow.com/questions/2229757/maven-add-a-dependency-to-a-jar-by-relative-path/2230464#2230464

for installing a newer version:
* get sources from https://github.com/TooTallNate/Java-WebSocket
* compile
* change -Dfile=... in the command below to the path to the jar, relative from this project's root
* execute command from this project's root:

mvn org.apache.maven.plugins:maven-install-plugin:2.3.1:install-file \
-Dfile=../Java-WebSocket/target/Java-WebSocket-1.0.0-SNAPSHOT.jar \
-DgroupId=org.java_websocket -DartifactId=Java-WebSocket \
-Dversion=1.0.0-SNAPSHOT \
-Dpackaging=jar -DcreateChecksum=true \
-DlocalRepositoryPath=dummy-repo