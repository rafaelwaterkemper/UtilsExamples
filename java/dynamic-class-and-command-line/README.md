PLAYING WITH JAVA COMMAND LINE AND DYAMIC LOADING OF CLASSES
===

Command to compile classes, call javac and specify wich classes you wish compile, separated with blank space.
```
javac Main.java com/test/*.java
```

Command to run java program, calling java binary passing wich class you wish run.
Here we can specify a classpath for our classes using -cp ".:com/teste". We can specify directories ans jars where are our .class files.
```
java -cp ".:com/teste" Main
```

Command to generate a jar manually:
```
jar cf notes.jar com/teste/*.class
```
or, passing "e" option to specify the entrypoint:

```
jar cfe meujar.jar Main Main.class MyClassLoader.class phone/*.class
```
By this way, we shouldn't specify a main class when execute the jar with 'java -jar meujar.jar'

Other things I've explored here are:
======
* Loading a class from another jar dynamically
* Defining my own classLoader to load classes
