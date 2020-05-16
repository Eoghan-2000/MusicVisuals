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

	public void secondVisual()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch(a, new secondVisual());
	}
	public void linesVisual() 
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch(a, new linesVisual());
	}
	public void linesVisual2()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch(a, new linesVisual2());
	}
	public void expanding()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch(a, new expanding());
	}
	public static void main(String[] args)
	{
		 Main main = new Main();
		// main.startUI();	
		// main.firstVisual();
		// main.MyVisual();	
		// main.secondVisual();
		// main.firstVisual();
		// main.linesVisual();
		// main.linesVisual2();
		main.expanding();

	}
}