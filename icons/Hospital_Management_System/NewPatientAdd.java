import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;


public class NewPatientAdd extends JFrame implements ActionListener{

    JComboBox ComboBox; //RoomComboBox

    JTextField TextFieldnumber, TextFieldname1, PatientDisease1, depositt;
    
    Choice c1;

    JRadioButton radiobutton1, radiobutton2;

    JButton Add, Back;

    JLabel date;

    public NewPatientAdd()
    {

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/patient3.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageicon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel label1 = new JLabel("NEW PATIENT FORM");
        label1.setBounds(110, 20, 300, 30);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(label1);

        JLabel id = new JLabel("ID :");
        id.setBounds(35, 76, 200, 20);
        id.setFont(new Font("Tahoma", Font.BOLD, 14));
        id.setForeground(Color.WHITE);
        panel.add(id);

        ComboBox = new JComboBox<>(new String[] {"Adhar Card", "Voter Id", "Driving License"});
        ComboBox.setBounds(285, 73, 150,20);
        ComboBox.setBackground(new Color(3,45,48));
        ComboBox.setForeground(Color.white);
        ComboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(ComboBox);

        JLabel number= new JLabel("Number :");
        number.setBounds(35, 120, 200, 20);
        number.setFont(new Font("Tahoma", Font.BOLD, 14));
        number.setForeground(Color.WHITE);
        panel.add(number);

        TextFieldnumber = new JTextField();
        TextFieldnumber.setBounds(285, 120, 150, 20);
        panel.add(TextFieldnumber);

        JLabel name= new JLabel("Name :");
        name.setBounds(35, 165, 200, 20);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        name.setForeground(Color.WHITE);
        panel.add(name);

        TextFieldname1 = new JTextField();
        TextFieldname1.setBounds(285, 165, 150, 20);
        panel.add(TextFieldname1);

        JLabel gender= new JLabel("Gender :");
        gender.setBounds(35, 210, 200, 20);
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        radiobutton1 = new JRadioButton("Male");
        radiobutton1.setBounds(285,210,76,22);
        radiobutton1.setBackground(new Color(90,156,163));
        radiobutton1.setForeground(Color.white);
        panel.add(radiobutton1);

        radiobutton2 = new JRadioButton("Female");
        radiobutton2.setBounds(360,210,76,22);
        radiobutton2.setBackground(new Color(90,156,163));
        radiobutton2.setForeground(Color.white);
        panel.add(radiobutton2);

        JLabel PatientDisease = new JLabel("Patient Disease : ");
        PatientDisease.setBounds(35, 255, 255, 20);
        PatientDisease.setFont(new Font("Tahoma", Font.BOLD, 14));
        PatientDisease.setForeground(Color.WHITE);
        panel.add(PatientDisease);

        PatientDisease1 = new JTextField();
        PatientDisease1.setBounds(285, 255, 150, 20);
        panel.add(PatientDisease1);

        JLabel Roomnumber = new JLabel("Room Number : ");
        Roomnumber.setBounds(35, 300, 200, 20);
        Roomnumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        Roomnumber.setForeground(Color.WHITE);
        panel.add(Roomnumber);

        c1 = new Choice();
        try {
        	Conn c = new Conn();
        	ResultSet resultSet = c.stm.executeQuery("select * from Room where Availability = 'Available'");
        	while (resultSet.next()) {
        		c1.add(resultSet.getString("Room_number"));
        	}
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        c1.setBounds(280,300,160,20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setForeground(Color.white);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);

        JLabel time = new JLabel("Time : ");
        time.setBounds(35, 345, 255, 20);
        time.setFont(new Font("Tahoma", Font.BOLD, 14));
        time.setForeground(Color.WHITE);
        panel.add(time);

        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(285, 345, 250, 16);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(date);

        JLabel deposit = new JLabel("Deposit : ");
        deposit.setBounds(35, 390, 255, 20);
        deposit.setFont(new Font("Tahoma", Font.BOLD, 14));
        deposit.setForeground(Color.WHITE);
        panel.add(deposit);

        depositt = new JTextField();
        depositt.setBounds(280, 390, 150, 20);
        panel.add(depositt);

        Add = new JButton("ADD");
        Add.setBounds(200, 450, 80, 25);
        //login.setBackground(Color.BLACK);
        //login.setForeground(Color.WHITE);
        Add.addActionListener(this);
        panel.add(Add);

        Back = new JButton("BACK");
        Back.setBounds(320, 450, 80, 25);
        Back.addActionListener(this);
        panel.add(Back);

        setUndecorated(true);
        setSize(850, 550);
        setLayout(null);
        setLocation(300, 250);
        setVisible(true);
    }
        @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Add){
        	Conn c = new Conn();
        	String radioBTN = null;
        	if(radiobutton1.isSelected()) {
        		radioBTN = "Male";
        	}else if(radiobutton2.isSelected()){
        		radioBTN = "Female";
        	}
        	String s1 = (String)ComboBox.getSelectedItem();
        	String s2 = TextFieldnumber.getText();
        	String s3 = TextFieldname1.getText();
        	String s4 = radioBTN;
        	String s5 = PatientDisease1.getText();
        	String s6 = c1.getSelectedItem();
        	String s7 = date.getText();
        	String s8 = depositt.getText();
        	
            // validate input 
            if(s2.isEmpty() || s3.isEmpty() || s5.isEmpty() || s6.isEmpty() ){
                JOptionPane.showMessageDialog(null, "All fileds must be filled !");
                return;
            }
        	
            
        	try {

                int aamount = Integer.parseInt(s8);// validate number
                
        		String q = "insert into paitent_info values('"+s1+"', '"+s2+"', '"+s3+"', '"+s4+"', '"+s5+"', '"+s6+"', '"+s7+"', '"+s8+"')";
        		String q1 = "Update Room set Availability = 'Occupied' where Room_number ="+s6;
        		c.stm.executeUpdate(q);
        		c.stm.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Infomation Added ");
        		dispose();
        	}catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Amount must be a number.");

             }
            
            catch(Exception E)
        	{
        		E.printStackTrace();
        	}
        	
        }else
        {

           dispose();       
       }
           }
           public static void main(String[] args) {
            new NewPatientAdd();
           }
  

}