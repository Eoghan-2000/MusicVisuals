package c18342116;

import ie.tudublin.*;

public class secondVisual extends Visual
{
    boolean seperate = false;
 
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
        if(key == '1')
        {
           seperate = !seperate;
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
    
            rot = rot + 0.01f;
            if(!seperate)//if the key is not pressed
            {
            //gets audio bands and puts them into a float array
            float[] bands = getSmoothedBands();
            for(int i = 0 ; i < bands.length ; i ++)
            {
                //creates a box based on the bands current frequency
                stroke(map(i, 0, bands.length, 0, 255), 255, 255);
                float h = bands[i];
                box(h, h, h);
                rotateY(rot);
            }
            translate(300,-0);
            for(int i = 0 ; i < bands.length ; i ++)
            {
                //creates a box based on the current frequency and translates it 300 away from the first box
                //both boxes will rotate based on the variable rot
                stroke(map(i, 0, bands.length, 0, 255), 255, 255);
                float h = bands[i];
                box(h, h, h);
                rotateY(rot);
            }
        }
        else if (seperate)//if the key is pressed
        {
            //will create four boxes with boxes within each other based on the same code as before
            //except this time there will be four boxes, three on the same x and z coordinates as each other but on different y coordinates
            //the other will be the main or centre cube
            float[] bands = getSmoothedBands();
            for(int i = 0 ; i < bands.length ; i ++)
            {
                stroke(map(i, 0, bands.length, 0, 255), 255, 255);
                float h = bands[i];
                box(h, h, h);
                
                rotateY(rot);
            }
            translate(300,0);
            for(int i = 0 ; i < bands.length ; i ++)
            {
                stroke(map(i, 0, bands.length, 0, 255), 255, 255);
                float h = bands[i];
                box(h, h, h);
                rotateY(rot);
            }
            translate(0,-300);
            for(int i = 0 ; i < bands.length ; i ++)
            {
                stroke(map(i, 0, bands.length, 0, 255), 255, 255);
                float h = bands[i];
                box(h, h, h);
                rotateY(rot);
            }
            translate(0, 600);
            for(int i = 0 ; i < bands.length ; i ++)
            {
                stroke(map(i, 0, bands.length, 0, 255), 255, 255);
                float h = bands[i];
                box(h, h, h);
                
                rotateY(rot);
            }

        }
        }
        float angle = 0;
        }
    