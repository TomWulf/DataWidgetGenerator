
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

    public class ClassReflector
    {
        public static void main(String[] args) {
            // Specify the path to the Java file
            String filePath = "src/Person.java";

            // Read and print the contents of the Java file
            readJavaFile(filePath);

            // Reflect the structure of the class
            reflectClassStructure("Person");
        }

        private static void readJavaFile(String filePath) {
            try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void reflectClassStructure(String className) {
            try {
                // Load the class
                Class<?> clazz = Class.forName(className);

                // Print class name
                System.out.println("Class: " + clazz.getName());

                // Print constructors
                Constructor<?>[] constructors = clazz.getDeclaredConstructors();
                for (Constructor<?> constructor : constructors) {
                    System.out.println("Constructor: " + constructor);
                }

                // Print fields
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    System.out.println("Field: " + field);
                }

                // Print methods
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    System.out.println("Method: " + method);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
