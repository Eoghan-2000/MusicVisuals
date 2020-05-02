package c18342116;

import ie.tudublin.*;

public class secondVisual extends Visual
{
 
int lastFrame = 0;
 
    public void settings()
    {
        println("CWD: " + System.getProperty("user.dir"));
        fullScreen(P3D, 2);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            
        }
 
    }


    public void setup()
    {
        colorMode(HSB);
        noCursor();
        setFrameSize(256);
        startMinim();
        loadAudio("robotsinparis.mp3");
        getAudioPlayer().play();
        //getAp().play();
        // startListening(); 
        
    }
        float radius = 200;

        float smoothedBoxSize = 0;

        float rot = 0;

        public void draw()
        {  
            calculateAverageAmplitude();
            try
            {
                calculateFFT();
            }
            catch(VisualException e)
            {
                e.printStackTrace();
            }
            calculateFrequencyBands();
            background(0);
            noFill();
            stroke(255);
            lights();
            stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
            camera(0, -500, 500, 0, 0, 0, 0, 1, 0);
            // translate(0, 0, -250);
    
            rot = rot + 0.01f;
            float[] bands = getSmoothedBands();
            for(int i = 0 ; i < bands.length ; i ++)
            {
                stroke(map(i, 0, bands.length, 0, 255), 255, 255);
                float h = bands[i];
                box(h, h, h);
                translate(50,-50,50);
                rotateY(rot);
                // rotateX(rot);
                // translate(-50,50,-50);
                // translate(0,-100);
                // rotate(rot, rot, rot, rot);
                // translate(h, h);
                // box(h*2,h*2,h*2);
                // // translate(-100,-100,0);
                // box(h,h,h);
            }
    
        }
        float angle = 0;
        }
    