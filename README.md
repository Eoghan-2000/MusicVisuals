# Music Visualiser Project

Name: Eoghan Martin

Student Number: C18342116

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
The goals of the assignment was to create a number of visuals that react to music. I chose to use a Royalty-free song that i found on [hyperlink](https://music.tutsplus.com/tutorials/15-must-have-royalty-free-house-music-tracks--cms-33510) called robotsinparis. I chose this because I thought it would work really well with a lot of the visuals because the music was very loud and the audio response would be greater. The next step of the project was creating the visuals using help from the notes in class and research online I created a number of visuals that each are unique in their own way. I had five main visual files, some splitting into different visuals when you press certain buttons:

- firstVisual, To create this sphere visual which splits into two spheres or four depending on what buttons you press, I used the started code and tweeked different parts of it to adapt to what I wanted to make.
- secondVisual, which is a cube visual where used audio bands to create different cubes within eachother that all react to the music. the cube around the center rotates in a circle, this cube then splits above and below into three cubes that will continue to circle around the main center cube.
- linesVisual, was a visual i created using the same concept as one of the designs we made in class, I decided i wanted to create the same effect but in a 3D way in a circle. 
- linesVisual2, is a concept that started out to be a 2d concept of using samples to create lines reacting to audio in different areas aroudn the screen but i ended up making it 3D and adding this cube visual that I discovered while playing around with some code.
- expanding, taking the same visual from the previous code i decided to create a bigger visual by increasing the numbers for the boxsize, to create what I think is my favourite visual of the project. Unlike the first cube visual i made this uses sampling to adjust the box size for each sample and i then rotated the box to make a really interesting effect.

After creating the visuals the next step was to create the Music video. I did this using Imovie to edit each seperate video into one big video that transitions smoothly into different visuals. I then uploaded the video onto youtube which you can find with this link [hyperlink](https://www.youtube.com/watch?v=JWY_o8ROg2w)
# Instructions
I used different files for each visual so in order to display them they have to be ran seperately one at a time. In my main I have put all the calls to the different visuals and have them commented out so that only one visual runs at a time. To see how the different visuals react you need to comment the visual currently runnning and uncomment the one you want to see. In my firstVisual and secondVisual I have key pressed methods that allow the user to toggle between different variations of the visual. in the first visual, there are three different parts to it. the default visual is the single sphere, to toggle to two spheres or four, you need ot press the keys one or two, to toggle between them. The same goes for the secondVisual. When you press the key one. It will toggle between the three cubes circling and the one. As for all the rest of the files all of them will start the music as soon as the audio file loads and the visual will start. 

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

The box size will be calculated based on current amplitude times 300, in order to make the sphere big enough

## secondVisual

## linesVisual

## linesVisual2

## expanding

# What I am most proud of in the assignment

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

