# Kotlin template

A template for Kotlin applications. To get started, update the following:

1. Replace occurrences of `project` with your `project-name` in the following files/folder
   - The source code containing folder
   - README.md
   - settings.gradle.kts

2. Change the group name in `build.gradle.kts`

## Test suite

To run the whole test suite:
```shell
./gradlew test
```

To run the unit tests exclusively:
```shell
./gradlew :project:test 
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
./gradlew :project:bootRun
```

To start the dependencies for a local environment, run: 
```shell
docker compose up
```
