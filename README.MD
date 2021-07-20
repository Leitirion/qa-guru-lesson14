# **Tests for guru.qa lesson #14 with web and api config (local or remote)**

### How to run with terminal commands on macOS:
For ```web config``` wtih ```local.config file``` use command:
```bash
./gradlew clean -Dconf=local test --tests "tests.TestsWithWebConfig"
```
For ```web config``` wtih ```remote.config file``` use command:
```bash
./gradlew clean -Dconf=remote test --tests "tests.TestsWithWebConfig"
```

For ```api config``` using system properties:
```bash
./gradlew clean -Durl=localhost -Dtoken=token2 test --tests "tests.TestsWithApiConfig"
```

For ```api config``` using file:
```bash
./gradlew clean  test --tests "tests.TestsWithApiConfig"
```
