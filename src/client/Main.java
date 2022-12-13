package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    Chat chatSystem;

    public Main() {

        chatSystem = new Chat();

        setSize(500, 500);
        setLocation(100, 100);

        this.setTitle("client");
        this.setLayout(null);

        JPanel connectPanel = new JPanel();

        connectPanel.setBounds(0,0,500,120);
        connectPanel.setLayout(null);

        JTextField hostField = new JTextField();
        JTextField portField = new JTextField();
        JButton connectButton = new JButton("Connect");

        hostField.setBounds(10, 40, 200, 20);
        portField.setBounds(10, 70, 200, 20);
        connectButton.setBounds(220, 10, 100, 100);

        connectPanel.add(hostField);
        connectPanel.add(portField);
        connectPanel.add(connectButton);

        this.add(connectPanel);


        JPanel chatList = new JPanel();
        JPanel userList = new JPanel();

        chatList.setBounds(10, 100, 300, 300);
        chatList.setLayout(null);
        userList.setBounds(310, 100, 150, 300);
        userList.setLayout(null);

        chatList.setBackground(Color.blue);
        userList.setBackground(Color.red);

        this.add(chatList);
        this.add(userList);

        JPanel chatSend = new JPanel();
        chatSend.setBounds(10, 410, 500, 60);
        chatSend.setLayout(null);

        JTextField chatField = new JTextField();
        chatField.setBounds(0,0,300,30);
        JButton chatTrans = new JButton("Send");
        chatTrans.setBounds(320,0,50,50);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String host = hostField.getText();
                int port = Integer.parseInt(portField.getText());

                chatSystem.connect(host, port);
            }
        });

        chatSend.add(chatField);
        chatSend.add(chatTrans);

        this.add(chatSend);

        setVisible(true);
    }

    public static void main(String[] args) {

        new Main();

    }

}
