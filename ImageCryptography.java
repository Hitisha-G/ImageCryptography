import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
//import javax.sql.rowset.spi.SyncResolver;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageEN {

    public static void operate(int key) {
        JFileChooser fileChooser= new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();

        //file read
        try{

            FileInputStream fis= new FileInputStream(file);
            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data){
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }

            FileOutputStream fos= new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "done");
            

        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args) {
       // System.out.println("trial 123");

        JFrame f= new JFrame();
        f.setTitle("Image Crptography");
        f.setSize(350,500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font=new Font("Roboto",Font.BOLD,25);
        //button
        JButton button=new JButton();
        button.setText("Select Image");
        button.setFont(font);

        

        //create textfeild
        JTextField textField = new JTextField(10);
        textField.setFont(font);

        f.setLayout(new FlowLayout());

        f.add(button);
        f.add(textField);

        button.addActionListener(e->{
            System.out.println("button is clicked");
            String text = textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp);

        });
        

        f.setVisible(true);
    }
}

