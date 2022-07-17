package homework.fileUtil;

import java.io.*;
import java.util.Scanner;

public class FileUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        fileSearch();
//        contentSearch();
//        findLines();
//        printSizeOfPackage();
        createFileWithContent();

    }

    static void fileSearch() {
        System.out.println("Please input file path");
        String path = scanner.nextLine();
        System.out.println("Please input fileName");
        String fileName = scanner.nextLine();


        File myfile = new File(path, fileName);
        System.out.println(myfile.exists());

    }

    static void contentSearch() throws IOException {
        System.out.println("Please input file path");
        String path = scanner.nextLine();
        System.out.println("Please input keyword");
        String keyword = scanner.nextLine();

        File myfile = new File(path);
        if (myfile.exists() && myfile.isDirectory()) {
            File[] files = myfile.listFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        try (BufferedReader bf = new BufferedReader(new FileReader(file));) {
                            String home;
                            while ((home = bf.readLine()) != null) {
                                if (home.contains(keyword)) {
                                    System.out.println(file);
                                    break;
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }

    }

    static void findLines() throws IOException {
        System.out.println("Please input file path");
        String path = scanner.nextLine();
        System.out.println("Please input keyword");
        String keyword = scanner.nextLine();


        try (BufferedReader inputStream = new BufferedReader(new FileReader(path))) {
            String home;
            int line = 0;
            while ((home = inputStream.readLine()) != null) {
                if (home == "home") {
                    line++;
                }
                if (home.contains(keyword))
                    System.out.println(line + " " + home);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printSizeOfPackage() {
        System.out.println("Please input file path for measure the size");
        String path = scanner.nextLine();

        File myFile = new File(path);
        long number = 0;
        if (myFile.isDirectory())
            for (File file : myFile.listFiles()) {
                number = file.length();
            }
        System.out.println("length " + path + " = " + number / 1024 + "kb");

    }

    static void createFileWithContent() throws IOException {
        System.out.println("Please input path for make  new file");
        String file = scanner.nextLine();
        System.out.println("Please input new file name");
        String filename = scanner.nextLine();
        System.out.println("Please input content the file");
        String content = scanner.nextLine();

        File myfile = new File(file);
        if (!myfile.exists()) {
            myfile.createNewFile();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(content);
            System.out.println("Content created!");


        }
    }
}
