import controller.Controller3D;
import utils.Logger;
import view.Window;

public class Main {
    public static void main(String[] args) {
        Window window = new Window();
        new Controller3D(window);
        Logger.info("Wireframe 3D rendering has been started...");
    }
}
