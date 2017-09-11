# About

Using Java's default security manager (simple example)

# Run without restriction

This will run the Java application withour using any security manager.

```
java -classpath game-of-thrones\target\game-of-thrones-1.0.0-SNAPSHOT.jar;iron-throne\target\iron-throne-1.0.0-SNAPSHOT.jar ie.version1.bootcamp.securitymanager.gameofthrones.GameOfThrones claim Joffrey
```

# Run with Java's default Security Manager

```
java -Djava.security.manager -classpath game-of-thrones\target\game-of-thrones-1.0.0-SNAPSHOT.jar;iron-throne\target\iron-throne-1.0.0-SNAPSHOT.jar ie.version1.bootcamp.securitymanager.gameofthrones.GameOfThrones claim Eddard
```

# Run with Java's default Security Manager and our own policy file

Combining default policy with our own policy (using equals sign):

```
java -Djava.security.manager -Djava.security.policy=gameofthrones.policy -classpath game-of-thrones\target\game-of-thrones-1.0.0-SNAPSHOT.jar;iron-throne\target\iron-throne-1.0.0-SNAPSHOT.jar ie.version1.bootcamp.securitymanager.gameofthrones.GameOfThrones claim Cersei
```

Replacing default policy with our own policy (using double equals sign):

```
java -Djava.security.manager -Djava.security.policy==gameofthrones.policy -classpath game-of-thrones\target\game-of-thrones-1.0.0-SNAPSHOT.jar;iron-throne\target\iron-throne-1.0.0-SNAPSHOT.jar ie.version1.bootcamp.securitymanager.gameofthrones.GameOfThrones claim Cersei
```

# Create a keystore

```
keytool -keystore signingkeys.jks -genkey -alias georgerr
```

# Export a certificate (public key)

```
keytool -keystore signingkeys.jks -exportcert -alias georgerr -rfc -file georgerr.pem
```

# Create truststore importing a certificate

```
keytool -import -alias georgerr -file georgerr.pem -keystore mytrustore
```

# List contents of keystore

```
keytool -keystore signingkeys.jks -list -v
```

# Sign jar

```
jarsigner -tsa http://sha256timestamp.ws.symantec.com/sha256/timestamp -keystore signingkeys.jks iron-throne\target\iron-throne-1.0.0-SNAPSHOT.jar georgerr
```