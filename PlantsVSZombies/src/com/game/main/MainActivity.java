package com.game.main;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import com.game.global.Config;
import com.game.newgame.R;
import com.game.tools.DeviceTools;
import com.game.view.GameView;
/**
 * 		
 * @author 泡泡 807603044
 *
 */
public class MainActivity extends Activity {
	private GameView gameView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
		gameView = new GameView(this);
		setContentView(gameView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void init(){	//初始化
		requestWindowFeature(Window.FEATURE_NO_TITLE);		//隐藏标题
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
		
	
		
		Config._sun = 1000;
		Config.deviceWidth = DeviceTools.getDeviceInfo(this)[0];	//获取设备宽度
		Config.deviceHeight = DeviceTools.getDeviceInfo(this)[1];	//获取设备高度
		Config.back = BitmapFactory.decodeResource(getResources(), R.drawable.bk);	//初始化背景图片
		Config.scaleHeight = Config.deviceHeight / (float) Config.back.getHeight();	//获取缩放比例
		Config.scaleWidth = Config.deviceWidth / (float) Config.back.getWidth();
		Config.back = DeviceTools.resizeBitmap(Config.back);	//调整到合适的大小 
		Config.seedBank = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.seedbank));
		Config.sun = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sun));
		Config.bullet = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bullet));
		
		
		//图片较大,做了二次处理
		Config.seedFlower = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.seed_flower),Config.seedBank.getWidth()/8,Config.seedBank.getHeight()-20);
		Config.seedPea = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.seed_pea),Config.seedBank.getWidth()/8,Config.seedBank.getHeight()-20);
		Config.seedWallNut = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wallnul),Config.seedBank.getWidth()/8,Config.seedBank.getHeight()-20);
		
		Config.sunflower[0] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower01));
		Config.sunflower[1] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower02));
		Config.sunflower[2] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower03));
		Config.sunflower[3] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower04));
		Config.sunflower[4] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower05));
		Config.sunflower[5] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower06));
		Config.sunflower[6] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower07));
		Config.sunflower[7] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower08));
		Config.sunflower[8] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower09));
		Config.sunflower[9] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower10));
		Config.sunflower[10] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower11));
		Config.sunflower[11] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower12));
		Config.sunflower[12] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower13));
		Config.sunflower[13] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower14));
		Config.sunflower[14] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower15));
		Config.sunflower[15] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower16));
		Config.sunflower[16] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower17));
		Config.sunflower[17] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sunflower18));
		
		Config.peater[0] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.peater1));
		Config.peater[1] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.peater2));
		Config.peater[2] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.peater3));
		Config.peater[3] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.peater4));
		Config.peater[4] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.peater5));
		Config.peater[5] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.peater6));
		Config.peater[6] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.peater7));
		Config.peater[7] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.peater8));
		Config.peater[8] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.peater9));
		Config.peater[9] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.peater10));
		Config.peater[10] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.peater11));
		Config.peater[11] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.peater12));
		Config.peater[12] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.peater13));
		
		Config.rePeater[0] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.repeater01));
		Config.rePeater[1] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.repeater02));
		Config.rePeater[2] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.repeater03));
		Config.rePeater[3] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.repeater04));
		Config.rePeater[4] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.repeater05));
		Config.rePeater[5] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.repeater06));
		Config.rePeater[6] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.repeater07));
		Config.rePeater[7] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.repeater08));
		Config.rePeater[8] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.repeater09));
		Config.rePeater[9] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.repeater10));
		Config.rePeater[10] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.repeater11));
		Config.rePeater[11] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.repeater12));
		Config.rePeater[12] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.repeater13));
		Config.rePeater[13] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.repeater14));
		Config.rePeater[14] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.repeater15));
		
		Config.wallnut[0] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wallnut01));
		Config.wallnut[1] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wallnut02));
		Config.wallnut[2] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wallnut03));
		
		
		//僵尸
		Config.zombie[0] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie01));
		Config.zombie[1] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie02));
		Config.zombie[2] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie03));
		Config.zombie[3] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie04));
		Config.zombie[4] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie05));
		Config.zombie[5] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie06));
		Config.zombie[6] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie07));
		Config.zombie[7] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie08));
		Config.zombie[8] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie09));
		Config.zombie[9] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie10));
		Config.zombie[10] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie11));
		Config.zombie[11] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie12));
		Config.zombie[12] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie13));
		Config.zombie[13] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie14));
		Config.zombie[14] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie15));
		Config.zombie[15] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie16));
		Config.zombie[16] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie17));
		Config.zombie[17] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie18));
		Config.zombie[18] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie19));
		Config.zombie[19] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie20));
		Config.zombie[20] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie21));
		Config.zombie[21] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie22));
		Config.zombie[22] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie23));
		Config.zombie[23] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie24));
		Config.zombie[24] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie25));
		Config.zombie[25] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie26));
		Config.zombie[26] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie27));
		Config.zombie[27] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie28));
		Config.zombie[28] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie29));
		Config.zombie[29] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie30));
		Config.zombie[30] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.zombie31));
		
		
		Config.ConeheadZombie[0] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie01));
		Config.ConeheadZombie[1] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie02));
		Config.ConeheadZombie[2] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie03));
		Config.ConeheadZombie[3] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie04));
		Config.ConeheadZombie[4] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie05));
		Config.ConeheadZombie[5] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie06));
		Config.ConeheadZombie[6] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie07));
		Config.ConeheadZombie[7] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie08));
		Config.ConeheadZombie[8] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie09));
		Config.ConeheadZombie[9] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie10));
		Config.ConeheadZombie[10] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie11));
		Config.ConeheadZombie[11] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie12));
		Config.ConeheadZombie[12] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie13));
		Config.ConeheadZombie[13] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie14));
		Config.ConeheadZombie[14] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie15));
		Config.ConeheadZombie[15] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie16));
		Config.ConeheadZombie[16] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie17));
		Config.ConeheadZombie[17] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie18));
		Config.ConeheadZombie[18] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie19));
		Config.ConeheadZombie[19] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie20));
		Config.ConeheadZombie[20] = DeviceTools.resizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.coneheadzombie21));
		
	
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO 自动生成的方法存根
		
		return gameView.onTouchEvent(event);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO 自动生成的方法存根
		if(keyCode == KeyEvent.KEYCODE_BACK){
			finish();
		}
		
		
		
		return super.onKeyDown(keyCode, event);
	}
	
	

}
