package c18342116;

import ie.tudublin.*;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class expanding extends Visual {

    Minim minim;
	AudioSample as;
    FFT fft;
    int frameSize=1024;
    int sampleRate = 44100;
	int numSamples = 100;
    float[] lerpedSamples = new float[numSamples];
    
    public void setup()
    {
        colorMode(HSB);
        noCursor();
        minim = new Minim(this);
        as = minim.loadSample("robotsinparis.mp3", frameSize);
		background(0);
		fft = new FFT(frameSize, 44100);
		as.stop();
		as.trigger();
    }

    public void settings()
    {
        fullScreen(P3D, 2);
    }
    float smoothedBoxSize = 0;
    float angle = 0;
    public void draw()
    {
        background(0);
        fft.window(FFT.HAMMING);
        fft.forward(as.left);
        for(int i =0 ;i<numSamples; i++)
        {
            lerpedSamples[i] = lerp(lerpedSamples[i], fft.getBand(i), 0.5f);
            pushMatrix();
            float boxSize = 50 + (lerpedSamples[i]*100); 
            smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);       		
            noFill();
            stroke(map(i, 0, numSamples, 0, 255), 255, 255);
            translate(width/2, height/2, 0);
            rotateY(angle);
            rotateX(angle);

            strokeWeight(1);            
            box(smoothedBoxSize);
            popMatrix();
            
        }
        angle += lerpedSamples[50]/ 100.0f;
       
    }

}