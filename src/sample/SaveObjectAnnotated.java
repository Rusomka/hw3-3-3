package sample;

import java.io.*;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class SaveObjectAnnotated<T> {

    public static <T> void saveObj(T ob, String str) throws Exception {
        if (ob != null && str != null) {
            try (var pw = new PrintWriter(str)) {
                Class<?> cls = ob.getClass();
                Field[] fields = cls.getDeclaredFields();
                for (Field f : fields) {
                    if (f.isAnnotationPresent(Save.class)) {
                        f.setAccessible(true);
                        pw.println(f.getName() + ":" + f.get(ob));
                    }
                }
            }
        } else {
            System.out.println("Null object/path");
        }
    }


    public static <T> T deserializationObj(T ob, String str) throws Exception {
        if (ob != null && str != null) {
            Map<String, String> m = getMap(str);
            Class<?> cls = ob.getClass();
            Field[] fields = cls.getDeclaredFields();
            Object obj = cls.getConstructor().newInstance();

            for (Field f : fields) {
                if (m.containsKey(f.getName())) {
                    Field fl = cls.getDeclaredField(f.getName());
                    fl.setAccessible(true);

                    if (fl.getType().equals(String.class))
                        fl.set(obj, m.get(f.getName().toString()));
                    if (fl.getType().equals(int.class))
                        fl.setInt(obj, Integer.parseInt(m.get(f.getName().toString())));
                    if (fl.getType().equals(double.class))
                        fl.setDouble(obj, Double.parseDouble(m.get(f.getName().toString())));
                    if (fl.getType().equals(boolean.class))
                        fl.set(obj, Boolean.parseBoolean(m.get(f.getName().toString())));
                    if (fl.getType().equals(long.class))
                        fl.set(obj, Long.parseLong(m.get(f.getName().toString())));
                    if (fl.getType().equals(char.class))
                        fl.set(obj, m.get(f.getName().toString()).toCharArray()[0]);
                }
            }
            return (T) obj;
        }
        return null;
    }

    private static Map getMap(String str) throws Exception {
        Map<String, String> map = new HashMap<>();
        try (var bf = new BufferedReader(new FileReader(str))) {
            String temp = "";
            for (; (temp = bf.readLine()) != null; ) {
                String[] t = temp.split("[ :]");
                map.put(t[0], t[1]);
            }
        }
        return map;
    }

}
