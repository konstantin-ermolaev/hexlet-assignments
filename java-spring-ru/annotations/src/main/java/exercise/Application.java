package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        for (Method method : Address.class.getDeclaredMethods()) {

            // Проверяем, есть ли у метода аннотация @LogExecutionTime
            if (method.isAnnotationPresent(Inspect.class)) {



                try {
                    // Выполняем метод с аннотацией LogExecutionTime
                    method.invoke(address);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                //System.out.println("Method " + method.getName() + " returns a value of type " + method.getReturnType());
                System.out.println(String.format("Method %s returns a value of type %s", method.getName(), method.getReturnType().getSimpleName()));
                //System.out.println(method.getName());
                // System.out.println(method.getReturnType());
            }
        }
    }
}
