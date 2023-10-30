
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.Color;

public class Project05 extends Frame implements ActionListener
{
	// Objects
	String command = "";
	Triangle t;
	Rectangle r;
	Diamond d;
	RegularPolygon p;
	Cube c;
	Sphere s;

	// Colors
	JColorChooser colorChooser = new JColorChooser();
	Color backgroundColor = new Color(0,0,0);
	Color foregroundColor = new Color(255,255,255);
		
	// frame
	public static void main(String[] args)
	{
		Frame frame = new Project05();	
		frame.setResizable(true);
		frame.setSize(1000,840);
		frame.setVisible(true);
		
	}
	
	public Project05()
	{
		setTitle("Graphics - Vicky Hu");
		
		// Create Menu	
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		
		Menu fileMenu = new Menu("File");
		mb.add(fileMenu);
		
		MenuItem miAbout = new MenuItem("About");
		miAbout.addActionListener(this);
		fileMenu.add(miAbout);
		
		MenuItem miColor = new MenuItem("Color");
		miColor.addActionListener(this);
		fileMenu.add(miColor);
		
		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);
		fileMenu.add(miExit);
		
		// 2D Shapes menu
		Menu twoDMenu = new Menu("2D Shapes");
		mb.add(twoDMenu);
		
		MenuItem miTriangle = new MenuItem("Triangle");
		miTriangle.addActionListener(this);
		twoDMenu.add(miTriangle);
		
		MenuItem miRectangle = new MenuItem("Rectangle");
		miRectangle.addActionListener(this);
		twoDMenu.add(miRectangle);
		
		MenuItem miDiamond = new MenuItem("Diamond");
		miDiamond.addActionListener(this);
		twoDMenu.add(miDiamond);
	
		MenuItem miRegularPolygon = new MenuItem("Regular Polygon");
		miRegularPolygon.addActionListener(this);
		twoDMenu.add(miRegularPolygon);
		
		// 3D Shapes Menu
		Menu threeDMenu = new Menu("3D Shapes");
		mb.add(threeDMenu);
		
		MenuItem miCube = new MenuItem("Cube");
		miCube.addActionListener(this);
		threeDMenu.add(miCube);
		
		MenuItem miSphere = new MenuItem("Sphere");
		miSphere.addActionListener(this);
		threeDMenu.add(miSphere);
		
		// End program when window is closed
		WindowListener l = new WindowAdapter()
		{
						
			// window closed - exit program						
						public void windowClosing(WindowEvent ev)
						{
							System.exit(0);
						}
						// menu option selected - go to redraw and display method
						public void listener(WindowEvent ev)
						{
							repaint();
						}
						// window resized or refocused - redraw
						public void windowStateChanged(WindowEvent ev)
						{
							repaint();
						}
		
		};
		
		ComponentListener k = new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e) 
			{
        		repaint();           
    		}
		};
		
		// register listeners
			
		this.addWindowListener(l);
		this.addComponentListener(k);

	}
	
//******************************************************************************
//  called by windows manager whenever the application window performs an action
//  (select a menu item, close, resize, ....
//******************************************************************************

public void actionPerformed (ActionEvent ev)
	{
	// figure out which command was issued
	
	command = ev.getActionCommand();
	
	// take action accordingly
	switch (command)
	{
	case "About":
	{
		repaint();
		break;
	}
	case "Exit":
	{
		System.exit(0);
	}
	case "Color":
	{
		backgroundColor = JColorChooser.showDialog(
									                     null,
									                     "Choose Background Color",
									                     colorChooser.getBackground());

		foregroundColor = JColorChooser.showDialog(
									                     null,
									                     "Choose Drawing Color",
									                     colorChooser.getBackground());
		repaint();
		break;
	}
	case "Triangle":
	{
		t = new Triangle();
		t.getAttributes();
		repaint();
		break;
	}
	case "Rectangle":
	{
		r = new Rectangle();
		r.getAttributes();
		repaint();
		break;
	}
	case "Diamond":
	{
		d = new Diamond();
		d.getAttributes();
		repaint();
		break;
	}
	case "Regular Polygon":
	{
		p = new RegularPolygon();
		p.getAttributes();
		repaint();
		break;
	}
	case "Cube":
	{
		c = new Cube();
		c.getAttributes();
		repaint();
		break;
	}
	case "Sphere":
	{
		s = new Sphere();
		s.getAttributes();
		repaint();
		break;
	}
	}
}
//********************************************************
// called by repaint() to redraw the screen
//********************************************************
		
