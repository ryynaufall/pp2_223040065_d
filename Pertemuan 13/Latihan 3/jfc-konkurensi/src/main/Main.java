package main;

import controller.UserController;
import view.UserView;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            UserView view = new UserView();
            new UserController(view);
            view.setVisible(true);
        });
    }
}