# Music Visualiser Project

Name: Eoghan Martin

Student Number: C18342116

# Description of the assignment
The goals of the assignment was to create a number of visuals that react to music. I chose to use a Royalty-free song that i found on [hyperlink](https://music.tutsplus.com/tutorials/15-must-have-royalty-free-house-music-tracks--cms-33510) called robotsinparis. I chose this because I thought it would work really well with a lot of the visuals because the music was very loud and the audio response would be greater. The next step of the project was creating the visuals using help from the notes in class and research online I created a number of visuals that each are unique in their own way. I had five main visual files, some splitting into different visuals when you press certain buttons:

- firstVisual, To create this sphere visual which splits into two spheres or four depending on what buttons you press, I used the started code and tweeked different parts of it to adapt to what I wanted to make.
- secondVisual, which is a cube visual where used audio bands to create different cubes within eachother that all react to the music. the cube around the center rotates in a circle, this cube then splits above and below into three cubes that will continue to circle around the main center cube.
- linesVisual, was a visual i created using the same concept as one of the designs we made in class, I decided i wanted to create the same effect but in a 3D way in a circle. 
- linesVisual2, is a concept that started out to be a 2d concept of using samples to create lines reacting to audio in different areas aroudn the screen but i ended up making it 3D and adding this cube visual that I discovered while playing around with some code.
- expanding, taking the same visual from the previous code i decided to create a bigger visual by increasing the numbers for the boxsize, to create what I think is my favourite visual of the project. Unlike the first cube visual i made this uses sampling to adjust the box size for each sample and i then rotated the box to make a really interesting effect.

After creating the visuals the next step was to create the Music video. I did this using Imovie to edit each seperate video into one big video that transitions smoothly into different visuals. I then uploaded the video onto youtube which you can find with this link [hyperlink](https://www.youtube.com/watch?v=JWY_o8ROg2w)

# Instructions
I used different files for each visual so in order to display them they have to be ran seperately one at a time. In my main I have put all the calls to the different visuals and have them commented out so that only one visual runs at a time. To see how the different visuals react you need to comment the visual currently runnning and uncomment the one you want to see. In my firstVisual and secondVisual I have key pressed methods that allow the user to toggle between different variations of the visual. in the first visual, there are three different parts to it. the default visual is the single sphere, to toggle to two spheres or four, you need ot press the keys one or two, to toggle between them. The same goes for the secondVisual. When you press the key one. It will toggle between the three cubes circling and the one. As for all the rest of the files all of them will start the music as soon as the audio file loads and the visual will start, if you press the space key it will restart the music from the start.

# How it works

## firstVisual
```Java
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
```
The first visual uses this code that was in the starter code to create a sphere that reacts to audio rather than a cube. This code is in an if statement which determines what variation of the visual will be displayed. This is the default code for the program and it is a single sphere. When a button is pressed it will change the different booleans twospheres and fourspheres to trigger the variation in the visual, if twospheres changes this code above will be duplicated expect it will use translate to change the positioning of both of the spheres. Likewise with the fourspheres boolean this code will be quadroopled and translate will be used to adjust positioning.

```Java
float boxSize = 50 + (getAmplitude() * 300);//get box size using amplitude
smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);        
```

The box size will be calculated based on current amplitude times 300, in order to make the sphere big enough.

## secondVisual

The second visual uses audio bands to create boxes within eachother that each react to the music depending on the audio bands frequency. It will get the frequency of each band and it will put the this into a float array that will carry all the current frequencies of the audio bands of the song. 

```Java 
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
```

Each band will be set to a different colour using mapping function and depending on whether the one key is pressed it will display two different variations of the visual. The first visual will create to boxes. The first one is int the code above, by using the translate function I created identical boxes beside the main box that will rotate around it. If the key one is pressed the boolean seperate will be changed and it will cause the another two cube visuals above and below the box circling, by using the translate function. Each Cube will have other cubes within each other by using a for loop to get each band frequency and setting the size of the box to this. Everytime the draw function gets called it will increase the rotate variable and will cause each of the cubes to rotate in a circlular motion.

## linesVisual

This visual will using sampling to get an array of samples and will get this bands frequencies and will use this frequency to give the length of the line I planned to create. To make this work the way I wanted I had to research how to find points in a circle when you have the radius and the number in radians of which I wanted to plot the line. 

```Java
float x1,x2,y1,y2,z1,z2 =0;//sets all line co-ordinates to be 0n
		for(int i = 0 ; i < numSamples ; i ++)//for loop to loop through samples
		{
			strokeWeight(5);
			float c = map(i,0,numSamples,0,255); //maps out colours based on number of samples
			stroke(c, 255, 255);
			float t = map(i,0,numSamples,0,360);//gets which number sample it is and maps it from 0 to 360 degrees
			lerpedSamples[i] = lerp(lerpedSamples[i], fft.getBand(i), 0.2f);
			//formulas to get the cordinates on the circle equally matched to the number of samples
			z1 = radius * cos(t) - width/2;
			z2 = radius * cos(t) - width/2;
			x1 = radius * sin(t) +width/2;
			x2 = radius * sin(t) +width/2;
			y1=0;
			//the size of the current samples size
			y2 =lerpedSamples[i] * 100;
			line(x1, y1,z1,x2,y2,z2);

		}
```
Since this is a 3D visual I needed 6 cordinates and i initiallised them all to 0. The for loop will then loop through the amount of samples, in my case I chose 100. It will then declare a float t, it will initialise this variable to be the mapped number in radians depending on what sample it is. Then it will use the formulas and use this number in radians and the radius to get the cordinates where each line would be placed on the circle. Next it will get the sample at i and set it to y2 in order for the lines to react to the music.

## linesVisual2

This visual is a visual that uses lines and a boxes using sampling. 
```Java 
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
```

I used two for loops to create the lines coming from the left and right of the screen. I had to use two sets of cordinates for this. The left side co-ordinates and the right side co-ordinates. For the left side the x1 will be set to 0 because it comes from the left side of the screen and the y1 will be mapped using the map function along the height of the sketch. The x2 and y2 the will be created by getting the size of the current sample, the y2 will do the same but it will use the y1 cordinate in order for the lines to be straight. The same will happen on the right side for loop except it will use the width of the screen to start on the right side of the screen.

```Java
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
```

The next for loop will use the samples to create boxes. it will get the Sample Size and multiply it by 5 to create the box size. It will then map the colour based on the samples. I translated the box to be in the middle of the screen using the translate function. The box will be rotated by a variable angle which gets incremented outside the loop everytime using one of the samples. This will make the box increase in size with the music but also rotate at the same time. 

## expanding

The final visual I made uses the same code from the cube in the last visual but I wanted to make it really big so you could see the samples even better as boxes. 

```Java
 for(int i =0 ;i<numSamples; i++)
        {
            lerpedSamples[i] = lerp(lerpedSamples[i], fft.getBand(i), 0.5f);
            pushMatrix();
            //creating box size based on the samples at i
            float boxSize = 50 + (lerpedSamples[i]*100); 
            smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);       		
            noFill();
            //creates stroke colour based on the number sample it is at
            stroke(map(i, 0, numSamples, 0, 255), 255, 255);
            //places the cube in the middle of the screen
            translate(width/2, height/2, 0);
            //rotates the cube based on the angle variable that increases below the for loop everytime
            rotateY(angle);
            rotateX(angle);
            strokeWeight(1);            
            box(smoothedBoxSize);
            popMatrix();
            
        }
		angle += lerpedSamples[50]/ 100.0f;
```

I increased the size of the cube by increase the amount i multiplied the sample by for the variable smoothedBoxSize.

# What I am most proud of in the assignment

There is a lot of things that I am proud of in this assignment, but I think the thing I am most proud of is the linesVisual that uses formulas to get points in a circle. I had this Idea initially and thought it would be so easy to do but then soon figured out that there was no way to just get the points in a circle. So I did some research and found formulas to find the co-ordinates and tweaked it find each point, it was great practice for computational thinking and was great experience that I will take with me

This is the youtube video with all the visuals:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=JWY_o8ROg2w)