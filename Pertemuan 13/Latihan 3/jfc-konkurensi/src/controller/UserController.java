package controller;

import model.User;
import view.UserView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private final UserView view;
    private final List<User> users;

    public UserController(UserView view) {
        this.view = view;
        this.users = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            users.add(new User("User" + i, "user" + i + "@example.com"));
        }

        this.view.startButton.addActionListener(e -> startProcess());
    }

    private void startProcess() {
        view.startButton.setEnabled(false);
        view.statusLabel.setText("Proses berjalan...");

        SwingWorker<Void, Integer> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i < users.size(); i++) {
                    Thread.sleep(50);
                    publish((i + 1) * 100 / users.size());
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                if (chunks != null && !chunks.isEmpty()) {
                    int latestProgress = chunks.get(chunks.size() - 1);
                    view.progressBar.setValue(latestProgress);
                }
            }

            @Override
            protected void done() {
                view.startButton.setEnabled(true);
                view.statusLabel.setText("Proses selesai!");
            }
        };

        worker.execute();
    }
}