package core;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class App extends Application {
    private TextArea textArea;
    private TextArea messageArea;
    private TextArea resultArea;
    private TextArea errorArea;
    private String currentDatabase;
    private boolean compilationSuccessful = false;
    private Button executeButton;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    @Override
    public void start(Stage primaryStage) {
        Button compileButton = new Button("Compilar");
        executeButton = new Button("Ejecutar");
        executeButton.setDisable(true);

        textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setPrefSize(300, 200);

        messageArea = new TextArea("Messages will be displayed here.");
        messageArea.setEditable(false);
        messageArea.setWrapText(true);
        messageArea.setPrefSize(300, 150);
        
        resultArea = new TextArea("SQL execution results will be displayed here.");
        resultArea.setEditable(false);
        resultArea.setWrapText(true);
        resultArea.setPrefSize(300, 150);
        
        errorArea = new TextArea("Compilation errors will be displayed here.");
        errorArea.setEditable(false);
        errorArea.setWrapText(true);
        errorArea.setPrefSize(300, 150);

        TabPane tabPane = new TabPane();
        tabPane.setPrefHeight(300);
        
        Tab messagesTab = new Tab("Messages");
        messagesTab.setContent(messageArea);
        messagesTab.setClosable(false);
        
        Tab resultsTab = new Tab("SQL Results");
        resultsTab.setContent(resultArea);
        resultsTab.setClosable(false);
        
        Tab errorsTab = new Tab("Errors");
        errorsTab.setContent(errorArea);
        errorsTab.setClosable(false);
        
        tabPane.getTabs().addAll(messagesTab, resultsTab, errorsTab);

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        root.getChildren().addAll(compileButton, executeButton, textArea, tabPane);
        Scene scene = new Scene(root, 400, 600);
        
        primaryStage.setTitle("JavaFX SQL App");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        compileButton.setOnAction(event -> compile());
        
        executeButton.setOnAction(event -> execute());
    }

    private void compile() {
        try {
            messageArea.setText("Compilación iniciada...");
            errorArea.setText("");
            compilationSuccessful = false;
            executeButton.setDisable(true);
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            PrintStream old = System.out;
            System.setOut(ps);
            
            ByteArrayOutputStream errBaos = new ByteArrayOutputStream();
            PrintStream errPs = new PrintStream(errBaos);
            PrintStream oldErr = System.err;
            System.setErr(errPs);
            
            String text = textArea.getText();
            ByteArrayInputStream input = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
            ANTLRInputStream antlrInput = new ANTLRInputStream(input);
            TLexer lexer = new TLexer(antlrInput);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TParser parser = new TParser(tokens);
            parser.inicio();
            
            System.out.flush();
            System.setOut(old);
            messageArea.setText(baos.toString());
            
            System.err.flush();
            System.setErr(oldErr);
            if (!errBaos.toString().isEmpty()) {
                errorArea.setText(errBaos.toString());
            }
            
            compilationSuccessful = true;
            
            if (errorArea.getText().isEmpty()) {
                executeButton.setDisable(false);
            } else {
                executeButton.setDisable(true);
                compilationSuccessful = false;
            }
            
        } catch (Exception e) {
            messageArea.setText("Error en la compilación");
            errorArea.setText("Error en la compilación: " + e.getMessage() + "\n\n" + getStackTrace(e));
            compilationSuccessful = false;
            executeButton.setDisable(true);
            e.printStackTrace();
        }
    }
    
    private String getStackTrace(Exception e) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);
        ps.close();
        return baos.toString();
    }
    
    private void execute() {
        if (!compilationSuccessful) {
            errorArea.setText("No se puede ejecutar. La compilación no fue exitosa.");
            return;
        }
        
        String sqlCode = messageArea.getText();
        if (sqlCode == null || sqlCode.trim().isEmpty()) {
            resultArea.setText("No SQL code to execute.");
            return;
        }
        
        boolean dbCreated = createDatabase(sqlCode);
        
        if (dbCreated) {
            useDatabase(sqlCode);
        }
    }
    
    private boolean createDatabase(String sqlCode) {
        String dbName = null;
        if (sqlCode.toUpperCase().contains("CREATE DATABASE")) {
            String[] parts = sqlCode.split("\\s+");
            for (int i = 0; i < parts.length - 1; i++) {
                if (parts[i].equalsIgnoreCase("DATABASE")) {
                    dbName = parts[i + 1].replace(";", "").trim();
                    break;
                }
            }
        }
        
        if (dbName == null) {
            resultArea.setText("No valid CREATE DATABASE statement found.");
            return false;
        }
        
        currentDatabase = dbName;
        
        Connection conn = null;
        Statement stmt = null;
        StringBuilder resultText = new StringBuilder();
        boolean success = false;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            resultText.append("Connecting to database server...\n");
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            
            resultText.append("Creating database: " + dbName + "\n");
            stmt = conn.createStatement();
            stmt.executeUpdate("CREATE DATABASE " + dbName);
            
            resultText.append("Database created successfully.\n");
            success = true;
        } catch (SQLException se) {
            resultText.append("SQL Error: ").append(se.getMessage()).append("\n");
            se.printStackTrace();
        } catch (Exception e) {
            resultText.append("Error: ").append(e.getMessage()).append("\n");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            
            resultArea.setText(resultText.toString());
        }
        
        return success;
    }
    
    private void useDatabase(String sqlCode) {
        if (currentDatabase == null || currentDatabase.isEmpty()) {
            resultArea.setText(resultArea.getText() + "\nNo database has been created yet.");
            return;
        }
        
        if (sqlCode.toUpperCase().contains("CREATE DATABASE")) {
            int endIndex = sqlCode.indexOf(';') + 1;
            if (endIndex > 0 && endIndex < sqlCode.length()) {
                sqlCode = sqlCode.substring(endIndex).trim();
            } else {
                sqlCode = "";
            }
        }
        
        if (sqlCode.trim().isEmpty()) {
            resultArea.setText(resultArea.getText() + "\nNo additional SQL statements to execute.");
            return;
        }
        
        Connection conn = null;
        Statement stmt = null;
        StringBuilder resultText = new StringBuilder(resultArea.getText());
        resultText.append("\n\n");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            resultText.append("Connecting to database: " + currentDatabase + "\n");
            conn = DriverManager.getConnection(JDBC_URL + currentDatabase, USERNAME, PASSWORD);
            
            resultText.append("Executing SQL statements on database: " + currentDatabase + "\n");
            stmt = conn.createStatement();
            
            String[] statements = sqlCode.split(";");
            for (String statement : statements) {
                statement = statement.trim();
                if (!statement.isEmpty()) {
                    resultText.append("Executing: " + statement + "\n");
                    stmt.execute(statement);
                }
            }
            
            resultText.append("All SQL statements executed successfully.");
        } catch (SQLException se) {
            resultText.append("SQL Error: ").append(se.getMessage()).append("\n");
            se.printStackTrace();
        } catch (Exception e) {
            resultText.append("Error: ").append(e.getMessage()).append("\n");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            
            resultArea.setText(resultText.toString());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
