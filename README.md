# AppIntroAnimation
AppIntroAnimation is a set of code snippets to make cool intro screen for your app with special Image Translation and Transformation animation effects. It is very easy to use and customize without adding third party library integrations.

![appintro1](https://cloud.githubusercontent.com/assets/11768239/9006453/ed88bc78-37a4-11e5-9052-b8bc98678906.gif)


![appintro2](https://cloud.githubusercontent.com/assets/11768239/9006455/f2d9f3a4-37a4-11e5-8e91-092e77ca1da7.gif)


How to use
----------

> **STEP 1:** Download the code and open `arrays.xml`.

<?xml version="1.0" encoding="utf-8"?>
<resources>
 
    <array name="landing_bg">
        <item>@color/light_green</item>
        <item>@color/light_purple</item>
        <item>@color/light_orange</item>
        <item>@color/light_cyan</item>
    </array>
 
    <array name="icons">
        <item>@drawable/email</item>
        <item>@drawable/calendar</item>
        <item>@drawable/shopping</item>
        <item>@drawable/socialnetwork</item>
    </array>

    <string-array name="titles" >
        <item>@string/email</item>
        <item>@string/calender</item>
        <item>@string/shopping</item>
        <item>@string/social_network</item>
    </string-array>
 
    <string-array name="hints" >
        <item>@string/email_hint</item>
        <item>@string/calender_hint</item>
        <item>@string/shopping_hint</item>
        <item>@string/social_network_hint</item>
    </string-array>
</resources>

Here I have added 4 slides with images, titles and title hints. You can update your png's, text content in above arrays.xml as per your project need and requirement.

> **Note:** The array count of images, titles and title hints should be of same count to avoid IndexBoundException.



> **STEP 2:** Drop all your images that are to be used for making AppIntro's into drawable folders. To get exact output for multiple resolution and sizes, add scaled images seperately for drawable-xxxhdpi, drawable-xxhdpi, drawable-xhdpi, drawable-hdpi, drawable-mdpi,etc.

