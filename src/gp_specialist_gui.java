import javax.swing.JFrame;
 
public class gp_specialist_gui {
  public static void main(String[] args){
    JFrame frame = new JFrame();
    //add maximum width and height to the jframe 'frame'
    frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("GP Specialist");

    //make the jframe 'frame' appear in the center of the screen
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  } 
}
