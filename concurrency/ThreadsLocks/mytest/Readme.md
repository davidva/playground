```
mvn archetype:create -DgroupId=com.davidva -DartifactId=mytest
```

```
mvn package
java -cp target/mytest-1.0-SNAPSHOT.jar com.davidva.App
```