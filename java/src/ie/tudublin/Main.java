package ie.tudublin;

import example.*;
import c18342116.*;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new CubeVisual());		
	}

	public void firstVisual()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch(a, new firstVisual());
	}

	public void MyVisual()
	{
		
		String[] a = {"Main"};
		processing.core.PApplet.runSketch( a, new MyVisual());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		// main.startUI();	
		main.firstVisual();	
		// main.MyVisual();	
	}
}