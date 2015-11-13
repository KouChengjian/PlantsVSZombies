package com.game.view;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;

import com.game.antity.AnfangPea;
import com.game.antity.Bullet;
import com.game.antity.Card;
import com.game.antity.ConeheadZombie;
import com.game.antity.Pea;
import com.game.antity.Sun;
import com.game.antity.SunFlower;
import com.game.antity.WallNut;
import com.game.antity.Zombie;
import com.game.antity.ZombieMannger;
import com.game.global.Config;
import com.game.model.BaseModel;
import com.game.model.Plants;
import com.game.model.TouchAble;
import com.game.model.Zombies;

public class GameView extends View  {
	private Paint paint;
	private SurfaceHolder surfaceHolder;	//容器?
	private Context context;
	private boolean[][] cell;	//格子*****用来保存格子中是否有植物 
	private ZombieMannger zombieMannger;
	private Canvas bkCanvas;
	
	
	private static GameView gameView; 
	private ArrayList<BaseModel> deadList;
	private ArrayList<BaseModel> gameLayout2;
	private ArrayList<BaseModel> gameLayout1;
	private ArrayList<BaseModel> gameLayout3;
	
	
	private ArrayList<ArrayList<Plants>> gameLayout4plant;
	
	
	private ArrayList<ArrayList<BaseModel>> gameLayout4bullet;
	private ArrayList<ArrayList<Zombies>> gameLayout4zombie;
	
	
	public GameView(Context context) {
		super(context);
		// TODO 自动生成的构造函数存根
		this.context = context;
		paint = new Paint();
		gameView = this;
		Config.sunDeadLocationX = (Config.deviceWidth-Config.seedBank.getWidth())/2;
		
		createElement();
		
	}
	//初始化
	private void createElement() {
		// TODO 自动生成的方法存根
		
		//阳光收集的终点坐标
		
		
		
		zombieMannger = new ZombieMannger();
		Config.sunDeadLocationX = (Config.deviceWidth-Config.seedBank.getWidth())/2;
		gameLayout2 = new ArrayList<BaseModel>();
		Card seedFlower = new Card((Config.deviceWidth-Config.seedBank.getWidth()) / 2
				+ Config.seedBank.getWidth() / 7 + Config.deviceHeight / 30
				,Config.deviceHeight / 80,Config.c_flower);
		Card seedPea = new Card((Config.deviceWidth-Config.seedBank.getWidth()) / 2
				+ Config.seedBank.getWidth() / 7 * 2 + Config.deviceHeight / 30
				,Config.deviceHeight / 80,Config.c_pea);
		
		Card seedWallNut = new Card((Config.deviceWidth-Config.seedBank.getWidth()) / 2
				+ Config.seedBank.getWidth() / 7 * 3 + Config.deviceHeight / 30
				,Config.deviceHeight / 80,Config.c_wallnut);
		
		
		gameLayout2.add(seedFlower);
		gameLayout2.add(seedPea);
		gameLayout2.add(seedWallNut);
		
		gameLayout1 = new ArrayList<BaseModel>();
		gameLayout3 = new ArrayList<BaseModel>();
		deadList = new ArrayList<BaseModel>(); 
		
		cell = new boolean[9][5];
		
		gameLayout4plant = new ArrayList<ArrayList<Plants>> ();
		gameLayout4bullet = new ArrayList<ArrayList<BaseModel>> ();
		gameLayout4zombie = new ArrayList<ArrayList<Zombies>> ();
		
		
		for(int i = 0; i < 5;i++){
			ArrayList<Plants> list = new ArrayList<Plants> ();
			gameLayout4plant.add(list);
			
			
			
			
			
			ArrayList<BaseModel> list1 = new ArrayList<BaseModel> ();
			gameLayout4bullet.add(list1);
			ArrayList<Zombies> list2 = new ArrayList<Zombies> ();
			gameLayout4zombie.add(list2);
		}
		
		
		
		
		int x = 0,y = 0;
		Config.map = new Rect[9][5];
		for(int i = 0;i < 5;i++){
			for(int j = 0; j < 9; j++){
				x = (j +2) * Config.deviceWidth / 11
						- Config.deviceWidth / 11 / 2;
 				y = (i + 1) * Config.deviceHeight / 6
 						- Config.deviceHeight / 6 /4;
 				cell[j][i] = false;
				
				Config.map[j][i] = new Rect(x, y, x+Config.deviceWidth / 11, y+Config.deviceHeight / 6);
				
			}
			
			
		}
		
		
		
	}
	//更新数据
	private void updataData(){	//更新数据
		deadList.clear();
		
		for (BaseModel model : gameLayout2){
			if(!model.isAlive()){
				deadList.add(model);
			}
			
		}
		for (BaseModel model : gameLayout1){
			if(!model.isAlive()){
				deadList.add(model);
			}
		}
		for (BaseModel model : gameLayout3){
			if(!model.isAlive()){
				deadList.add(model);
			}
		}
		
		for (ArrayList<Plants> model1 : gameLayout4plant){
			for (Plants model : model1){
				if(!model.isAlive()){
					deadList.add(model);
				}
			}
		}
		
		
		
		for (ArrayList<BaseModel> model1 : gameLayout4bullet){
			for (BaseModel model : model1){
				if(!model.isAlive()){
					deadList.add(model);
				}
			}
		}
		
		
		for (ArrayList<Zombies>  model1 : gameLayout4zombie){
			for (Zombies  model : model1){
				if(!model.isAlive()){
					deadList.add(model);
				}
			}
		}
		
		
		
		
		
		for (BaseModel model : deadList){
			gameLayout1.remove(model);
			gameLayout2.remove(model);
			gameLayout3.remove(model);
			for (ArrayList<Plants> list : gameLayout4plant){
				list.remove(model);
			}
			for (ArrayList<BaseModel> list : gameLayout4bullet){
				list.remove(model);
			}
			for (ArrayList<Zombies> list : gameLayout4zombie){
				list.remove(model);
			}
			
		}
		
		
		for(int i = 0; i < 5 ; i++){
			checkConllision0(i);
			checkConllision1(i);
		}
		
		
		
	}
	//画出物体
	private void ondraw(Canvas canvas){
		for (BaseModel model : gameLayout2){	//卡片
			model.draw(canvas, paint);
		}
		
		
		//显示植物 
		for (ArrayList<Plants> list : gameLayout4plant){
			for (Plants model : list){
				model.draw(canvas, paint);
			}
		}
		//显示子弹
		for (ArrayList<BaseModel> list : gameLayout4bullet){
			for (BaseModel model : list){
				model.draw(canvas, paint);
			}
		}
		//显示僵尸
		for (ArrayList<Zombies> list : gameLayout4zombie){
			for (Zombies model : list){
				model.draw(canvas, paint);
			}
		}
		
		
		for (BaseModel model : gameLayout3){	//阳光
			model.draw(canvas, paint);
		}
		
		for (BaseModel model : gameLayout1){	//可拖动的植物 
			model.draw(canvas, paint);
		}
	}
	//屏幕触摸事件
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO 自动生成的方法存根
		for(BaseModel model : gameLayout1){		//将触屏事件交给实例的对象来响应
			if(model instanceof TouchAble){
				if(((TouchAble)model).onTouch(event)){	//如果该对象响应了触屏事件,返回真
					return true;
				}
			
			}
		}
	
