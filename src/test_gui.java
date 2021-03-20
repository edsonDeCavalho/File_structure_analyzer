
import gui.gui;
/**
 * Classe pour lancer le GUI.	
 * @author Julien De Puertas
 * @version 3
 *
 */
public class test_gui {

	public static void main(String[] args) {
				try {
					gui window = new gui("GUI");
					window.frmFileAnalysateur.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

}

