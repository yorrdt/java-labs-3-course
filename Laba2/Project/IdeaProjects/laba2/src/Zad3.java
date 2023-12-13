import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zad3 {
    public static void main(String[] args) throws IOException {

        ArrayList<String> filesData = new ArrayList<String>();

        Scanner in = new Scanner(System.in);
        System.out.print("Input directory name: ");
        String dirName = in.nextLine();

        File directory = new File(dirName);
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                System.out.println("filename: " + file.getName());

                Scanner readFile = new Scanner(file);
                while (readFile.hasNextLine()) {
                    String data = readFile.nextLine();
                    filesData.add(data);
                }
            }
        }

        final String fileName = "dir/endFile.txt";
        FileWriter writter = new FileWriter(fileName);
        for (String fileData : filesData) {
            writter.write(fileData + "\n");
        }
        writter.close();

        ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("dir/endFile.zip"));
        FileInputStream fis = new FileInputStream(fileName);
        ZipEntry entry1 = new ZipEntry(fileName);
        zout.putNextEntry(entry1);
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        zout.write(buffer);
        zout.closeEntry();


        in.close();
    }
}
