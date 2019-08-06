## Form2Text
Project to create text files of users from https://github.com/mervecnn/FnssStajForm.

## Building
Building is done using maven
```
mvn clean compile assembly:single
```
The executable jar file can be found in `./target/` directory

## Usage
Make sure database is working before running the program
```
$ java -jar target/form2pdf-1.0-jar-with-dependencies.jar
$ Usage: form2text <tc-no>
```

```
$ java -jar target/form2pdf-1.0-jar-with-dependencies.jar <tc-no>
```
This command will create two files named `personel.md` and `saglik.md` on working directory if the tc no exists in database.