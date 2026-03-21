package FX_AMB;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class abmApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(abmApplication.class.getResource("abm-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 440);
        stage.setTitle("ABM-personas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}