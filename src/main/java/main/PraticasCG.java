package main;

import view.TelaInicial;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Igor J Rodrigues
 */
public class PraticasCG {
       /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

                try {
                    UIManager.setLookAndFeel(new FlatIntelliJLaf());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
                UIManager.getLookAndFeelDefaults().put("defaultFont", new Font("Comic Sans MS", Font.PLAIN, 14));
                new TelaInicial().setVisible(true);

    }
}
