package c18342116;

import ie.tudublin.*;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class linesVisual2 extends Visual {
    //Variables to start minim
    Minim minim;
	AudioSample as;
    FFT fft;
    int frameSize=1024;
    int sampleRate = 44100;
    int numSamples = 100;
    float[] lerpedSamples = new float[numSamples];//array for the samples
    
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
    public void keyPressed()
    {
        if(key == ' ')
        {
            as.stop();
		    as.trigger();
        }
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
        //left side cordinates
        float lx1,lx2,ly1,ly2=0;
        for(int i = 0 ; i < numSamples ; i ++)
		{
            //maps the y cordinates to be equally divided among the right side of the visual
            lx1=0;
            ly1 = map(i,0,numSamples,0,height);
            strokeWeight(5);
             //maps the colour based on the number of samples
			float c = map(i,0,numSamples,0,255); 
			stroke(c, 255, 255);
            lerpedSamples[i] = lerp(lerpedSamples[i], fft.getBand(i), 0.2f);
            //gets the x coordinates based on the sample size
            //gets y by adding the y1 coordinate to the sample size at i
            lx2 =  lerpedSamples[i]*100;
            ly2=ly1+lerpedSamples[i]*100;
            line(lx1, ly1, lx2, ly2);
        }
        //right side coordinates
        float rx1,rx2,ry1,ry2=0;
        for(int i = 0 ; i < numSamples ; i ++)
		{
            //maps the y cordinates to be equally divided among the right side of the visual
            ry1 = map(i,0,numSamples,0,height);
            strokeWeight(5);
            //maps the colour based on the number of samples
			float c = map(i,0,numSamples,0,255); 
			stroke(c, 255, 255);
            lerpedSamples[i] = lerp(lerpedSamples[i], fft.getBand(i), 0.2f);
            //gets the x coordinates based on the sample size
            //gets y by adding the y1 coordinate to the sample size at i
            rx2 =  lerpedSamples[i]*100;
            ry2=ry1+lerpedSamples[i]*100;
            rx1 =width;
            line(rx1, ry1, width - rx2, ry2);
        }
        for(int i =0 ;i<numSamples; i++)
        {
            pushMatrix();
            //creates a box based on the size of the current sample
            float boxSize = 50 + (lerpedSamples[i]*5); 
            smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);       		
            noFill();
            //maps the colour based on the sample size 
            stroke(map(i, 0, numSamples, 0, 255), 255, 255);
            //puts box in the middle
            translate(width/2, height/2, 0);
            //rotates box
            rotateY(angle);
            rotateX(angle);
            strokeWeight(1);            
            box(smoothedBoxSize);
            popMatrix();
            
        }
        angle += lerpedSamples[50]/ 100.0f;
       
    }

}