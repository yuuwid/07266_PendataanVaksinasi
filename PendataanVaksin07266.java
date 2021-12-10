import core07266.Controller;
import views07266.admin.LoginAdmin07266;
import views07266.admin.RegisterAdmin07266;

public class PendataanVaksin07266 extends Controller {

    public void init() {
        view(LoginAdmin07266.class).setVisible(true);
    }
}