public void paint(Graphics g)
{
	
	// Check Command issued, take action accordingly
	switch(command)
	{
	case "About":
	{
		g.drawString(" Geometric Shapes",400, 100);
		g.drawLine (350,120, 550,120);
		g.drawString(" This program supports the entry of values of primary attributes and calculation of secondary " , 200, 140);
		g.drawString(" attributes (sides, angles, perimeter, area, surface area, and volume) of the following shapes: " , 200, 160);
		g.drawString("  ", 200, 180);
		g.drawString(" 1.      Triangle", 400, 200);
		g.drawString(" 2.      Rectangle", 400, 220);
		g.drawString(" 3.      Diamond", 400, 240);
		g.drawString(" 4.      Regular Polygon", 400, 260);
		g.drawString(" 5.      Cube", 400, 280);
		g.drawString(" 6.      Sphere", 400, 300);
		break;
	}
	case "Color":
	{
		this.setBackground(backgroundColor);
		this.setForeground(foregroundColor);
		break;	
	}
	case "Triangle":
	{
		int x1 = t.getX1();
		int y1 = t.getY1();
		int x2 = t.getX2();
		int y2 = t.getY2();
		int x3 = t.getX3();
		int y3 = t.getY3();
		
		// draw triangle property dialog
		g.drawString("Triangle Properties", 115, 105);
		g.drawLine(70, 120, 250, 120);
		g.drawString("First Point", 90, 140);
		g.drawString("= ("+x1+", "+y1+")", 170, 140);
		g.drawString("Second Point", 90, 160);
		g.drawString("= ("+x2+", "+y2+")", 170, 160);
		g.drawString("Third Point", 90, 180);
		g.drawString("= ("+x3+", "+y3+")", 170, 180);
		g.drawString("Perimeter", 90, 200);
		g.drawString("= "+ Round.roundDigits(t.getPerimeter(), 2), 170, 200);
		g.drawString("Area", 90, 220);
		g.drawString("= "+Round.roundDigits(t.getArea(), 1), 170, 220);
		// draw bounding rectangle of property dialog
		g.drawRect(65, 80, 190, 160);
		
		// draw the triangle
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x2, y2, x3, y3);
		g.drawLine(x1, y1, x3, y3);
		
		// add labels
		g.drawString("("+x1+", "+y1+")", x1-15, y1-15);
		g.drawString("("+x2+", "+y2+")", x2-10, y2-15);
		g.drawString("("+x3+", "+y3+")", x3-20, y3-15);
		break;
	}
	case "Rectangle":
	{
		int x = r.getxTopLeft();
		int y = r.getyTopLeft();
		int w = r.getWidth();
		int h = r.getHeight();
		
		// draw rectangle property dialog
		g.drawString("Rectangle Properties", 110, 105);
		g.drawLine(70, 120, 250, 120);
		g.drawString("TopLeft Corner", 90, 140);
		g.drawString("= ("+x+", "+y+")", 177, 140);
		g.drawString("Width", 90, 160);
		g.drawString("= "+w, 177, 160);
		g.drawString("Height", 90, 180);
		g.drawString("= "+h, 177, 180);
		g.drawString("Perimeter", 90, 200);
		g.drawString("= "+r.getPerimeter(), 177, 200);
		g.drawString("Area", 90, 220);
		g.drawString("= "+r.getArea(), 177, 220);
		// draw bounding rectangle of property dialog
		g.drawRect(65, 80, 190, 160);
		
		// draw the rectangle
		g.drawRect(x, y, w, h);
		
		// add labels
		g.drawString("("+x+", "+y+")", x-20, y-15);
		g.drawString(" "+w, x+(w/2), y-15);
		g.drawString(" "+h, x-30, y+(h/2));
		break;
	}
	case "Diamond":
	{
		int x = d.getXCenter();
		int y = d.getYCenter();
		int w = d.getWidth();
		int h = d.getHeight();
		
		// draw diamond property dialog
		g.drawString("Diamond Properties", 105, 105);
		g.drawLine(70, 120, 240, 120);
		g.drawString("Center Point", 90, 140);
		g.drawString("= ("+x+", "+y+")", 165, 140);
		g.drawString("Width", 90, 160);
		g.drawString("= "+w, 165, 160);
		g.drawString("Height", 90, 180);
		g.drawString("= "+h, 165, 180);
		g.drawString("Perimeter", 90, 200);
		g.drawString("= "+Round.roundDigits(d.getPerimeter(),2), 165, 200);
		g.drawString("Area", 90, 220);
		g.drawString("= "+Round.roundDigits(d.getArea(), 1), 165, 220);
		// draw bounding rectangle of property dialog
		g.drawRect(65, 80, 180, 160);
		
		// draw the diamond
		// draw center cross
		g.drawLine(x-w/2, y, x+w/2, y);
		g.drawLine(x, y-h/2, x, y+h/2);
		// draw outside diagonals
		g.drawLine(x-w/2, y, x, y-h/2);
		g.drawLine(x, y-h/2, x+w/2, y);
		g.drawLine(x+w/2, y, x, y+h/2);
		g.drawLine(x, y+h/2, x-w/2, y);
		
		// add labels
		g.drawString("("+x+", "+y+")", x-27, y-12);
		g.drawString(" "+w, x-(w/4), y+20);
		g.drawString(" "+h, x-30, y-(h/4));
		break;
	}
	case "Regular Polygon":
	{
		int x = p.getXCenter();
		int y = p.getYCenter();
		int r = p.getRadius();
		int n = p.getSides();
		int yCoord = 225+(20*n);
		double sl = p.getSideLength();
		
		// draw polygon property dialog
		g.drawString("Regular Polygon Properties", 90, 105);
		g.drawLine(70, 120, 250, 120);
		g.drawString("Center Point", 75, 140);
		g.drawString("= ("+x+", "+y+")", 180, 140);
		g.drawString("Radius", 75, 160);
		g.drawString("= "+r, 180, 160);
		g.drawString("# Sides", 75, 180);
		g.drawString("= "+n, 180, 180);
		g.drawLine(70, 190, 250, 190);
		g.drawString("Vertices", 130, 210);
		g.drawLine(70, 225, 250, 225);
		for(int i=0; i<n; i++)
		{
			int y1 = 245+(20*i);
			g.drawString("Point "+(i+1), 90, y1);
			double a = x+r*Math.cos(2*Math.PI*i/n);
			double b = y+r*Math.sin(2*Math.PI*i/n);
			g.drawString("= ("+Math.round(a)+", "+Math.round(b)+")", 160, y1);
		}
		g.drawLine(70, yCoord+20, 250, yCoord+20);
		g.drawString("Side", 75, yCoord+40);
		g.drawString("= "+Round.roundDigits(sl, 1), 180, yCoord+40);
		g.drawString("Perimeter", 75, yCoord+60);
		g.drawString("= "+Round.roundDigits(p.getPerimeter(),1), 180, yCoord+60);
		g.drawString("Area", 75, yCoord+80);
		g.drawString("= "+Round.roundDigits(p.getArea(), 2), 180, yCoord+80);
		// draw bounding rectangle of property dialog
		g.drawRect(65, 80, 190, yCoord+15);
		
		// draw the polygon
		// draw radius line
		g.drawLine(x, y, x+r, y);
		// draw sides
		for(int i=0; i<n; i++)
		{
			long a1 = Math.round(x+r*Math.cos(2*Math.PI*i/n));
			long b1 = Math.round(y+r*Math.sin(2*Math.PI*i/n));
			long a2 = Math.round(x+r*Math.cos(2*Math.PI*(i+1)/n));
			long b2 = Math.round(y+r*Math.sin(2*Math.PI*(i+1)/n));
			g.drawLine(Math.round(a1), Math.round(b1), Math.round(a2), Math.round(b2));
		}
		
		// add labels
		g.drawString("("+x+", "+y+")", x-20, y+15);
		g.drawString(" "+r, x+r/2, y-15);
		g.drawString(" "+Round.roundDigits(sl, 1), x+5*r/6, y-(int)(sl/2));
		break;
	}
	case "Cube":
	{
		int x = c.getXTopLeft();
		int y = c.getYTopLeft();
		int w = c.getWidth();
		int h = c.getHeight();
		int d = c.getDepth();
		
		// draw cube property dialog
		g.drawString("Cube Properties", 120, 105);
		g.drawLine(70, 120, 250, 120);
		g.drawString("TopLeft Corner", 90, 140);
		g.drawString("= ("+x+", "+y+")", 178, 140);
		g.drawString("Width", 90, 160);
		g.drawString("= "+w, 178, 160);
		g.drawString("Height", 90, 180);
		g.drawString("= "+h, 178, 180);
		g.drawString("Depth", 90, 200);
		g.drawString("= "+d, 178, 200);
		g.drawString("Surface Area", 90, 220);
		g.drawString("= "+Math.round(c.getSurfaceArea()), 178, 220);
		g.drawString("Volume", 90, 240);
		g.drawString("= "+Math.round(c.getVolume()), 178, 240);
		// draw bounding rectangle of property dialog
		g.drawRect(65, 80, 190, 175);
		
		// draw the cube
		g.drawRect(x, y, w, h);
		// draw left slanted line
		int xGap = w/4;
		int yRise = d/4;
		g.drawLine(x, y, x+xGap, y-yRise);
		// draw horizontal top line
		g.drawLine(x+xGap, y-yRise, x+xGap+w, y-yRise);
		// draw right slanted line
		g.drawLine(x+w, y, x+xGap+w, y-yRise);
		// draw bottom right slanted line
		g.drawLine(x+w, y+h, x+xGap+w, y+h-yRise);
		// draw right vertical line
		g.drawLine(x+xGap+w, y-yRise, x+xGap+w, y+h-yRise);
		
		// add labels
		g.drawString("("+x+", "+y+")", x-25, y-10);
		g.drawString(" "+w, x+(w/2), y-10);
		g.drawString(" "+h, x-30, y+(h/2));
		g.drawString(" "+d, x+17*w/16, y-5-d/16);
		break;
	}
	case "Sphere":
	{
		int x = s.getXCenter();
		int y = s.getYCenter();
		int r = s.getRadius();
		
		// draw sphere property dialog
		g.drawString("Sphere Properties", 115, 105);
		g.drawLine(70, 120, 260, 120);
		g.drawString("Center", 85, 140);
		g.drawString("= ("+x+", "+y+")", 160, 140);
		g.drawString("Radius", 85, 160);
		g.drawString("= "+r, 160, 160);
		g.drawString("Surface Area", 85, 180);
		g.drawString("= "+Round.roundDigits(s.getSurfaceArea(), 2), 160, 180);
		g.drawString("Volume", 85, 200);
		g.drawString("= "+Round.roundDigits(s.getVolume(), 2), 160, 200);
		// draw bounding rectangle of property dialog
		g.drawRect(65, 80, 200, 140);
		
		// draw the sphere
		g.drawOval(x-r, y-r, r*2, r*2);
		// draw radius line
		g.drawLine(x, y, x-r, y);
		// draw inner circle
		g.drawOval(x-r, y-r/3, r*2, 2*r/3);
		
		// add labels
		g.drawString("("+x+", "+y+")", x-20, y+15);
		g.drawString(" "+r, x-(r/2), y-10);
		break;
	}
	}
}
		
}
