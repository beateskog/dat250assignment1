# dat250assignment1

[Link to Docker Repository](https://hub.docker.com/r/beateskogvik/dat250/tags)

### Installation 

- went well, did not have any problems. Had most of the installations from before.

**Step 1:**

- No problems making the git repository.

**Step 2:**

- I did not have any problems setting up gradle 

**Step 3:**

- 30 feet equals 9.144 meters

- I got rid of the Javalin message by adding the sl4j-simple dependency to the build.gradle.kts file. Because it was suggested after the message prompt: "The easiest way to fix this is to add 'slf4j-simple'"

**Step 4:** 

- running ./gradlew check when a test fails results in a build fail because Compilation failed. Give no more information than that

**Step 5:**

- I did not have any problems building the image, and pushing it to docker hub.

- running podman images gave me the following output: 

```REPOSITORY                         TAG            IMAGE ID      CREATED         SIZE
localhost/unit-converter           latest         ef901a26ab1e  12 minutes ago  1.26 GB
docker.io/library/eclipse-temurin  11.0.20_8-jdk  3a7589aee7eb  8 days ago      384 MB
```

- The second image is recognized from my Dockerfile, in the first line `FROM eclipse-temurin:11.0.20_8-jdk`

### Problems 

- Needed to add the javalin dependency in the build.gradle.kts file.

- I did not remove the package name when copying the App-file so did not get that problem 

- My tests failed in the beginning because of rounding errors, so i added a delta to the assertEquals.

- To read the test errors i had to run ./gradlew check --info, to get information of what test failed, and why. 
