package com.takeoffandroid.appintroanimation;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;



import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity{

    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    private ViewPager mViewPager;
    private CirclePageIndicator mIndicator;
    private Typeface mFontDark,mFontLight;
    private PagerAdapter adapter;
    private int[] imgSlide,colorBg;
    private String[] txtTitle, txtHint;
    private RelativeLayout landingBackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_main);

        findViews();

        colorBg = getResources().getIntArray(R.array.landing_bg);


        imgSlide = new int[] {R.drawable.email,
                R.drawable.calendar,  R.drawable.shopping, R.drawable.socialnetwork};

        txtHint = new String[] {"A system for sending and receiving messages electronically over a computer network.","Note all your special ocassions in calendar and keep them in your finger tips","Shop and get offers, promo codes and discounts on your future purchase.","Stay connected with your friends, colleagues and family globally"};
        txtTitle = new String[] {"EMAIL","CALENDAR","SHOPPING","SOCIAL NETWORK"};

        adapter = new ViewPagerAdapter(MainActivity.this,imgSlide, txtTitle, txtHint);
        mViewPager.setAdapter(adapter);
        mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(mViewPager);

        mViewPager.setPageTransformer(true, new CustomPageTransformer());

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() - 1) && position < (colorBg.length - 1)) {

                    landingBackground.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colorBg[position], colorBg[position + 1]));

                } else {

                    // the last page color
                    landingBackground.setBackgroundColor(colorBg[colorBg.length - 1]);

                }


            }

            @Override
            public void onPageSelected(final int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void findViews() {
        landingBackground = (RelativeLayout)findViewById(R.id.landing_backgrond);
        mViewPager = (ViewPager)findViewById(R.id.pager);
        mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
    }

    public class ViewPagerAdapter extends PagerAdapter {
        // Declare Variables
        private Context context;

        private int[] imgSlide;
        private String[] txtTitle, txtHint;
        private LayoutInflater inflater;

        public ViewPagerAdapter(Context context, int[] imgSlide, String[] txtTitle, String[] txtHint) {
            this.context = context;

            this.imgSlide = imgSlide;
            this.txtTitle = txtTitle;
            this.txtHint = txtHint;
        }

        @Override
        public int getCount() {
            return imgSlide.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((RelativeLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ImageView imgflag;
            TextView landtxtTitle, landtxtHint;
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView = inflater.inflate(R.layout.viewpager_item, container,
                    false);
            imgflag = (ImageView) itemView.findViewById(R.id.landing_img_slide);
            landtxtTitle = (TextView)itemView.findViewById(R.id.landing_txt_title);
            landtxtHint = (TextView)itemView.findViewById(R.id.landing_txt_hint);
            imgflag.setImageResource(imgSlide[position]);
            landtxtTitle.setTypeface(mFontDark);
            landtxtHint.setTypeface(mFontLight);
            landtxtTitle.setText(txtTitle[position]);
            landtxtHint.setText(txtHint[position]);
            ((ViewPager) container).addView(itemView);
            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((RelativeLayout) object);

        }
    }
    public class CustomPageTransformer implements ViewPager.PageTransformer {


        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            View imageView = view.findViewById(R.id.landing_img_slide);
            View contentView = view.findViewById(R.id.landing_txt_hint);
            View txt_title = view.findViewById(R.id.landing_txt_title);

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left
            } else if (position <= 0) { // [-1,0]
                // This page is moving out to the left

                // Counteract the default swipe
                view.setTranslationX(pageWidth * -position);
                if (contentView != null) {
                    // But swipe the contentView
                    contentView.setTranslationX(pageWidth * position);
                    txt_title.setTranslationX(pageWidth * position);

                    contentView.setAlpha(1 + position);
                    txt_title.setAlpha(1 + position);
                }

                if (imageView != null) {
                    // Fade the image in
                    imageView.setAlpha(1 + position);
                }

            } else if (position <= 1) { // (0,1]
                // This page is moving in from the right

                // Counteract the default swipe
                view.setTranslationX(pageWidth * -position);
                if (contentView != null) {
                    // But swipe the contentView
                    contentView.setTranslationX(pageWidth * position);
                    txt_title.setTranslationX(pageWidth * position);
                    contentView.setAlpha(1 - position);
                    txt_title.setAlpha(1 - position);

                }
                if (imageView != null) {
                    // Fade the image out
                    imageView.setAlpha(1 - position);
                }

            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                finish();
            }
        }

    }



    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
    }




}// End of Activity

