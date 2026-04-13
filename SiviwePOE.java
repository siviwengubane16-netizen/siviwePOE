/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package siviwepoe;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Student
 */
public class SiviwePOE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         // === GLOBAL UI STYLE ===
        Color bgColor = new Color(255, 182, 193); // light pink
        Color borderColor = new Color(255, 102, 102); // light red
        Color textColor = Color.BLACK;

        UIManager.put("OptionPane.background", bgColor);
        UIManager.put("Panel.background", bgColor);
        UIManager.put("OptionPane.messageForeground", textColor);
        UIManager.put("OptionPane.border", new LineBorder(borderColor, 4));
        UIManager.put("Button.background", Color.WHITE);
        UIManager.put("Button.foreground", textColor);

        login login = new login();

        // === LOGO AND WELCOME SCREEN ===
        showWelcomeScreen();

        // === REGISTRATION ===
        while (true) {
            JOptionPane.showMessageDialog(null, 
                "📝 Let's get you started!\nPlease register you details to create your ME2YouChat account.");

            String username = JOptionPane.showInputDialog(null, 
                "👤 Enter a username (must include '_' and be 5 characters or fewer):");
            if (username == null) return;

            String password = JOptionPane.showInputDialog(null, 
                "🔒 Create a password (at least 8 characters, includes uppercase, number & symbol):");
            if (password == null) return;

            String cellphone = JOptionPane.showInputDialog(null, 
                "📱 Enter your cellphone (with international code, e.g. ‪+27838968976‬):");
            if (cellphone == null) return;

            String regMessage = login.registerUser(username.trim(), password, cellphone.trim());
            JOptionPane.showMessageDialog(null, regMessage);

            if (regMessage.equals("Registration successful.")) break;
        }

        // === LOGIN ===
        boolean loggedIn = false;
        String loggedUsername = null;
        while (!loggedIn) {
            JOptionPane.showMessageDialog(null, "🔑 Login to continue");
            String username = JOptionPane.showInputDialog(null, "👤 Username:");
            if (username == null) return;

            String password = JOptionPane.showInputDialog(null, "🔒 Password:");
            if (password == null) return;

            boolean ok = login.loginUser(username.trim(), password);
            String msg = login.returnLoginStatus(ok, username.trim());
            JOptionPane.showMessageDialog(null, msg);

            if (ok) {
                loggedIn = true;
                loggedUsername = username.trim();
            }
        }

   
    }

    private static void showWelcomeScreen() {
        Color bgColor = new Color(255, 182, 193); // light pink
        Color textColor = Color.BLACK;
        Color borderColor = new Color(255, 102, 102); // light red

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(bgColor);
        panel.setBorder(new LineBorder(borderColor, 5));

        JLabel title = new JLabel("💬 Me2Youchat 💬", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(textColor);

        panel.add(title, BorderLayout.CENTER);
       

        JOptionPane.showMessageDialog(null, panel, "Welcome to ME2YOUChat", JOptionPane.PLAIN_MESSAGE);
    }
}
    
    

