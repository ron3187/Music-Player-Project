
package Spotibai;

import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;

public class Song_List extends JFrame{
    

private LinkedList<String> List2;
private DefaultListModel<String> def2;
    
    Song_List(){
    List2 = new LinkedList<>();
    def2 = new DefaultListModel<>();
        
        setSize(350, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
}
