package packman;



import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.Vector;

public class PacMan
  extends Canvas
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private int x;
  private int y;
  private boolean agressif = false;
  private DirectionType direction=DirectionType.HAUT;
  @SuppressWarnings("rawtypes")
private Vector pacmanListeners = new Vector();
  
  public static enum DirectionType
  {
    HAUT,  BAS,  GAUCHE,  DROITE;
    
    private DirectionType() {}
  }
  
  public PacMan()
  {
    setBackground(Color.yellow);
    repaint();
    this.changeDirection(PacMan.DirectionType.GAUCHE);
  }
  
  public Dimension getSize()
  {
    return new Dimension(10, 10);
  }
  
  public int getX()
  {
    return this.x;
  }
  
  public void setX(int paramInt)
  {
    this.x = paramInt;
  }
  
  public int getY()
  {
    return this.y;
  }
  
  public void setY(int paramInt)
  {
    this.y = paramInt;
  }
  
  public boolean isAgressif()
  {
    return this.agressif;
  }
  
  public void setAgressif(boolean paramBoolean)
  {
    this.agressif = paramBoolean;
  }
  
  public DirectionType getDirection()
  {
    return this.direction;
  }
  
 
@SuppressWarnings("unchecked")
public void addPacManListener(PacManListener paramPacManListener)
  {
    this.pacmanListeners.addElement(paramPacManListener);
  }
  
  public void removePacManListener(PacManListener paramPacManListener)
  {
    this.pacmanListeners.removeElement(paramPacManListener);
  }
  
  public void mouseClicked(MouseEvent paramMouseEvent)
  {
    if (this.isAgressif() == true)
    {
      this.setAgressif(false);
      this.setBackground(Color.yellow);
      this.changeDirection(PacMan.DirectionType.GAUCHE);
      repaint();
    }
    else
    {
      this.setAgressif(true);
      this.setBackground(Color.red);
      this.changeDirection(PacMan.DirectionType.GAUCHE);
      repaint();
    }
  }
 
  public void keyPressed(KeyEvent e)
  {	//37 gauche	
	  if(e.getKeyCode()==KeyEvent.VK_LEFT){
		  if(this.direction!=PacMan.DirectionType.GAUCHE){
			  this.changeDirection(PacMan.DirectionType.GAUCHE);
			  System.out.println("changement direction");
		  }
		  
	  }
	 
  }
 
  @SuppressWarnings("rawtypes")
public void changeDirection(DirectionType paramDirectionType)
  {
    this.direction = paramDirectionType;
    System.out.println("abonnement ");
    PacManEventObject localPacManEventObject = new PacManEventObject(this);
    Vector localVector;
   
    
    localVector = (Vector)this.pacmanListeners.clone();
    
    for (int i = 0; i < localVector.size(); i++)
    {
      PacManListener localPacManListener = (PacManListener)localVector.elementAt(i);
      localPacManListener.handleDirection(localPacManEventObject);
    }
  }
}