		for(BaseModel model : gameLayout2){		//将触屏事件交给实例的对象来响应
			if(model instanceof TouchAble){
				if(((TouchAble)model).onTouch(event)){	//如果该对象响应了触屏事件,返回真
					return true;
				}
			
			}
		}
		for(BaseModel model : gameLayout3){		//将触屏事件交给实例的对象来响应
			if(model instanceof TouchAble){
				if(((TouchAble)model).onTouch(event)){	//如果该对象响应了触屏事件,返回真
					return true;
				}
			
			}
		}
		return false;
	}
	
	public static GameView getInstance(){
		return gameView;
	}
	//创建一个可拖动的植物 
	public void anfang(int locationX,int locationY,int type) {
		// TODO 自动生成的方法存根
		
			if(gameLayout1.size()< 1){	//如果不存在拖动中的植物就new 一个可拖动的植物 
				gameLayout1.add(new AnfangPea(locationX,locationY,type));
		
			}
		
	}
	//创建植物 
	public void apply4Plant(int locationX, int locationY, int type) {
		// TODO 自动生成的方法存根
		
			for(int i = 0 ; i < 5 ; i++ ){
				for(int j = 0 ; j < 9 ; j++){
					if(Config.map[j][i].contains(locationX + Config.deviceWidth / 11 / 2,locationY + Config.deviceHeight / 6 / 2)){
						if(!cell[j][i]){	//如果格子里没有植物就new一个植物
							cell[j][i] = true;
							createPlant(Config.map[j][i].left,Config.map[j][i].top,type,j,i);
							
						}
						
					}
				}
			}
		
		
	}
	//此方法会动态的new 出一个相应的植物 
	private void createPlant(int x,int y,int type,int i,int j){	//j表示的是第几行
		
		Plants plant = null;
		
		switch(type){
		case Config.c_flower:
			plant = new SunFlower(x,y,i,j,300);
			break;
		case Config.c_pea:
			plant = new Pea(x,y,i,j,300);
			break;
		case Config.c_wallnut:
			plant = new WallNut(x,y,i,j,4000);
			break;
		}
		
		gameLayout4plant.get(j).add(plant);
		
		
		
	}
	//被花朵请求,生产太阳
	public void makeSun(int locationX, int locationY) {
		// TODO 自动生成的方法存根
		gameLayout3.add(new Sun(locationX,locationY));
	}
	//生产僵尸
	public  void makeZombie() {
		// TODO 自动生成的方法存根
		
		int n = 0; // 生产僵尸的随机跑道
		n = (int) (Math.random() * 5);
		int ran = (int) (Math.random() * 2);
		Zombies zombie =null;
		switch (ran) {
		case 0:
			zombie = new Zombie(Config.deviceWidth, n * Config.deviceHeight
				/ 6 + Config.deviceHeight / 12, n, 1);
			break;
		case 1:
			zombie = new ConeheadZombie(Config.deviceWidth, n * Config.deviceHeight
				/ 6 + Config.deviceHeight / 12, n, 1);
			break;
		}
		
		
		gameLayout4zombie.get(n).add(zombie);
		
		
		
	}
	private void checkConllision0(int n) {	//子弹和僵尸碰撞检测 参数n为行数
		for(BaseModel model : gameLayout4bullet.get(n)){
			for(Zombies zombie : gameLayout4zombie.get(n)){
				if (Math.abs(model.getLocationX() + model.getModelWidth()
						- (zombie.getLocationX() + zombie.getModelWidth() / 4*3)) < zombie
						.getSpeed() + model.getSpeed()) {
					zombie.sub(model.getA());
					model.setAlive(false);
					return;
				}	
			}
		}
	
	}
	
	private void checkConllision1(int n) {	//植物和僵尸碰撞检测 参数n为行数
		for(Zombies zombie : gameLayout4zombie.get(n)){
			if(gameLayout4plant.get(n).size() == 0){
				zombie.stop(false);
			}
			for(Plants model : gameLayout4plant.get(n)){
			if (Math.abs(model.getLocationX() + model.getModelWidth()
						- (zombie.getLocationX() + zombie.getModelWidth() / 4*3)) <= zombie
						.getSpeed() + model.getModelWidth()*0.1) {
					zombie.stop(true);	//碰到植物 ,僵尸停止
					model.sub(1);
					if(!model.isAlive()){	//植物死掉,僵尸继续走
						cell[model.getXY().x][model.getXY().y] = false;
						//zombie.stop(false);
					}
					break;
				}else{
					zombie.stop(false);
				}
			
			}
		}
	
	}
	
	
	
	
	
	//处理碰撞检测
	public void checkConllision(Zombies zombie, int n) {
		// TODO 自动生成的方法存根
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		switch (n) {
		case 0:
			//植物是否碰撞到僵尸
			for (Plants model : gameLayout4plant0) {
				if (Math.abs(model.getLocationX() + model.getModelWidth()
						- (zombie.getLocationX() + zombie.getModelWidth() / 4*3)) <= zombie
						.getSpeed() + model.getModelWidth()*0.1) {
					zombie.stop(true);	//碰到植物 ,僵尸停止
					model.sub(1);
					if(!model.isAlive()){	//植物死掉,僵尸继续走
						cell[model.getXY().x][model.getXY().y] = false;
						zombie.stop(false);
					}
				}
			}
			
			
			
			//子弹是否碰撞到僵尸
			for (BaseModel model : gameLayout4bullet0) {
				if (Math.abs(model.getLocationX() + model.getModelWidth()
						- (zombie.getLocationX() + zombie.getModelWidth() / 4*3)) < zombie
						.getSpeed() + model.getSpeed()) {
					zombie.sub(model.getA());
					model.setAlive(false);
				}
			}
			break;
		case 1:
			for (Plants model : gameLayout4plant1) {
				if (Math.abs(model.getLocationX() + model.getModelWidth()
						- (zombie.getLocationX() + zombie.getModelWidth() / 4*3)) <= zombie
						.getSpeed() + model.getModelWidth()*0.1) {
					zombie.stop(true);
					model.sub(1);
					if(!model.isAlive()){
						cell[model.getXY().x][model.getXY().y] = false;
						zombie.stop(false);
					}
				}
			}
			for (BaseModel model : gameLayout4bullet1) {
				if (Math.abs(model.getLocationX() + model.getModelWidth()
						- (zombie.getLocationX() + zombie.getModelWidth() / 4*3)) < zombie
						.getSpeed() + model.getSpeed()) {
					zombie.sub(model.getA());
					model.setAlive(false);
				}
			}
			break;
		case 2:
			for (Plants model : gameLayout4plant2) {
				if (Math.abs(model.getLocationX() + model.getModelWidth()
						- (zombie.getLocationX() + zombie.getModelWidth() / 4*3)) <= zombie
						.getSpeed() + model.getModelWidth()*0.1) {
					zombie.stop(true);
					model.sub(1);
					if(!model.isAlive()){
						cell[model.getXY().x][model.getXY().y] = false;
						zombie.stop(false);
					}
				}
			}
			for (BaseModel model : gameLayout4bullet2) {
				if (Math.abs(model.getLocationX() + model.getModelWidth()
						- (zombie.getLocationX() + zombie.getModelWidth() / 4*3)) < zombie
						.getSpeed() + model.getSpeed()) {
					zombie.sub(model.getA());
					model.setAlive(false);
				}
			}
			break;
		case 3:
			for (Plants model : gameLayout4plant3) {
				if (Math.abs(model.getLocationX() + model.getModelWidth()
						- (zombie.getLocationX() + zombie.getModelWidth() / 4*3)) <= zombie
						.getSpeed() + model.getModelWidth()*0.1) {
					zombie.stop(true);
					model.sub(1);
					if(!model.isAlive()){
						cell[model.getXY().x][model.getXY().y] = false;
						zombie.stop(false);
					}
				}
			}
			for (BaseModel model : gameLayout4bullet3) {
				if (Math.abs(model.getLocationX() + model.getModelWidth()
						- (zombie.getLocationX() + zombie.getModelWidth() / 4*3)) < zombie
						.getSpeed() + model.getSpeed()) {
					zombie.sub(model.getA());
					model.setAlive(false);
				}
			}
			break;
		case 4:
			for (Plants model : gameLayout4plant4) {
				if (Math.abs(model.getLocationX() + model.getModelWidth()
						- (zombie.getLocationX() + zombie.getModelWidth() / 4*3)) <= zombie
						.getSpeed() + model.getModelWidth()*0.1) {
					zombie.stop(true);
					model.sub(1);
					if(!model.isAlive()){
						cell[model.getXY().x][model.getXY().y] = false;
						zombie.stop(false);
					}
				}
			}
			for (BaseModel model : gameLayout4bullet4) {
				if (Math.abs(model.getLocationX() + model.getModelWidth()
						- (zombie.getLocationX() + zombie.getModelWidth() / 4*3)) < zombie
						.getSpeed() + model.getSpeed()) {
					zombie.sub(model.getA());
					model.setAlive(false);
				}
			}
			break;
		}
			*/
			
			
		
	}

	public void makeBullet(int x, int y,int n,int o) {
		// TODO 自动生成的方法存根
		if (gameLayout4zombie.get(n).size() > 0) { // 如果前方有僵尸才创建子弹
			BaseModel bullet = new Bullet(x, y,o);
			gameLayout4bullet.get(n).add(bullet);
		}
		
		
		
		
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO 自动生成的方法存根
		canvas.drawBitmap(Config.back, 0, 0, paint);
		//画卡片框
		
		canvas.drawBitmap(Config.seedBank, Config.sunDeadLocationX, 0, paint);
		//画出太阳数量
		paint.setTextSize(20f);
		canvas.drawText(Config._sun+"",Config.sunDeadLocationX + Config.deviceWidth /50 ,Config.deviceHeight / 7.5f,paint);
		
		updataData();
		
		
		zombieMannger.draw(canvas, paint);
		ondraw(canvas);
		
		
		
		
		invalidate();
		super.onDraw(canvas);
	}
	
}
