# springboot-containerized

1. add `<finalName>jar-filname</finalName>` to pom.xml under `<build></build>` tag.
2. Create package aka build_jar of application using maven command. Which will build a jar with the given filename inside `target/`.
3. pull a specific image from docker hub of cmd using `docker pull image_name:tag`. Here I used `openjdk:25-jdk`.
4. create a container instance from the image using `docker run openjdk:25-jdk` or `docker exec openjdk:25-jdk` 
5. Now try running your java application using `java -jar target/jar-filname.jar`.
6. `docker run -dit openjdk:25-jdk` run this image to create a container where `-dit` means detached interactive mode.
7. `docker exec container_name ls -a` running this will execute the created container and list all the folders inside it.
8. Now copy the jar file and place it inside the `/tmp` folder using `docker cp target/jar-filname.jar container_name:/tmp`.
9. `docker commit container_name image-name:version` will create a new image of your application.
10. Now if you try executing the image it will still open the jshell because it is by default.
11. To change that you need to execute `docker commit --change='CMD ["java", "-jar", "/tmp/jar-filname.jar"]' container_name image-name:version`, which edits the default execution command in docker.
12. Since your application is containerized, you are all set to run this using `docker run -p 8082:8082 image-name:version` on the specified port.