# vanilla-tables

Makes the game data tables that
[Collider](https://github.com/Nozistance/collider) reads, from the
official vanilla server jar. Needs Java 25.

```sh
# download the server jar from Mojang, write the tables into data/
java -jar vanilla-tables.jar generate

# use a server jar you already have
java -jar vanilla-tables.jar generate --jar server.jar

# write the tables next to the server
java -jar vanilla-tables.jar generate --out /srv/collider/data

# tell if data/ holds a full set of tables
java -jar vanilla-tables.jar check data
```

## Build from source

Needs Java 25 and the [Clojure CLI](https://clojure.org/guides/install_clojure).

```sh
clojure -T:build uber   # gives target/vanilla-tables.jar
```
