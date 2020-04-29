package c18342116;

import ie.tudublin.*;

public class firstVisual extends Visual
{
    boolean twocubes = false;

    public void settings()
    {
        // size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        fullScreen(P3D, SPAN);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            
        }
        if (key == '1')
        {
            twocubes = ! twocubes;

        }
    }

    public void setup()
    {
        colorMode(HSB);
        noCursor();
        
        setFrameSize(256);

        startMinim();
        loadAudio("robotsinparis.mp3");
        //getAp().play();
        // startListening(); 
        
    }

    float smoothedBoxSize = 0;

    public void draw()
    {
        
        float boxSize = 50 + (getAmplitude() * 300);//map(average, 0, 1, 100, 400); 
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);        
        if (twocubes)
        {
            calculateAverageAmplitude();
            background(0);
            fill(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
            lights();
            stroke(0);
            camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
            translate(0, 0, -300);
            pushMatrix();
            translate(-100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            // box(smoothedBoxSize);
            sphere(smoothedBoxSize);
            //strokeWeight(1);
            //sphere(smoothedBoxSize);
            popMatrix();
            pushMatrix();
            translate(100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            strokeWeight(5); 
            // box(smoothedBoxSize);
            sphere(smoothedBoxSize);
            popMatrix();
        }
        else
        {
            calculateAverageAmplitude();
            background(0);
            fill(0);
            lights();
            stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
            camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
            translate(0, 0, -300);
            rotateY(angle);
            rotateX(angle);
            //strokeWeight(1);
            //sphere(smoothedBoxSize/ 2);            
            // strokeWeight(5);
            strokeWeight(1);            
            // box(smoothedBoxSize);
            sphere(smoothedBoxSize);
        }
        angle += 0.01f;
    }
    float angle = 0;
    }