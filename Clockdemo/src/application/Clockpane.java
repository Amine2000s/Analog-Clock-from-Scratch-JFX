package application;

import java.util.Calendar;
import java.util.GregorianCalendar ; 

import javafx.*;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.Binding;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;




public class Clockpane extends Pane  {

	private int hour ; 
	private int minute ; 
	private int second;
	
	private double w =300,h=300;
	
	
	public Clockpane () {
		setCurrentTime();
		paintClock();
		
	}
	
	public Clockpane(int hour , int minute , int seconds ) {
		
		this.hour = hour;
		this.minute = minute ; 
		this.second = seconds ; 
		paintClock();
		
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}
	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}
	
	public void setCurrentTime() {
		
		Calendar calendar = new GregorianCalendar();
		
		this.hour= calendar.get(Calendar.HOUR_OF_DAY);
		this.minute=calendar.get(Calendar.MINUTE);
		this.second=calendar.get(Calendar.SECOND);
		
	
	}
	
	protected void paintClock() {
		
		double clockradius = Math.min(w,h) * 0.8 *0.5;
		
		double centerX = w/2;
		double centerY = h/2;
		
		Circle circle = new Circle(centerX,centerY,clockradius);
		
		
		
		
		
		//circle.centerXProperty().bind(super.widthProperty().divide(2));
		//circle.centerYProperty().bind(super.heightProperty().divide(2));

		circle.setFill(Color.WHITE);
		
		circle.setStroke(Color.BLACK);
		//12
		Text t1 = new Text(centerX-5,centerY-clockradius+15,"12");
		//9
		Text t2 = new Text(centerX-clockradius+5,centerY+3,"9");
		//3
		Text t3 = new Text(centerX+clockradius-9,centerY+3,"3");
		//6
		Text t4 = new Text(centerX-3,centerY+clockradius-5,"6");

		//drawing the seconds hand 
		double sLength = clockradius * 0.8 ;
		double secondx = centerX+sLength * 
				Math.sin(second *(2 * Math.PI / 60));
		
		double secondy = centerY - sLength * 
				Math.cos(second *(2 *Math.PI)/60);
		
		Line sLine = new Line(centerX,centerY,secondx,secondy);
		
		sLine.setStroke(Color.RED);
		
		//drawing the minute hand 
		
		double mLength = clockradius * 0.65 ; 
		
		double minutex = centerX + mLength *
				Math.sin(minute * (2 * Math.PI / 60));
		
		double minutey = centerY - mLength * 
				Math.cos(minute * (2 * Math.PI/60));
		
		Line mLine = new Line(centerX,centerY,minutex,minutey);
		
		mLine.setStroke(Color.BLUE);
		
		//drawing the hour minutes 
		
		double hLength = clockradius * 0.5 ; 
		double hourX = centerX + hLength * 
				Math.sin((hour%12+minute / 60.0) * (2 * Math.PI / 12));
		
		double hourY = centerY - hLength * 
				Math.cos((hour%12+minute / 60.0) * (2 * Math.PI / 12));
		
		Line hLine = new Line(centerX,centerY,hourX,hourY);
		
		hLine.setStroke(Color.GREEN);
		
		//getChildren().clear();
		
		getChildren().addAll(circle,t1,t2,t3,t4,sLine,mLine,hLine);
		//getChildren().addAll(circle);
		
		
		
	}

	
	
}
