Spoor Java Client
=================

This library supports making calls to the Spoor platform from jvm based languages. This library requires jdk 1.8 or above.

Basic Usage
-----------

Ensure you build is fetching dependencies from the FTs nexus repo. Eg

```
<repository>
    <id>ft-nexus-releases</id>
    <name>FT Nexus Releases</name>
    <url>http://anthill.svc.ft.com:8081/nexus/content/groups/public</url>
</repository>
```

Include dependency, eg:

```
<dependency>
    <groupId>com.ft.membership.spoorclient</groupId>
    <artifactId>spoor-client</artifactId>
    <version>0.xxx.0</version>
</dependency>
```

Create spoor parameters using the builder:

```java
DefaultSpoorParameters parameters = new DefaultSpoorParametersBuilder("xxxx", "https://myapp.ft.com", "my-product")
    .pageView()
    .build();
```

Create the spoor client:

```java
SpoorClient spoorClient = new SpoorClient(
    new AsyncHttpClient(),
    "https://spoor-api.ft.com",
    Executors.newCachedThreadPool()
);
```

Make the call to the spoor api:

```java
spoorClient.postTracking(parameters);
```

Sending custom parameters to the spoor api
------------------------------------------

If your application needs to send non-standard fields to the spoor api, you need to extend the spoor client lib.

For example you can add a custom field to the spoor context as follows:

Extend the spoor context class, see:

[examples/src/main/java/com/ft/membership/spoorclient/examples/customparameters/CustomContext.java](examples/src/main/java/com/ft/membership/spoorclient/examples/customparameters/CustomContext.java)

Extend [SpoorParameters](client/src/main/java/com/ft/membership/spoorclient/SpoorParameters.java) specifying the extended SpoorContext class

See [examples/src/main/java/com/ft/membership/spoorclient/examples/customparameters/CustomParameters.java](examples/src/main/java/com/ft/membership/spoorclient/examples/customparameters/CustomParameters.java)

Extend the [SpoorParametersBuilder](client/src/main/java/com/ft/membership/spoorclient/SpoorParametersBuilder.java) adding any methods needed to populate the new additional fields.

See [examples/src/main/java/com/ft/membership/spoorclient/examples/customparameters/CustomBuilder.java](examples/src/main/java/com/ft/membership/spoorclient/examples/customparameters/CustomBuilder.java)

You can then send requests with your additional parameters:

```
CustomParameters parameters = new CustomBuilder("xxxx", "https://myapp.ft.com", "my-product")
        .withCustomParameter("my custom parameter")
        .pageView()
        .build();

SpoorClient spoorClient = new SpoorClient(new AsyncHttpClient(), "https://spoor-api.ft.com", Executors.newCachedThreadPool());

spoorClient.postTracking(parameters);
```

Contributing
------------

You can build and release new versions of the spoor java client by manually triggering the jenkins build, see:

http://ftjen03760-lviw-uk-p:8181/job/Spoor%20Java%20Client/

