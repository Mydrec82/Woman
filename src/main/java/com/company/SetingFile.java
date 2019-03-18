package com.company;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetingFile {
    private File file;

    public SetingFile(){
        String path = System.getProperty("user.home" ) + "/wife";
        File dir = new File(path);
        if(!dir.exists())dir.mkdir();
        file = new File(path + "/date.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        file.setReadable(false);
    }

    public User getUser() throws IOException {
        String name, pass;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        name = reader.readLine().substring(5);
        pass = reader.readLine().substring(5);
        return new User(name, pass);
    }
    public String getData(String key){
        String s = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Pattern pat = Pattern.compile(key + "=");
            while(reader.ready()){
                String a = reader.readLine();
                Matcher matcher = pat.matcher(a);
            if(matcher.find()){
                s =  a.substring(5);
            }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    //key = name, pass, date, days
     public void write(String key, String val){
         try(PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
             writer.write(key+"="+val+ "\n");
         } catch (IOException e) {
             e.printStackTrace();
         }
     }


     public File getFile(){
        return file;
     }

     public void deleteFile(){
        file.delete();
     }
}
