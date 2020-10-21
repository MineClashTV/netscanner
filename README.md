# netscanner
Scans your network for all adresses.

## Usage
**JAR built for Java 15, but it isn't required for source**

```java -jar netscanner.jar [--network net][--timeout timeout]```

You can also use shorter arguments ('-n' and '-t')

**Example usage:**

```java -jar netscanner.jar --network 192.168.0 ```

This will scan the network 192.168.0 with the default timeout of 500ms
