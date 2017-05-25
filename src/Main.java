import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        task1();
        task1a();
        task11();
    }

    private void task1a() {
        try {
            String fileName="/home/user/IdeaProjects/collections2205/src/file.txt";
            List<String> collect = Files.newBufferedReader(Paths.get(fileName))
                    .lines().collect(toList());
            Collections.reverse(collect);
            FileWriter writer = new FileWriter(fileName, true);
            for (int i = collect.size()-1; i>=0; i--) {
                writer.write("\n"+collect.get(i));
                writer.flush();
                System.out.println(collect.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void task11() {
        HashMap<Integer,Double> mn1 = new HashMap<>();
        HashMap<Integer,Double> mn2 = new HashMap<>();
        HashMap<Integer,Double> rez = new HashMap<>();
        mn1.put(0,1.);
        mn1.put(1,3.);
        mn1.put(2,5.);

        mn2.put(0,2.);
        mn2.put(1,6.);
        mn2.put(2,1.);
        mn2.put(3,4.);
        mn2.put(4,4.);

        int size = mn1.size()>mn2.size() ? mn1.size() : mn2.size();

        for (int i = 0; i < size; i++) {
            if (check(mn1,i)) mn1.put(i,0.);
            if (check(mn2,i)) mn2.put(i,0.);

            rez.put(i,mn1.get(i)+mn2.get(i));

            System.out.print(rez.get(i)+"x^"+i+"+");
        }
    }

    private boolean check(HashMap<Integer, Double> mn, int i) {
        if(mn.get(i)==null)
            return true;
        return false;
    }


    private void task1() {
        File file = new File("/home/user/IdeaProjects/collections2205/src/file.txt");
        try{
            FileInputStream fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            List<String> lines = new ArrayList();
            while ((strLine = br.readLine()) != null){
                lines.add(strLine);
            }
            FileWriter writer = new FileWriter(file, true);
            for (int i = lines.size()-1; i>=0; i--) {
                writer.write("\n"+lines.get(i));
                writer.flush();
                System.out.println(lines.get(i));
            }
        }catch (IOException e){
            System.out.println("Ошибка чтения файла");
        }
    }


}
