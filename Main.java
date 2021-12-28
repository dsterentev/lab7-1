import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream oin = null;
        try {
            Scanner sc = new Scanner(System.in);
            File f1 = new File("C:\\lab7\\people.txt");
            f1.createNewFile();
            fos = new FileOutputStream(f1);
            oos = new ObjectOutputStream(fos);
            System.out.println("count");
            int count = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < count; i++){
                People people = new People();
                System.out.println("lastname");
                people.lastname = sc.nextLine();
                System.out.println("name");
                people.name = sc.nextLine();
                System.out.println("sex");
                people.sex = sc.nextLine();
                System.out.println("height");
                people.height = sc.nextInt();
                sc.nextLine();
                oos.writeObject(people);
            }
            fis = new FileInputStream(f1);
            oin = new ObjectInputStream(fis);
            People n = null;
            for (int i = 0; i < count; i++) {
                n = (People) oin.readObject();
                if (n.height>170){
                    System.out.println(n);
                }
            }
        }
        catch (IOException io) {
            io.printStackTrace();
        }
        catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        }
        finally {
            oos.flush();
            oos.close();
            fos.close();
            oin.close();
            fis.close();
        }
    }
}