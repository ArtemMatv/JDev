package annotations;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, ClassNotFoundException, InvocationTargetException {
    }

    //First task
    @TwoIntegerMethod(a = 5, b = 4)
    public static void multiply(int a, int b) { System.out.println(a * b);}

    public static void multiplyFromAnnotation() throws InvocationTargetException, IllegalAccessException {
        for (Method m : Main.class.getDeclaredMethods()){
            if (m.isAnnotationPresent(TwoIntegerMethod.class)) {
                TwoIntegerMethod an = m.getAnnotation(TwoIntegerMethod.class);
                m.invoke(null, an.a(), an.b());
            }
        }
    }
}
