# Overview
[Wikidata](https://query.wikidata.org/) is a structured open knowledge base. It contains a live RESTful api which allows you to issue SPARQL queries and receive results in a variety of formats. The aim of this exercise is to produce working java code that allows the following unit test to pass:

---
```
  @Test
  void test_me() {
    assertEquals("54", Question.ask("How old is David Cameron ?"));
    assertEquals("David William Donald Cameron", Question.ask("What is the birth name of David Cameron ?"));
    assertEquals("67", Question.ask("How old is Tony Blair ?"));
    assertEquals("No Result", Question.ask("What is the birth name of Tony Blair ?"));
  }

```

## Pre-requisites for the project
[Install](https://www.oracle.com/uk/java/technologies/javase/javase8u211-later-archive-downloads.html) JDK version 1.8+

[Install](https://gradle.org/install/) Gradle version 6.6

[Install](https://git-scm.com/downloads) Git version 2.24.3

---
## A fresh startup for the project
Go to any directory you'd like to create the project.
```
$ cd <ANY_DIRECTORY>
```
Clone the project from GitHub repository. Project files will be placed under <ANY_DIRECTORY>/sparql
```
$ git clone https://github.com/hakan-bali/sparql.git
```
Proceed to the project directory.
```
$ cd checkout
```
Gradle will download all required dependencies, build the project, and run the project with the command below:
```
$ ./gradlew run
```

---
### Clean build whole project from command line
```
$ ./gradlew clean build
```

---
### Running unit tests from command line
```
$ ./gradlew test
```

---
### Check that it is running
```
$ ./gradlew run
```
