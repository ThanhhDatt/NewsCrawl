package sqa.demo.newscrawler.Utils.Dantri;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class WriteToFile {
    public static void writeToFile(String path, ArrayList<DantriNews> news) throws IOException {
        try{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            FileWriter myWriter = new FileWriter(path);
            myWriter.write("All news in time: " + dtf.format(now) + "\n \n");
            for(int i=0; i<news.size(); i++){
                myWriter.write("Title: " + news.get(i).getTitle() + "\n");
                myWriter.write("Link: " + news.get(i).getUrl() + "\n");
                myWriter.write("Opening: " + news.get(i).getOpening() + "\n");
                myWriter.write("Content: \n" + news.get(i).getContent() + "\n");
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the text file!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeToAJsonFile(String path, String context){
        try{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(context);
            myWriter.close();
            System.out.println("Successfully wrote to the Json file!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
