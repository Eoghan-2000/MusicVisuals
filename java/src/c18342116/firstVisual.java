package c18342116;

import ie.tudublin.*;

public class firstVisual extends Visual
{
    //boolean variables for changes in visual
    boolean twospheres = false;
    boolean fourspheres = false;

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
        if (key == '1')//turns visual into two spheres
        {
            twospheres = ! twospheres;

        }
        else if (key =='2')//turns visual into four spheres
        {
            fourspheres = ! fourspheres;
        }
    }

    public void setup()
    {
        colorMode(HSB);
        noCursor();
        setFrameSize(256);
        startMinim();
        loadAudio("robotsinparis.mp3");
        getAudioPlayer().cue(0);
        getAudioPlayer().play();

    }

    float smoothedBoxSize = 0;
    public void draw()
    {
        float boxSize = 50 + (getAmplitude() * 300);//get box size using amplitude
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);        
        if (twospheres)//if statement for two cubes
        {
            calculateAverageAmplitude();
            background(0);
            noFill();
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
        else if(fourspheres)//if statement for four cubes
        {
            calculateAverageAmplitude();
            background(0);
            noFill();
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
            stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
            camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
            translate(0, 0, -300);
            rotateY(angle);
            rotateX(angle);
            strokeWeight(1);            
            sphere(smoothedBoxSize);
        }
        angle += getAmplitude() / 8.0f;//change in angle of spheres
    }
    float angle = 0;
    }