
### How to run with terminal commands
For web config
```bash
gradle clean -Dconf=local test --tests "tests.WebConfigTests"
```
or
```bash
gradle clean -Dconf=remote test --tests "tests.WebConfigTests"
```

For api config using system properties
```bash
gradlew clean -Dbase.url=localhost -Dtoken=token23 test --tests "tests.ApiConfigTests"
```

For api config using file
```bash
gradlew clean  test --tests "tests.ApiConfigTests"
```
