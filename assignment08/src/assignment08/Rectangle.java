package assignment08;

public class Rectangle {
	private int width;
	private int height;
	
	
	public int getArea(){
		
		if(width<0 || height<0) throw new IllegalArgumentException("Widht or height should be positive");
		if(width==0 || height==0) return 0;
		if(width==1) return height;
		if(height==1) return width;
		width--;
		return height + getArea();
	}
	
	public Rectangle(int aWidth, int aHeight){
		width=aWidth;
		height=aHeight;
	}
	
	

}
