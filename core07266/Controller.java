package core07266;

import javax.swing.*;

public abstract class Controller {

    private <AbstractClass> AbstractClass abs(Class<AbstractClass> absClass){
        try {
            return absClass.getDeclaredConstructor().newInstance();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    protected <ModelClass> ModelClass model(Class<ModelClass> model) {
        return abs(model);
    }

    protected <ViewClass> ViewClass view(Class<ViewClass> view) {
        return abs(view);
    }

    protected <ControllerClass> ControllerClass cotrol(Class<ControllerClass> controller) {
        return abs(controller);
    }
}
