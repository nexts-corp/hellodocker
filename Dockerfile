FROM java:7
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac Main.java
EXPOSE 4949 
CMD ["java", "Main"]
