import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class MenuListener implements AdjustmentListener{
	private Scrollbar sb;
	private MenuModel m;
	
	public MenuListener(Scrollbar sb, MenuModel m) {
		this.sb = sb;
		this.m = m;
	}


	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		m.setNiveau(sb.getValue());		
		
	}

}
