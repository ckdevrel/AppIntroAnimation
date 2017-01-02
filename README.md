[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AppIntroAnimation-brightgreen.svg?style=flat)](http://android-arsenal.com/details/3/2226)

<a href='https://ko-fi.com/A302HW7' target='_blank'><img height='36' style='border:0px;height:36px;' src='https://az743702.vo.msecnd.net/cdn/kofi4.png?v=f' border='0' alt='Buy Me a Coffee at ko-fi.com' /></a> 

# AppIntroAnimation
AppIntroAnimation is a set of code snippets to make cool intro screen for your app with special Image Translation and Transformation animation effects. It is very easy to use and customize without adding third party library integrations.

 Demo I |      Demo II
-------- | ---
![appintro1](https://cloud.githubusercontent.com/assets/11768239/9027657/600244d6-397b-11e5-916f-409d4ab3de28.gif) | ![appintro2](https://cloud.githubusercontent.com/assets/11768239/9027658/6009bae0-397b-11e5-9377-78abe437ff7d.gif)
 
 > **Demo I** Enable `private boolean isSliderAnimation = false;` in `MainActivity.java` to apply this background pager transformation animation with Image translation effect..
 
 > **Demo II** Enable `private boolean isSliderAnimation = true;` in `MainActivity.java` to apply this background pager transformation animation without Image translation effect..
 


How to use
----------

 **STEP 1**: 
 
 Download the code and open `arrays.xml`.

    <?xml version="1.0" encoding="utf-8"?>
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

Here I have added 4 slides with images, titles and title hints. You can update your png's, text content in above arrays.xml as per your project need and requirement.


> **Note:** The array count of images, titles and title hints should be of same count to avoid IndexBoundException.



 **STEP 2**:  
 
Drop all your images that are to be used for making AppIntro's into drawable folders. To get exact output for multiple resolution and sizes, add scaled images seperately for drawable-xxxhdpi, drawable-xxhdpi, drawable-xhdpi, drawable-hdpi, drawable-mdpi etc., and fix the height and width of ImageView in `viewpager_item.xml`

Customization
-------------

To customize pager attributes like indicator stroke size, stroke color, solid color, solid size, solid color, selected color and unselected color, please open `vpi_defaults.xml` and customize according to your wish.

Following are the attributes that I have used in my project demo, you can also customize your own.

    <resources>
        <bool name="default_circle_indicator_centered">true</bool> 
        <color name="default_circle_indicator_fill_color">#FFFFFFFF</color>  <!--change fill color-->
        <color name="default_circle_indicator_page_color">#40FFFFFF</color>  <!--change indicator un selected fill color-->
        <integer name="default_circle_indicator_orientation">0</integer> 
        <dimen name="default_circle_indicator_radius">3dp</dimen> <!--change radius of the circle-->
        <bool name="default_circle_indicator_snap">false</bool> 
        <color name="default_circle_indicator_stroke_color">#40FFFFFF</color> <!--change stroke color-->
        <dimen name="default_circle_indicator_stroke_width">1dp</dimen> <!--change stroke width-->
    </resources>

The app which inspired me to create this repos

> - Background color transformation animation used in [Google Inbox][1] intro screen.
> - Image translation animation used in [Duolingo][2] intro screen.

  [1]: https://play.google.com/store/apps/details?id=com.google.android.apps.inbox
  [2]: https://play.google.com/store/apps/details?id=com.duolingo



