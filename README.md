# Two-Factor Authentication

Specification: https://tools.ietf.org/html/rfc6238

## How to run

Pakage
```
mvn package
```

Run
```
java -jar <jar_file> <MODES> [OPTIONS]

```

###MODES
-o: Get valid TOPT.

-g: Generate serect.

###OPTIONS
-q: Generate QRCode, can only be used in conjunction with -g mode.


###EXAMPLE:

- Generate shared secret along with QR code

`java -jar 2FA-1.0-SNAPSHOT-jar-with-dependencies.jar -g -q`

- Get current TOTP of a particular secret

`java -jar 2FA-1.0-SNAPSHOT-jar-with-dependencies.jar -o W75TNHWGXQII34GU`


##AUTHENTICATOR APPS

Android
 - [Authy](https://play.google.com/store/apps/details?id=com.authy.authy&hl=en)
 - [Google Authenticator](https://play.google.com/store/apps/details?id=com.google.android.apps.authenticator2&hl=en)

iOS
  - [Authy](https://itunes.apple.com/en/app/authy/id494168017?mt=8)
  - [Google Authenticator](https://itunes.apple.com/vn/app/google-authenticator/id388497605?mt=8)

Window Phone
  - [Authenticator](https://www.microsoft.com/en-us/store/p/authenticator/9wzdncrfj3rj)

BlackBerry
 - [2 Steps Authenticator](https://appworld.blackberry.com/webstore/content/29401059/?lang=en)
 - [Google Authenticator](m.google.com/authenticator)
