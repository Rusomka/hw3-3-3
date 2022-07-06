package sample;


public class Main {
    public static void main(String[] args) throws Exception {
        Cat cat = new Cat("Vasks", "Red", 6, 3.5);
        TestClass ts = new TestClass('@', "Test", true, 10);
        try {

            SaveObjectAnnotated.saveObj(cat, "D:\\temp\\cat.txt");
            Cat cat1 = SaveObjectAnnotated.deserializationObj(cat, "D:\\temp\\cat.txt");
            System.out.println(cat1);

            System.out.println("**********");

            SaveObjectAnnotated.saveObj(ts, "D:\\temp\\ts.txt");
            TestClass ts1 = SaveObjectAnnotated.deserializationObj(ts, "D:\\temp\\ts.txt");
            System.out.println(ts1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}


