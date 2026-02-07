// A Rectangle class

import java.nio.file.FileAlreadyExistsException;

public class Rectangle {
  
  // 4 instance attributes
  private double width;
  private double height;
  private double originX = 0.0;
  private double originY = 0.0;

public double getWidth(){ 
  return width;
}

public void setWidth(double width){
  if (width >=0){
    this.width = width;
  }

}

public double getHeight(){
  return height;
}

public void setHeight(double height){
    if (height >=0){
    this.height = height;
  }

}

public double getOriginX(){
  return originX;
}

public void setOriginX(){
  this.originX = originX;
}

public double getOriginY(){
  return originY;
}

  public void setOriginY(){
  this.originY = originY;
}


  // 1 static attributes
  public static final int NUMBER_OF_SIDES = 4;

  // main constructor
  public Rectangle(double width, double height, double originX, double originY) {
    this.width = width;
    this.height = height;
    this.originX = originX;
    this.originY = originY;
  }

  // second constructor: 
  public Rectangle(double width, double height) {
      this(width, height, 0, 0);
  }

    // third constructor: 
  public Rectangle() {
      this(1, 1, 0, 0);
  }


  // method: move the rectangle
  public void move(double dx, double dy) {
	   originX += dx;
	   originY += dy;
  }

  public void scale(double scaleX, double scaleY){
    width *= scaleX;
    height *= scaleY;
    System.out.println("New width: " + width + ", New height: " + height);;
  }

  public void scale(double factor){
    scale(factor, factor);
  }

  // method: compute the area of the rectangle
  public double getArea() {
    return width * height;
  }
  
  // method: compute the area of the rectangle
  public double getPerimeter() {
    return 2 * (width + height);
  }
  
public boolean isOverlappedWith(Rectangle r) {

    // Edges of this rectangle
    double left1 = this.originX;
    double right1 = this.originX + this.width;
    double bottom1 = this.originY;
    double top1 = this.originY + this.height;

    // Edges of the other rectangle
    double left2 = r.originX;
    double right2 = r.originX + r.width;
    double bottom2 = r.originY;
    double top2 = r.originY + r.height;

    // If one rectangle is completely outside the other → no overlap
    if (right1 <= left2 ||     // this is left of r
        right2 <= left1 ||     // r is left of this
        top1 <= bottom2 ||     // this is below r
        top2 <= bottom1) {     // r is below this
        return false;
    }

    return true;
}
public static boolean areOverlapping(Rectangle r1, Rectangle r2) {

    return !(r1.originX + r1.width  <= r2.originX ||
             r2.originX + r2.width  <= r1.originX ||
             r1.originY + r1.height <= r2.originY ||
             r2.originY + r2.height <= r1.originY);
}

public double calcRatio(Rectangle r1){
    double ratio = width/height;
    return ratio;
}

public boolean isSquare(Rectangle r1) {
  if (width == height){
    return true;
  }
  return false;
  }

  // Return a description of a rectangle in the form of
// Rectangle[x=*,y=*,w=*,h=*]
public String toString(){
return "Rectangle[x="+originX+",y="+originY+",w="+width+",h="+height+"]";
}
}

