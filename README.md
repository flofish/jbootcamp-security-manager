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

```
java -Djava.security.manager -Djava.security.policy=gameofthrones.policy -classpath game-of-thrones\target\game-of-thrones-1.0.0-SNAPSHOT.jar;iron-throne\target\iron-throne-1.0.0-SNAPSHOT.jar ie.version1.bootcamp.securitymanager.gameofthrones.GameOfThrones claim Cersei
```