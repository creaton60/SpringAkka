# Springboot with akka project

 This Project is for practice using spring-boot with akka

## Usage
### Gradle

```
sourceCompatibility = 1.8

repositories {
	mavenCentral()
	maven {
    url "http://repo.akka.io/snapshots/"
  }
}

dependencies {
	compile('org.springframework.boot:spring-boot-starter')
	testCompile('org.springframework.boot:spring-boot-starter-test')
	compile group: 'com.typesafe.akka', name: 'akka-actor_2.11', version: '2.5.0'
    compile group: 'org.scala-lang', name: 'scala-library', version: '2.11.8'
}
```

## Built With

* [Gradle](https://gradle.org/) - Dependency Management

## Authors

* **Creaton 60(Reactor)**

## License

Copyright (c) 2017 "reactor" dongkyu lee Licensed under the MIT license.
