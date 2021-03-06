package birth;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;


public class login {
    
    private static JFrame frame;
    
    public static void main(String[] args) {
	frame = new JFrame("Login");
	frame.setSize(300, 140);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
	frame.add(panel);
	placeComponents(panel);

        frame.setVisible(true);
        frame.setResizable(false);
    }        
        
    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

	JLabel userLabel = new JLabel("User");
	userLabel.setBounds(10, 10, 80, 25);
	panel.add(userLabel);

	JTextField userText = new JTextField(20);
	userText.setBounds(100, 10, 160, 25);
	panel.add(userText);

	JLabel passwordLabel = new JLabel("Password");
	passwordLabel.setBounds(10, 40, 80, 25);
	panel.add(passwordLabel);

	JPasswordField passwordText = new JPasswordField(20);
	passwordText.setBounds(100, 40, 160, 25);
	panel.add(passwordText);

	JButton loginButton = new JButton("login");
	loginButton.setBounds(10, 80, 80, 25);
	panel.add(loginButton);
        
        loginButton.addActionListener(new ActionListener() {                        

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String user;
                char[] password;
                boolean check;
                gui Gui;
                
                user = userText.getText();
                password = passwordText.getPassword();                
                backend Bend = new backend();
                check = Bend.login(user, password);
                                
                if (check) {
                    Gui = new gui();                      
                    frame.setVisible(false);
                    frame.dispose();
                }
                else {
                    userText.setText("");
                    passwordText.setText("");
                    JOptionPane.showMessageDialog(null, "Incorrect login information");                    
                }
            }
        });
				
    }

}