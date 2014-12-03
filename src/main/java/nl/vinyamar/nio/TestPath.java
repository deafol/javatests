package nl.vinyamar.nio;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Milan
 * Date: 7-12-12
 * Time: 16:44
 * To change this template use File | Settings | File Templates.
 */
public class TestPath {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get(System.getProperty("java.io.tmpdir")+ "/" + new Random(4711L));
        System.out.println("String:" + path);

        File filePath = new File(path + "/test.txt");
        System.out.println("File:" + filePath);

        Files.createDirectory(path);
        filePath.createNewFile();


    }
}
