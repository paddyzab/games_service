GiveMeGames service
====
Game feeds, standings service.

Thanks to football-api.com supports:
- Premier League.

Introduction
------------
One not really awesome part of this API is the limitation of the IP addresses.
To modify (and test it), you should change the settings on the football-api.com in settings on the account we're using.
Probably you should use your own account to not to override mine settings.

We will soon deploy it on server, so the IPs problem will be less visible.

You can run the app, and test spark routes locally by using this address http://localhost:4567/.

Supported services/paths:
- http://localhost:4567/hello
Welcome page.

- http://localhost:4567/competitions
List of supported competitions, for now because it's test account, we can support only Premier League.

- http://localhost:4567/fixture/1204/04.05.2014
1204 is the name of the competition - in that case it's Premier League.
Date formatted as DD.MM.YYYY, keep in mind that not every day of a week games are happening,
use http://www.premierleague.com/en-gb/matchday/league-table.html as a reference.

- http://localhost:4567/standings/1204
Standings are the current standings of competition.

License is GNUBL.

Build
------------
mvn clean test install
