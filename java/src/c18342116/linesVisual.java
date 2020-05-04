package c18342116;

import ie.tudublin.*;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class linesVisual extends Visual 
{

	Minim minim;
	AudioSample as;
    FFT fft;
    int frameSize=1024;
    int sampleRate = 44100;
	int numSamples = 100;
	float[] lerpedSamples = new float[numSamples];

	public void settings()
	{
		fullScreen(P3D,2);
    }
    public void keyPressed() {
		if (key == ' ') {
			as.stop();
			as.trigger();
        }
    }

	

	public void setup() 
	{
		minim = new Minim(this);
        as = minim.loadSample("robotsinparis.mp3", frameSize);
		background(0);
		fft = new FFT(frameSize, 44100);
		
	}

	float cx, cy;
	float offs = 0;
	public void draw()
	{	
        camera(width/2, height/2, (height/2) / tan(PI*30 / 180), width/2, height/2, 0, 0, -1, 0);
		background(0);		
		colorMode(HSB);	

		fft.window(FFT.HAMMING);
		fft.forward(as.left);
 
		float radius = width/2;
		float cgap = 255 / numSamples + 1;
		float average = 0;
		float x1,x2,y1,y2,z1,z2 =0;
		for(int i = 0 ; i < numSamples ; i ++)
		{
			strokeWeight(5);
			float c = ((i + offs) * cgap) % 255; 
			stroke(c, 255, 255);
			float t = map(i,0,100,0,360);
			lerpedSamples[i] = lerp(lerpedSamples[i], fft.getBand(i), 0.2f);
			z1 = radius * cos(t) - width/2;
			z2 = radius * cos(t) - width/2;
			x1 = radius * sin(t) +width/2;
			x2 = radius * sin(t) +width/2;
			y1=0;
			y2 =lerpedSamples[i] * 100;
			line(x1, y1,z1,x2,y2,z2);
			average += lerpedSamples[i];
		}
		average /= (float) numSamples;
		offs = average * 2;
	}
}