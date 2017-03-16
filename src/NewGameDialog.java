import java.awt.Font;
import java.awt.Frame;
import java.awt.Dialog.ModalityType;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

import puisQuatre.Puis4;

public class NewGameDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	public NewGameDialog(Frame menu, Puis4 modele) {
		super(menu, "Nouvelle Partie", false);
		
		this.setSize(400,500);
		this.setLocationRelativeTo(menu);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setLayout(null);
		
		JLabel difficulte = new JLabel("Difficult�", JLabel.CENTER);
		difficulte.setFont(new Font(Font.DIALOG, Font.CENTER_BASELINE, 60));
		difficulte.setLocation(50, 20);
		difficulte.setSize(300, 60);
		
		JLabel getDifficulte = new JLabel(new ImageIcon("etoile.png"), JLabel.CENTER);
		getDifficulte.setFont(new Font(Font.DIALOG, Font.CENTER_BASELINE, 80));
		getDifficulte.setLocation(50, 90);
		getDifficulte.setSize(300, 60);
		
		JScrollBar setDifficulte = new JScrollBar(JScrollBar.HORIZONTAL, 1, 1, 1, 6);
		setDifficulte.setLocation(100, 160);
		setDifficulte.setSize(200,30);
		setDifficulte.addAdjustmentListener(new AdjustLabelDifficultyListener(getDifficulte));
				
		JLabel grille = new JLabel("Grille", JLabel.CENTER);
		grille.setFont(new Font(Font.DIALOG, Font.CENTER_BASELINE, 60));
		grille.setLocation(100, 220);
		grille.setSize(200, 60);
		
		JComboBox<String> tailleGrille = new JComboBox<String>();
		tailleGrille.setLocation(100, 300);
		tailleGrille.setSize(200, 30);
		tailleGrille.addItem("7 x 6");
		tailleGrille.addItem("8 x 7");
		tailleGrille.addItem("9 x 8");
		
		JButton jouer = new JButton("Jouer");
		jouer.setLocation(100, 400);
		jouer.setSize(200, 30);
		jouer.addActionListener(new NewGameFromMenuListener(setDifficulte, tailleGrille, menu, this));
				
		this.add(difficulte);
		this.add(getDifficulte);
		this.add(setDifficulte);
		this.add(grille);
		this.add(tailleGrille);
		this.add(jouer);
		
		this.setVisible(true);
	}
}
