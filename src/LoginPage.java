import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    HashMap<String,String> logininfo = new HashMap<String,String>();

    JFrame frame = new JFrame();
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JLabel userIDLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();

    LoginPage(HashMap<String,String> loginInfoOriginal){
        logininfo = loginInfoOriginal;

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(messageLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
            messageLabel.setText("");
        }
        if(e.getSource() == loginButton){
            String userID = userIDField.getText();
            String userPassword = String.valueOf(userPasswordField.getPassword());

            if(logininfo.containsKey(userID)){
                if(logininfo.get(userID).equals(userPassword)){
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Login successful");
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage(userID);
                }
                else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Wrong password");
                }
            }
            else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Username not found");
            }
        }
    }
}
