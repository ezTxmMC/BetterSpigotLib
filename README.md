# BetterSpigotLib

The library to improve and speed up your minecraft plugin coding.

## Examples

### BetterScoreboard

Create the scoreboard with the constructor.

```java
BetterScoreboard scoreboard = new BetterScoreboard(player, scoreboardId, displayName);
```

Set lines with the `setLine` method. Be careful to order downwards!

```java
scoreboard.setLine(line, content, updatable);
```

Update updatable lines with the `updateLine` method.

```java
scoreboard.updateLine(line, newContent);
```

### BetterScheduler

Create the scheduler with the constructor.

```java
BetterScheduler scheduler = new BetterScheduler(plugin);
```

Start a synchronized timer.

```java
scheduler.runTimer(runnable, delay, period);
```

Start a asynchronized timer.

```java
scheduler.runTimerAsync(runnable, delay, period);
```

Start a synchronized do, to do something later.

```java
scheduler.runLater(runnable, delay, period);
```

Start a asynchronized do, to do something later.

```java
scheduler.runLaterAsync(runnable, delay, period);
```

Cancel the current task.

```java
scheduler.cancelTask();
```

### Dependency

Latest Release:

```xml
<repositories>
   <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
   </repository>
</repositories>

<dependency>
   <groupId>com.github.MoonWriters</groupId>
   <artifactId>BetterSpigotLib</artifactId>
   <version>0.2.0</version>
</dependency>
```

Latest Snapshot:

```xml
<repositories>
   <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
   </repository>
</repositories>

<dependency>
   <groupId>com.github.MoonWriters</groupId>
   <artifactId>BetterSpigotLib</artifactId>
   <version>v3.0-SNAPSHOT</version>
</dependency>
```
