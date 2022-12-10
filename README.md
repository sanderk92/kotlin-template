# Kotlin template

A template for Kotlin applications. To get started, update the following:

1. Replace occurrences of `project` with your `project-name`:
   - `./settings.gradle.kts`
   - `./build.gradle.kts`
   - `./integration-test/src/`
   - `./core/src/`

## Test suite

To run the whole test suite:
```shell
./gradlew test
```

To run the unit tests exclusively:
```shell
./gradlew :core:test
```

To run the integration tests exclusively:
```shell
./gradlew :integration-test:test
```

## Development

To see which tasks are available, run:
```shell
./gradlew tasks
```

To start the application, run:
```shell
./gradlew :core:bootRun
```

To start the dependencies for a local environment, run:
```shell
docker compose up
```
