package packman;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import packman.PacMan.DirectionType;

public class FantomeBean extends Canvas implements java.io.Serializable,PacManListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int x;
	private int y;
	private PacMan.DirectionType direction; 
	
	public FantomeBean(){
		setBackground(Color.white);
		repaint();
	}
	
	
	public void chasserVers(PacMan.DirectionType direction){
		setBackground(Color.red);
		repaint();
	}
	
	public Dimension getSize(){
		return new Dimension(10,10);
	}
	
	public void fuirDe(PacMan.DirectionType direction){
		setBackground(Color.green);
		repaint();
	}

	@Override
	public void handleDirection(PacManEventObject e) {
		// TODO Auto-generated method stub
	
		setBackground(Color.black);
		repaint();
		/*System.out.println("action du fantome ");
		if (pacman.isAgressif())
			{fuirDe(pacman.getDirection());}
		else {
			chasserVers(pacman.getDirection());
		}*/
	}
	
	
}
