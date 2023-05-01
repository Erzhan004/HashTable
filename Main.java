import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        MyHashTable<MyTestingClass,String> table = new MyHashTable<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int age = random.nextInt(18,25);
            String firstName = randomString();
            String lastName = randomString();
            MyTestingClass student = new MyTestingClass(firstName,lastName,age);
            table.put(student,firstName);
            table.print();
        }


    }
    private static String randomString(){
        Random random = new Random();
        String characters = "abcdefghijklmnopqrstuvwxyz";
        int lengthOfString = random.nextInt(2,10);
        String string = "";
        for (int i = 0; i < lengthOfString; i++) {
            string += characters.charAt(random.nextInt(0,lengthOfString));
        }
        return string;
    }
    }