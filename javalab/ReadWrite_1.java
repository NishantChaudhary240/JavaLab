package javalab;
import java.io.*;

public class ReadWrite_1 {
    public static void main(String[] args){
        try{
            File f = new File("Dmeofile.txt");
            if(f.createNewFile()){
                System.out.println("File created successfully.");
            }
            else{
                System.out.println("File already exist.");
            }
            
            FileWriter fw = new FileWriter("DemoFile.txt");
            System.out.println("Writing on file.");
            fw.write("Java programming");
            
            fw.close();
            FileReader fr = new FileReader("DemoFile.txt");
            int ch;
            String content = "";
            System.out.println("Reading from file.");
            while((ch = fr.read()) != -1){
                content = content + (char)ch;
            }
            fr.close();
            
            System.out.println("Content of file : " + content);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
}

