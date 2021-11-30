package core07266;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Select {

    private static Class<?>[] createParam(Object ... args){
        Class<?>[] param = new Class[args.length];

        for (int i = 0; i < args.length; i++) {
            Class<?> temp = args[i].getClass();

            if (temp.equals(Integer.class)){
                temp = int.class;
            } else if (temp.equals(Double.class)){
                temp = double.class;
            } else if (temp.equals(Boolean.class)){
                temp = boolean.class;
            } else if (temp.equals(Float.class)){
                temp = float.class;
            }
            param[i] = temp;
        }
        return param;
    }


    public static <ControllerClass> Object get (Class<ControllerClass> controller,
                                                String method,
                                                Object... params) {
        try {
            ControllerClass cls = controller.getDeclaredConstructor().newInstance();

            Class<?>[] param = createParam(params);

            Method m = cls.getClass().getMethod(method, param);

            return m.invoke(cls, params);
        } catch (IllegalArgumentException | NoSuchMethodException e) {
            System.out.println("Controller::Illegal Argument or No Such Method "
                    + "with " + String.valueOf(params.length) + " Parameters");
        } catch (IllegalAccessException e){
            System.out.println("Controller::Illegal Access");
        } catch (InvocationTargetException e) {
            System.out.println("Controller::Invalid invoke action");
        } catch (InstantiationException e){
            System.out.println("Controller::Failed to create Instance");
        }
        return null;
    }

}
