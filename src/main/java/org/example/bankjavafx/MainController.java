package org.example.bankjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField idField;

    @FXML
    private Button selectAccountButton;

    @FXML
    private Label balanceLabel;

    @FXML
    private TextField amountField;

    @FXML
    private Button withdrawButton;

    @FXML
    private Button depositButton;

    private Account currentAccount;

    @FXML
    public void initialize() {
        // Инициализация счетов
        new Account(1, 10000);
        new Account(2, 10000);
        new Account(3, 10000);
        new Account(4, 10000);
        new Account(5, 10000);
        new Account(6, 10000);
        new Account(7, 10000);
        new Account(8, 10000);
        new Account(9, 10000);
        new Account(10, 10000);

        Account account = new Account(1155, 300000);
        account.setAnnualInterestRate(650);
        account.withdraw(16500);
        account.deposit(50000);

        // Начальное состояние
        balanceLabel.setText("Баланс: ");
        withdrawButton.setDisable(true);
        depositButton.setDisable(true);
    }

    @FXML
    private void selectAccount() {
        try {
            int id = Integer.parseInt(idField.getText());
            currentAccount = Account.findAccountById(Account.getAccounts(), id);
            balanceLabel.setText("Баланс: " + currentAccount.getBalance());
            withdrawButton.setDisable(false);
            depositButton.setDisable(false);
        } catch (NumberFormatException e) {
            showAlert("Ошибка", "Введите корректный ID!");
        } catch (IllegalArgumentException e) {
            showAlert("Ошибка", e.getMessage());
        }
    }

    @FXML
    private void withdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            currentAccount.withdraw(amount);
            balanceLabel.setText("Баланс: " + currentAccount.getBalance());
        } catch (NumberFormatException e) {
            showAlert("Ошибка", "Введите корректную сумму!");
        }
    }

    @FXML
    private void deposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            currentAccount.deposit(amount);
            balanceLabel.setText("Баланс: " + currentAccount.getBalance());
        } catch (NumberFormatException e) {
            showAlert("Ошибка", "Введите корректную сумму!");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}