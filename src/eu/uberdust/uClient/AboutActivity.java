package eu.uberdust.uClient;



import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;

public class AboutActivity extends SherlockActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        LinearLayout mainContainer = (LinearLayout) findViewById(R.id.mainContainer);
        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(AboutActivity.this, R.anim.main_layout_animation);
        mainContainer.setLayoutAnimation(controller);
    }
    
    public void onImage(View v){
    	AnimationSet animationSet = new AnimationSet(true);
    	
    	RotateAnimation rotateAnimation = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    	rotateAnimation.setDuration(500);
    	rotateAnimation.setRepeatCount(2);
    	
    	animationSet.addAnimation(rotateAnimation);
    	
    	TranslateAnimation translateAnimation = new TranslateAnimation(0, 400, 0, 0);
    	
    	//setting offset and duration to start after first rotation completed, and end at the same time with the last roration
    	translateAnimation.setStartOffset(500);
    	translateAnimation.setDuration(1000);
    	
    	animationSet.addAnimation(translateAnimation);
    	
    	AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
    	alphaAnimation.setStartOffset(500);
    	alphaAnimation.setDuration(1000);
    	
    	animationSet.addAnimation(alphaAnimation);

    	v.startAnimation(animationSet);
    }
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	getSupportMenuInflater().inflate(R.menu.activity_about, menu);
        return true;
    }
}
