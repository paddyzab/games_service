GiveMeGames service
====
Game feeds, standings service.

Thanks to football-api.com supports:
- Premier League.

Introduction
------------
One part of this API is the limitation of the IP addresses.
To modify (and test it), you should change the settings on the football-api.com in settings.
Probably you should use your own account, to not to override my settings, for that you need to change the apiKey in the
de.gmg.FootballApiClient.class.

License is GNUBL.

Build
------------
mvn clean test install
consider de.gmg.FootballApiClient a test class.
