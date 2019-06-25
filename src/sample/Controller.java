package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.ResourceBundle;

public class Controller extends Encryptor implements Initializable {

    @FXML
    private Button btCrypt;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button btDecrypt;

    @FXML
    private TextArea textField;

    @FXML
    void startCrypt(ActionEvent event) {
        textField.setText(encrypt(datePicker.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
    }

    @FXML
    void startDecrypt(ActionEvent event) {
        try {
            datePicker.setValue(LocalDate.parse(decrypt(textField.getText()), DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: 4");
            //count = String.valueOf(Integer.parseInt(Controller.count) - 1);
        }
        textField.setText(decrypt(textField.getText()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        datePicker.setValue(LocalDate.now());
        textField.setWrapText(true);
    }

//    public void serData() throws Exception{
//
//        FileOutputStream fileOut = new FileOutputStream(new File("src/ser.txt"));
//        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
//
//        objOut.close();
//
//        System.out.println("data saved");
//    }
//
//    public void deSerData() throws Exception {
//
//        FileInputStream fileIn = new FileInputStream(new File("src/ser.txt"));
//        ObjectInputStream objIn = new ObjectInputStream(fileIn);
//
//        objIn.close();
//
//        System.out.println("data restore");
//    }
//
//    public static String encryptString(String dataToEncrypt) {
//        String encryptedData = Base64.getEncoder().encodeToString(dataToEncrypt.getBytes());
//        System.out.println(encryptedData);
//        return encryptedData;
//    }
//
//    public static Object decryptString(Object dataToDecrypt) {
//        String decrypted = new String(Base64.getDecoder().decode((byte[]) dataToDecrypt));
//        System.out.println(decrypted);
//        return decrypted;
//    }

}
