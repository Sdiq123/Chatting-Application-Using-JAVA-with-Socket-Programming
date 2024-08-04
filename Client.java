

package chatting.application;


import java.awt.*; // helps in importing the color class so that frame can be colored
import javax.swing.*; // extended version of java in which swing library is available through which we can use frames 
import java.awt.event.*; // on the arrow image icon , there must be an action performed which can implemented by overriding ActionListener Method
import javax.swing.border.*;// border package is a child package of swing package which helps to set the border
import java.util.*; // to use the Calendar Class
import java.text.*; // to use SimpleDateFormat Class
import java.net.*; // to import socket 
import java.io.*; 

public class Client /*extends JFrame*/ implements ActionListener {

    JTextField text; // Defining it Globally so that it can be accessed everywhere , because the text has to be displayed on the frame 
    static JPanel a1;
    static Box vertical = Box.createVerticalBox();
    
    static JFrame f = new JFrame();
    
    static DataOutputStream dout ;
    
    Client() {
        
        f.setLayout(null); // it is also function of swing where there are many layouts in java like border layout , grid layout and box layout , i am just setting here it null as i want to design my own layout 
        
        JPanel p1 = new JPanel(); // Panel creates a diffrent section on the top of the frame 
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null); // so that the image properly fits on the panel
        f.add(p1); // add funtion sets the panel above the frame since setlayout is null we have to explicitly mention the cordinates where eill it set
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png")); // creating an image icon class which will help me in getting the image 
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT); // scaling the image so that it can be properly visible
        ImageIcon i3 = new ImageIcon(i2); // you cannot directly pass only the scaled image in JLabel hence making it an ImageIcon 
        JLabel back = new JLabel(i3); // 
        back.setBounds(5, 20, 25, 25);
        p1.add(back); // we have to add the image on top of the panel not on the frame 
        
        
        
        back.addMouseListener(new MouseAdapter(){  // action to be performed on clicking the back arrow image hence adding an event listener
            public void mouseClicked(MouseEvent ae){
                System.exit(0);
            }
        });
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/amulya.jpg")); // creating an image icon class which will help me in getting the image 
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT); // scaling the image so that it can be properly visible
        ImageIcon i6 = new ImageIcon(i5); // you cannot directly pass only the scaled image in JLabel hence making it an ImageIcon 
        JLabel profile = new JLabel(i6); // 
        profile.setBounds(40, 10, 50, 50);
        p1.add(profile); // we have to add the image on top of the panel not on the frame 
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png")); // creating an image icon class which will help me in getting the image 
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT); // scaling the image so that it can be properly visible
        ImageIcon i9 = new ImageIcon(i8); // you cannot directly pass only the scaled image in JLabel hence making it an ImageIcon 
        JLabel video = new JLabel(i9); // 
        video.setBounds(300, 20, 30, 30);
        p1.add(video); // we have to add the image on top of the panel not on the frame 
        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png")); // creating an image icon class which will help me in getting the image 
        Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT); // scaling the image so that it can be properly visible
        ImageIcon i12 = new ImageIcon(i11); // you cannot directly pass only the scaled image in JLabel hence making it an ImageIcon 
        JLabel phone = new JLabel(i12); // 
        phone.setBounds(360, 20, 35, 30);
        p1.add(phone); // we have to add the image on top of the panel not on the frame 
        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png")); // creating an image icon class which will help me in getting the image 
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT); // scaling the image so that it can be properly visible
        ImageIcon i15 = new ImageIcon(i14); // you cannot directly pass only the scaled image in JLabel hence making it an ImageIcon 
        JLabel morevert = new JLabel(i15); // 
        morevert.setBounds(420, 20, 10, 25);
        p1.add(morevert); // we have to add the image on top of the panel not on the frame 
        
        JLabel name = new JLabel ("AMULYA"); // Main Function Of JLabel is used to write on the frame 
        name.setBounds(110, 15, 100, 18);
        name.setForeground(Color.WHITE); // default color is always black with this you can set it to white
        name.setFont(new Font("SAN SERIF", Font.BOLD, 18));
        p1.add(name);
        
        JLabel status = new JLabel ("Active Now"); // Main Function Of JLabel is used to write on the frame 
        status.setBounds(110, 35, 100, 18);
        status.setForeground(Color.WHITE); // default color is always black with this you can set it to white
        name.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        p1.add(status);
        
        // till here whatever was created was for the header of the panel , now we are creating a seperate panel for the text area
        
        a1 = new JPanel();  // creating a panel for text area
        a1.setBounds(5,75,440,570);
        f.add(a1); 
        
        text = new JTextField(); // with the help of JTextField class user can write anything , With the help of JTextField Class creating an Object text
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN,16));
        f.add(text);
        
        JButton send = new JButton("Send");
        send.setBounds(320,655,123,40);
        send.setBackground(new Color(7, 94, 84));
        send.addActionListener(this); // needs to perform some action on clicking the send button and that action should be performed in ActionPerformed Function
        send.setForeground(Color.WHITE);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN,16));
        f.add(send);
        
        
        f.setSize(450,700); //sets the size of the frame length 450 (width) height 700
        f.setLocation(800, 50); //by default frame opens from the left corner
        f.setUndecorated(true); // removes the extra cancel, minimize and maximize functions
        f.getContentPane().setBackground(Color.WHITE); // helps in setting background color to the pane 
       
        
        
        
        f.setVisible(true); // by default visibility of the frame is hidden we have to set its value true it should always be in last because after applying all the changes it has to get updated
    }
    @Override
    public void  actionPerformed(ActionEvent ae){ // what ever i write in text field must be taken from there and displayed on the screen
       try{   // because we are dealing with server we are supposed to do with try and catch block
        String out = text.getText();  // text written in Text Field must be taken out and stored in the string format in the out variable
       
       JLabel output = new JLabel(out);
       
       JPanel p2 = formatLabel(out);
       //p2.add(output);
       
       a1.setLayout(new BorderLayout()); // Border Layout places your elements in top left , bottom right and centre
       
       JPanel right = new JPanel(new BorderLayout()); // displays messages vertically 
       right.add(p2, BorderLayout.LINE_END); //whatever you type in the text box must be displayed towards the right of the screen
       vertical.add(right);
       vertical.add(Box.createVerticalStrut(15)); // displays messages one after the other with space 15
    
       a1.add(vertical, BorderLayout.PAGE_START);
       dout.writeUTF(out);
       text.setText("");// once you click the send button text in the field will get empty
       
       f.repaint();  // these function is necessary to call so that whenever i call types in the text field and click on the send button it has to appear on the screen
       f.invalidate();
       f.validate();
       
       
       } catch (Exception e){
           e.printStackTrace();
       }
    }
    
    public static JPanel formatLabel(String out){ // creating another function where whenever i type and send a message it should appear in a box
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            
            JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out +"</p></html>");
            output.setFont(new Font("Tahoma",Font.PLAIN,16));
            output.setBackground(new Color(37, 211, 102));
            output.setOpaque(true);
            output.setBorder(new EmptyBorder(15, 15, 15, 50));
            
            panel.add(output);
            
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            
            JLabel time = new JLabel();
            time.setText(sdf.format(cal.getTime())); // to get the current time
            
            panel.add(time);
            
            return panel;
            
    }
    public static void main(String args[]) {
        new Client();
        
        try{
           Socket s = new Socket("127.0.0.1",6001); // since we are running our application on loca host hence the ip of it , and on which port are we mapping it on 6001 and with the help of this socket i am connected to the server now 
           DataInputStream din = new DataInputStream(s.getInputStream()); // now if you need to recieve the message it is possible through data input stram
           dout = new DataOutputStream(s.getOutputStream()); // if you need to send the message , we can write a message 
            
           while(true){
                    a1.setLayout(new BorderLayout());
               
                    String msg = din.readUTF();  // protocol to read the message ehich returns a string                  
                    JPanel panel = formatLabel(msg); // now whatever the message is there it is in the msg variable now i need to display it on my screen with help of this
                
                    JPanel left = new JPanel(new BorderLayout()); // recieved message should appear on left
                    left.add(panel, BorderLayout.LINE_START); // to display from starting means recived messages will display on the left 
                    vertical.add(left);   // both vertical and validate are dynamic methods and you cannot use it in main method which is always takes static method hence declaring it globally that it is static 
                    
                    vertical.add(Box.createVerticalStrut(15));
                    
                    a1.add(vertical, BorderLayout.PAGE_START);
                    
                    f.validate(); // i have to make the frame also static so it cannot happen simply through extend i have to make an object of it 
                
                }
           
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
}
