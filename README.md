# MineTail
---

### Purpose
This is a plugin for CraftBukkit that "tails" the server log file and daily roll it in another file.

### Installation
To install the plugin, just download [the last version available](https://github.com/downloads/Mithrandir0x/minetail/minetail-0.1.zip "") and unzip it in the `plugin` folder from the minecraft server.

### Usage
The plugin is set by default to save the log files in the folder `logs` at the root of the minecraft server location. If you wish to change the location to another path just modify from `log4j.properties` the property `log4j.appender.File.file` file inside `MineTail` folder:

```
log4j.rootLogger = File
log4j.appender.File = org.apache.log4j.DailyRollingFileAppender
log4j.appender.File.file = ./logs/server.log   #<--- This 
log4j.appender.File.DailyRollingFileAppender.DatePattern = '.'yyyyMMdd
log4j.appender.File.Append = true
log4j.appender.File.layout = org.apache.log4j.PatternLayout
log4j.appender.File.ConversionPattern = %m
```

Please, refer to Log4Java documentation to know more information.

### Acknoledge
It must be said that the `JarLoader` class is based (almost embarrasingly copied) upon `ClassLoadHack` class from package `com.massivecraft.creativegates.zcore.util` used in [MassiveCraft's Core](https://github.com/MassiveCraft/Core "").

### Boring Stuff (a.k.a. License)
This project is under MIT license. Do whatever the heap you want of it. Use it. Copy it. Lash it (no, don't do that).