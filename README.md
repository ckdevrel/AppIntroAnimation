# AppIntroAnimation
AppIntroAnimation is a set of code snippets to make cool intro screen for your app with special Image Translation and Transformation animation effects. It is very easy to use and customize without adding third party library integrations.

ImageTranslation with BackgroundColor Transformation Animation

![appintro1](https://cloud.githubusercontent.com/assets/11768239/9006453/ed88bc78-37a4-11e5-9052-b8bc98678906.gif)

Simple BackgroundColor Transformation Animation

![appintro2](https://cloud.githubusercontent.com/assets/11768239/9006455/f2d9f3a4-37a4-11e5-8e91-092e77ca1da7.gif)


How to use
----------

 **STEP 1**: 
 
 -Download the code and open `arrays.xml`.
...
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
...

Here I have added 4 slides with images, titles and title hints. You can update your png's, text content in above arrays.xml as per your project need and requirement.

> **Note:** The array count of images, titles and title hints should be of same count to avoid IndexBoundException.



 **STEP 2**:  
 
 -Drop all your images that are to be used for making AppIntro's into drawable folders. To get exact output for multiple resolution and sizes, add scaled images seperately for drawable-xxxhdpi, drawable-xxhdpi, drawable-xhdpi, drawable-hdpi, drawable-mdpi etc., and fix the height and width of ImageView in `viewpager_item.xml`

Customization
-------------

To customize pager attributes like indicator stroke size, stroke color, solid color, solid size, solid color, selected color and unselected color, please open `vpi_defaults.xml` and customize according to your wish.

Following are the attributes that I have used in my project demo, you also customize your own.
...
<dimen name="default_line_indicator_line_width">12dp</dimen>
<dimen name="default_line_indicator_gap_width">4dp</dimen>
<dimen name="default_line_indicator_stroke_width">3dp</dimen>
<color name="default_line_indicator_selected_color">#FF33B5E5</color>
<color name="default_line_indicator_unselected_color">#FFBBBBBB</color>
<bool name="default_line_indicator_centered">true</bool>

<dimen name="default_title_indicator_clip_padding">4dp</dimen>
<color name="default_title_indicator_footer_color">#FF33B5E5</color>
<dimen name="default_title_indicator_footer_line_height">2dp</dimen>
<integer name="default_title_indicator_footer_indicator_style">2</integer>
<dimen name="default_title_indicator_footer_indicator_height">4dp</dimen>
<dimen name="default_title_indicator_footer_indicator_underline_padding">20dp</dimen>
<dimen name="default_title_indicator_footer_padding">7dp</dimen>
<integer name="default_title_indicator_line_position">0</integer>
<color name="default_title_indicator_selected_color">#FFFFFFFF</color>
<bool name="default_title_indicator_selected_bold">true</bool>
<color name="default_title_indicator_text_color">#BBFFFFFF</color>
<dimen name="default_title_indicator_text_size">15dp</dimen>
<dimen name="default_title_indicator_title_padding">5dp</dimen>
<dimen name="default_title_indicator_top_padding">7dp</dimen>

<bool name="default_underline_indicator_fades">true</bool>
<integer name="default_underline_indicator_fade_delay">300</integer>
<integer name="default_underline_indicator_fade_length">400</integer>
<color name="default_underline_indicator_selected_color">#FF33B5E5</color>
...

