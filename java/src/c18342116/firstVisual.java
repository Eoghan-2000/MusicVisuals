package c18342116;

import ie.tudublin.*;

public class firstVisual extends Visual
{
    boolean twocubes = false;
    boolean fourcubes = false;

    public void settings()
    {
        // size(800, 800, P3D);
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
        if (key == '1')
        {
            twocubes = ! twocubes;

        }
        else if (key =='2')
        {
            fourcubes = ! fourcubes;
        }
    }

    public void setup()
    {
        colorMode(HSB);
        noCursor();
        
        setFrameSize(256);

        startMinim();
        loadAudio("robotsinparis.mp3");

    }

    float smoothedBoxSize = 0;

    public void draw()
    {
        
        float boxSize = 50 + (getAmplitude() * 300);//map(average, 0, 1, 100, 400); 
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);        
        if (twocubes)//if statement for two cubes
        {
            calculateAverageAmplitude();
            background(0);
            noFill();
            lights();
            stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
            camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
            translate(0, 0, -300);
            pushMatrix();
            translate(-100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            sphere(smoothedBoxSize);
            popMatrix();
            pushMatrix(); 
            translate(100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            strokeWeight(1); 
            sphere(smoothedBoxSize);
            popMatrix();
        }
        else if(fourcubes)//if statement for four cubes
        {
            calculateAverageAmplitude();
            background(0);
            noFill();
            lights();
            stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
            camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
            translate(0, -100, -600);
            pushMatrix();
            translate(-200, 300, 0);
            rotateY(angle);
            rotateX(angle);
            sphere(smoothedBoxSize);
            popMatrix();
            pushMatrix();
            translate(200, 0, 0);
            rotateY(angle);
            rotateX(angle);
            strokeWeight(1); 
            sphere(smoothedBoxSize);
            popMatrix();
            pushMatrix();
            translate(200, 300, 0);
            rotateY(angle);
            rotateX(angle);
            sphere(smoothedBoxSize);
            popMatrix();
            pushMatrix();
            translate(-200, 0, 0);
            rotateY(angle);
            rotateX(angle);
            sphere(smoothedBoxSize);
            popMatrix();
        }
        else //one cube 
        {
            calculateAverageAmplitude();
            background(0);
            noFill();
            lights();
            stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
            camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
            translate(0, 0, -300);
            rotateY(angle);
            rotateX(angle);
            strokeWeight(1);            
            sphere(smoothedBoxSize);
        }
        angle += getAmplitude() / 8.0f;;
    }
    float angle = 0;
    }