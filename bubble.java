// Bubble Class
class Bubble
{
	int x;
	int y;
  int value;
  int r, g, b;
  boolean visible;
  boolean matched;

	Bubble(int xInput, int yInput, int inputValue)
	{
	  x = xInput;
		y = yInput;
    value = inputValue;
    r = 175;
    g= 190;
    b = 220;
    visible = false;
    matched = false;
	}

  void SetXY(int newX, int newY){
      x = newX;
      y = newY;
  }

  int GetX(){
    return x;
  }

  int GetY(){
    return y;
  }
  int GetValue() {
    return value;
  }
  boolean isMatched(){
    return matched;
  }
   boolean isVisible(){
    return visible;
  }

  void markMatched() {
    fill(125, 215, 115);
    ellipse(x,y,75,75);
    visible = true;
    matched = true;
  }

	void display()
	{
    if (isMatched()){
      fill(125, 215, 115);
      ellipse(x,y,75,75);
    }
    else {
      fill(r,g,b);
		  ellipse(x, y, 75, 75);

    }
 
    if (visible) {
      fill(0);
      text(value,x,y);
    }    
	}

  void flip()
  {
    if (!matched) {
      visible = !visible;
    }
  }

  boolean CheckIfSelected(int xPop, int yPop) {
      if ((xPop >= x - 37 && xPop <= x + 37) && (yPop <= y + 37 && yPop >= y - 37)){
          
            return true;
      }
      
      return false;
      }
}