import javax.swing.*;
import java.awt.*;

/**
 * Created by Jeppe on 2016-02-19.
 */
public class Window {

    private JFrame JR;
    private int width;
    private int height;
    private String namn;
    private Canvas canvas;


    public Window (int bredd, int hojjd, String namn) {
        this.bredd = bredd;
        this.hojjd = hojjd;
        this.namn = namn;
        bild ();
    }

    private void (){

        canvas = new Canvas();
        canvas.setMaximumSize(new Dimension(bredd, hojjd));
        canvas.setMinimumSize(new Dimension(bredd, hojjd));
        canvas.setPreferredSize(new Dimension(bredd, hojjd));

        JR = new JFrame(namn);
        JR.setSize(bredd, hojjd);
        JR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JR.setVisible(true);
        JR.setLocationRelativeTo(null);
        JR.setResizable(false);

        JR.add(canvas);
        JR.pack();
    }


}













}
