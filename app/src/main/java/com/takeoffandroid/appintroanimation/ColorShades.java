package com.takeoffandroid.appintroanimation;

import android.graphics.Color;


/**
 *
 * Source from : https://gist.github.com/cooltechworks/4f37021b1216f773daf8
 * Color shades will provide all the intermediate colors between two colors. It just requires a decimal value between 0.0 to 1.0
 * and it provides the exact shade combination of the two color with this shade value.
 *
 *  Textual explanation :
 *
 *      |===============|===============|===============|===============|
 *     White          LtGray          Gray            DkGray           Black
 *
 *     0                0.25            0.5             0.75            1
 *
 *     Given two colors as White and Black,
 *     and shade
 *          as 0    gives White
 *          as 0.25 gives Light gray
 *          as 0.5  gives Gray
 *          as 0.75 gives Dark gray
 *          as 1    gives Black.
 *
 */
public class ColorShades {

    private int mFromColor;
    private int mToColor;
    private float mShade;

    public ColorShades setFromColor(int fromColor) {
        this.mFromColor = fromColor;
        return this;
    }

    public ColorShades setToColor(int toColor) {
        this.mToColor = toColor;
        return this;
    }

    public ColorShades setFromColor(String fromColor) {

        this.mFromColor = Color.parseColor(fromColor);
        return this;
    }

    public ColorShades setToColor(String toColor) {
        this.mToColor = Color.parseColor(toColor);
        return this;
    }

    public ColorShades forLightShade(int color) {
        setFromColor(Color.WHITE);
        setToColor(color);
        return this;
    }

    public ColorShades forDarkShare(int color) {
        setFromColor(color);
        setToColor(Color.BLACK);
        return this;
    }

    public ColorShades setShade(float mShade) {
        this.mShade = mShade;
        return this;
    }


    /**
     * Generates the shade for the given color.
     * @return the int value of the shade.
     */
    public int generate() {

        int fromR = (Color.red(mFromColor));
        int fromG = (Color.green(mFromColor));
        int fromB = (Color.blue(mFromColor));

        int toR = (Color.red(mToColor));
        int toG = (Color.green(mToColor));
        int toB = (Color.blue(mToColor));

        int diffR = toR - fromR;
        int diffG = toG - fromG;
        int diffB = toB - fromB;



        int R = fromR + (int) (( diffR * mShade));
        int G = fromG + (int) (( diffG * mShade));
        int B = fromB + (int) (( diffB * mShade));

        return  Color.rgb(R, G, B);

    }


    /**
     * Assumes the from and to color are inverted before generating the shade.
     * @return the int value of the inverted shade.
     */
    public int generateInverted() {

        int fromR = (Color.red(mFromColor));
        int fromG = (Color.green(mFromColor));
        int fromB = (Color.blue(mFromColor));

        int toR = (Color.red(mToColor));
        int toG = (Color.green(mToColor));
        int toB = (Color.blue(mToColor));


        int diffR = toR - fromR;
        int diffG = toG - fromG;
        int diffB = toB - fromB;

        int R = toR - (int) (( diffR * mShade));
        int G = toG - (int) (( diffG * mShade));
        int B = toB - (int) (( diffB * mShade));

        return  Color.rgb(R, G, B);

    }

    /**
     * Gets the String equivalent of the generated shade
     * @return String value of the shade
     */
    public String generateInvertedString() {
        return String.format("#%06X", 0xFFFFFF & generateInverted());
    }

    /**
     * Gets the inverted String equivalent of the generated shade
     * @return String value of the shade
     */
    public String generateString() {
        return String.format("#%06X", 0xFFFFFF & generate());
    }

}