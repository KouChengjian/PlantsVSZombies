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
	private SurfaceHolder surfaceHolder;	//����?
	private Context context;
	private boolean[][] cell;	//����*****��������������Ƿ���ֲ�� 
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
		// TODO �Զ����ɵĹ��캯�����
		this.context = context;
		paint = new Paint();
		gameView = this;
		Config.sunDeadLocationX = (Config.deviceWidth-Config.seedBank.getWidth())/2;
		
		createElement();
		
	}
	//��ʼ��
	private void createElement() {
		// TODO �Զ����ɵķ������
		
		//�����ռ����յ�����
		
		
		
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
	//��������
	private void updataData(){	//��������
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
	//��������
	private void ondraw(Canvas canvas){
		for (BaseModel model : gameLayout2){	//��Ƭ
			model.draw(canvas, paint);
		}
		
		
		//��ʾֲ�� 
		for (ArrayList<Plants> list : gameLayout4plant){
			for (Plants model : list){
				model.draw(canvas, paint);
			}
		}
		//��ʾ�ӵ�
		for (ArrayList<BaseModel> list : gameLayout4bullet){
			for (BaseModel model : list){
				model.draw(canvas, paint);
			}
		}
		//��ʾ��ʬ
		for (ArrayList<Zombies> list : gameLayout4zombie){
			for (Zombies model : list){
				model.draw(canvas, paint);
			}
		}
		
		
		for (BaseModel model : gameLayout3){	//����
			model.draw(canvas, paint);
		}
		
		for (BaseModel model : gameLayout1){	//���϶���ֲ�� 
			model.draw(canvas, paint);
		}
	}
	//��Ļ�����¼�
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO �Զ����ɵķ������
		for(BaseModel model : gameLayout1){		//�������¼�����ʵ���Ķ�������Ӧ
			if(model instanceof TouchAble){
				if(((TouchAble)model).onTouch(event)){	//����ö�����Ӧ�˴����¼�,������
					return true;
				}
			
			}
		}
	
		for(BaseModel model : gameLayout2){		//�������¼�����ʵ���Ķ�������Ӧ
			if(model instanceof TouchAble){
				if(((TouchAble)model).onTouch(event)){	//����ö�����Ӧ�˴����¼�,������
					return true;
				}
			
			}
		}
		for(BaseModel model : gameLayout3){		//�������¼�����ʵ���Ķ�������Ӧ
			if(model instanceof TouchAble){
				if(((TouchAble)model).onTouch(event)){	//����ö�����Ӧ�˴����¼�,������
					return true;
				}
			
			}
		}
		return false;
	}
	
	public static GameView getInstance(){
		return gameView;
	}
	//����һ�����϶���ֲ�� 
	public void anfang(int locationX,int locationY,int type) {
		// TODO �Զ����ɵķ������
		
			if(gameLayout1.size()< 1){	//����������϶��е�ֲ���new һ�����϶���ֲ�� 
				gameLayout1.add(new AnfangPea(locationX,locationY,type));
		
			}
		
	}
	//����ֲ�� 
	public void apply4Plant(int locationX, int locationY, int type) {
		// TODO �Զ����ɵķ������
		
			for(int i = 0 ; i < 5 ; i++ ){
				for(int j = 0 ; j < 9 ; j++){
					if(Config.map[j][i].contains(locationX + Config.deviceWidth / 11 / 2,locationY + Config.deviceHeight / 6 / 2)){
						if(!cell[j][i]){	//���������û��ֲ���newһ��ֲ��
							cell[j][i] = true;
							createPlant(Config.map[j][i].left,Config.map[j][i].top,type,j,i);
							
						}
						
					}
				}
			}
		
		
	}
	//�˷����ᶯ̬��new ��һ����Ӧ��ֲ�� 
	private void createPlant(int x,int y,int type,int i,int j){	//j��ʾ���ǵڼ���
		
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
	//����������,����̫��
	public void makeSun(int locationX, int locationY) {
		// TODO �Զ����ɵķ������
		gameLayout3.add(new Sun(locationX,locationY));
	}
	//������ʬ
	public  void makeZombie() {
		// TODO �Զ����ɵķ������
		
		int n = 0; // ������ʬ������ܵ�
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
	private void checkConllision0(int n) {	//�ӵ��ͽ�ʬ��ײ��� ����nΪ����
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
	
	private void checkConllision1(int n) {	//ֲ��ͽ�ʬ��ײ��� ����nΪ����
		for(Zombies zombie : gameLayout4zombie.get(n)){
			if(gameLayout4plant.get(n).size() == 0){
				zombie.stop(false);
			}
			for(Plants model : gameLayout4plant.get(n)){
			if (Math.abs(model.getLocationX() + model.getModelWidth()
						- (zombie.getLocationX() + zombie.getModelWidth() / 4*3)) <= zombie
						.getSpeed() + model.getModelWidth()*0.1) {
					zombie.stop(true);	//����ֲ�� ,��ʬֹͣ
					model.sub(1);
					if(!model.isAlive()){	//ֲ������,��ʬ������
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
	
	
	
	
	
	//������ײ���
	public void checkConllision(Zombies zombie, int n) {
		// TODO �Զ����ɵķ������
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		switch (n) {
		case 0:
			//ֲ���Ƿ���ײ����ʬ
			for (Plants model : gameLayout4plant0) {
				if (Math.abs(model.getLocationX() + model.getModelWidth()
						- (zombie.getLocationX() + zombie.getModelWidth() / 4*3)) <= zombie
						.getSpeed() + model.getModelWidth()*0.1) {
					zombie.stop(true);	//����ֲ�� ,��ʬֹͣ
					model.sub(1);
					if(!model.isAlive()){	//ֲ������,��ʬ������
						cell[model.getXY().x][model.getXY().y] = false;
						zombie.stop(false);
					}
				}
			}
			
			
			
			//�ӵ��Ƿ���ײ����ʬ
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
		// TODO �Զ����ɵķ������
		if (gameLayout4zombie.get(n).size() > 0) { // ���ǰ���н�ʬ�Ŵ����ӵ�
			BaseModel bullet = new Bullet(x, y,o);
			gameLayout4bullet.get(n).add(bullet);
		}
		
		
		
		
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO �Զ����ɵķ������
		canvas.drawBitmap(Config.back, 0, 0, paint);
		//����Ƭ��
		
		canvas.drawBitmap(Config.seedBank, Config.sunDeadLocationX, 0, paint);
		//����̫������
		paint.setTextSize(20f);
		canvas.drawText(Config._sun+"",Config.sunDeadLocationX + Config.deviceWidth /50 ,Config.deviceHeight / 7.5f,paint);
		
		updataData();
		
		
		zombieMannger.draw(canvas, paint);
		ondraw(canvas);
		
		
		
		
		invalidate();
		super.onDraw(canvas);
	}
	
}
