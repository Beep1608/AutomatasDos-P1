package core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;

public class App extends Application {
    private TextArea textArea;
    private Label messageLabel;

    @Override
    public void start(Stage primaryStage) {
        Button loadButton = new Button("Cargar Archivo");
        loadButton.setOnAction(event -> loadTextFromFile(primaryStage));

        Button compileButton = new Button("Compilar");
        compileButton.setOnAction(event -> compile());

        textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setPrefSize(300, 200);

        messageLabel = new Label("Messages will be displayed here.");

        VBox root = new VBox(10); // Adding spacing between elements
        root.getChildren().addAll(loadButton, compileButton, textArea, messageLabel);
        Scene scene = new Scene(root, 300, 350);
        primaryStage.setTitle("JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadTextFromFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Text File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try {
                String content = new String(Files.readAllBytes(file.toPath()));
                textArea.setText(content);
                messageLabel.setText("Archivo cargado exitosamente");
            } catch (IOException e) {
                messageLabel.setText("Error al cargar el archivo: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void compile() {
        try {
            messageLabel.setText("Compilación iniciada...");
            
            // Crear stream para capturar la salida
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            PrintStream old = System.out;
            System.setOut(ps);
            
            // Proceso de compilación
            String text = textArea.getText();
            ByteArrayInputStream input = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
            ANTLRInputStream antlrInput = new ANTLRInputStream(input);
            sintaxisSimpleLexer lexer = new sintaxisSimpleLexer(antlrInput);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            sintaxisSimpleParser parser = new sintaxisSimpleParser(tokens);
            parser.inicio();
            
            // Restaurar el stream original y mostrar la salida en el Label
            System.out.flush();
            System.setOut(old);
            messageLabel.setText(baos.toString());
            
        } catch (Exception e) {
            messageLabel.setText("Error en la compilación: " + e.getMessage());
            e.printStackTrace(); // Mantener esto para debug en consola
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
