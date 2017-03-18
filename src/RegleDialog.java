import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
/**
 * Boite de dialogue qui affiche les règles du puissance 4
 * 
 * elle recupère les règles du jeu depuis la page wikipédia française
 * et les affiches dans un label
 * 
 * @author Julien | Hugo
 * 
 */
private static final long serialVersionUID = 1L;
public class RegleDialog extends JDialog{


	public RegleDialog(Frame fenetre) {
		super(fenetre);
		this.setTitle("Règles");
		this.setSize(400, 350);
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new BorderLayout());

		String res = "";
		try {
			org.jsoup.nodes.Document doc = Jsoup.connect("https://fr.wikipedia.org/wiki/Puissance_4").get();
			Pattern p = Pattern.compile("regles | but | objectifs");
			Elements content = doc.getElementsMatchingOwnText(p);
			for (int i = 0; i < content.size(); i++){
				res += content.get(i).text();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			res = "erreur lors du chargement";
		}
		
		res = "<html>" + res + "</html>";  // permet aux labels de gerer automatiquement les retours à la ligne 
		JLabel titre = new JLabel("Les règles officielles :");
		JLabel regle = new JLabel(res);
		JLabel attribution = new JLabel("<html><a href='https://fr.wikipedia.org/wiki/Puissance_4'>Wikipedia</a></html>");
		titre.setFont(new Font("Verdana", Font.BOLD, 18));
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		attribution.setFont(new Font("Verdana", Font.ITALIC, 15));
		attribution.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(titre, BorderLayout.NORTH);
		this.add(regle, BorderLayout.CENTER);
		this.add(attribution, BorderLayout.SOUTH);
		
		this.addWindowListener(new CloseWindowListener(this));		
		this.setVisible(true);
	}


}
