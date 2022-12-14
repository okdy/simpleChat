package client;

import common.ChatMember;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    Chat chatSystem;
    static ChatMember chatMember;

//    Panel
    JPanel connectionPanel;
    JPanel chatListPanel;
    JPanel userListPanel;
    JPanel textFieldPanel;

//    TextField
    JTextField hostField;
    JTextField portField;
    JTextField nicknameField;
    JTextField chattingInputField;
    static JTextArea chattingArea;

//    Button
    JButton connectButton;
    JButton sendButton;

    public Main() {

        chatSystem = new Chat();


        setSize(500, 500);
        setLocation(100, 100);
        this.setTitle("client");
        this.setLayout(null);

//        Panel
        connectionPanel = new JPanel();
        chatListPanel = new JPanel();
        userListPanel = new JPanel();
        textFieldPanel = new JPanel();

        connectionPanel.setBounds(0,0,500,120);
        connectionPanel.setLayout(null);
        chatListPanel.setBounds(10, 100, 300, 300);
        chatListPanel.setLayout(null);
        chatListPanel.setBackground(Color.blue);
        userListPanel.setBounds(310, 100, 150, 300);
        userListPanel.setLayout(null);
        userListPanel.setBackground(Color.red);
        textFieldPanel.setBounds(10, 410, 500, 60);
        textFieldPanel.setLayout(null);

//        TextField
        hostField = new JTextField();
        portField = new JTextField();
        nicknameField = new JTextField();
        chattingInputField = new JTextField();
        chattingArea = new JTextArea();

        hostField.setBounds(10, 40, 200, 20);
        hostField.setText("127.0.0.1");
        portField.setBounds(10, 70, 200, 20);
        portField.setText("1234");
        nicknameField.setBounds(10, 100, 200, 20);
        nicknameField.setText("김치킨");
        chattingInputField.setBounds(0,0,300,30);
        chattingArea.setBounds(0, 0, 300, 300);

//        Button
        connectButton = new JButton("Connect");
        sendButton = new JButton("Send");

        connectButton.setBounds(220, 10, 100, 100);
        sendButton.setBounds(320,0,50,50);

//        Final
        connectionPanel.add(hostField);
        connectionPanel.add(portField);
        connectionPanel.add(nicknameField);
        connectionPanel.add(connectButton);

        textFieldPanel.add(chattingInputField);
        textFieldPanel.add(sendButton);

        chatListPanel.add(chattingArea);

        this.add(connectionPanel);
        this.add(chatListPanel);
        this.add(userListPanel);
        this.add(textFieldPanel);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatMember = new ChatMember(nicknameField.getText());
                String host = hostField.getText();
                int port = Integer.parseInt(portField.getText());

                chatSystem.connect(host, port);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    public static void appendChatting(String format) {
        chattingArea.append(format);
    }
}
