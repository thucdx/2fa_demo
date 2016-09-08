Two-Factor Authentication demo

How to run
-------------

```
mvn package
```


```
java -jar <jar_file> <MODES> [OPTIONS]

```
###MODES
-o: Get valid TOPT.

-g: Generate serect.

###OPTIONS
-q: Generate QRCode, can only be used in conjunction with -g mode.


###EXAMPLE:
`java -jar 2FA-1.0-SNAPSHOT-jar-with-dependencies.jar -g -q`

```


