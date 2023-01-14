// Main
ArrayList<Bubble> bubbles;
ArrayList<Integer> intialValues;
int timeLeft = 3600;
int score = 0;
int k = 0;
int opened = 0;

void setup()
{
	size(500,500);
  bubbles = new ArrayList<Bubble>();
  intialValues = new ArrayList<integer>();
  intialValues.add(1);
  intialValues.add(1);
  intialValues.add(2);
  intialValues.add(2);
  intialValues.add(3);
  intialValues.add(3);
  intialValues.add(4);
  intialValues.add(4);
  intialValues.add(5);
  intialValues.add(5);
  intialValues.add(6);
  intialValues.add(6);
  intialValues.add(7);
  intialValues.add(7);
  intialValues.add(8);
  intialValues.add(8);

  beginGame();
  shuffle();

}

void beginGame() 
{
  for (int i = 100; i <= 400; i = i+100){
    for (int j=100; j<=400; j = j+100){
      int iv = intialValues.get(k);
      Bubble t = new Bubble(i,j,iv);
      bubbles.add(t);
      k = k + 1;
    }    
  }
}



void play()
{
  for (int i=0; i < bubbles.size(); i++) {
    Bubble b=bubbles.get(i);
    b.display();
  }
}

void draw()
{
	background(195, 201, 179);
  if(timeLeft > 0)
	{
		timeLeft--;
		play();
	}
	else
	{
		textSize(50);
		textAlign(CENTER, CENTER);
		text("Game Over!!!", width/2, height/2);
	}

	textSize(25);
	textAlign(LEFT, TOP);
	text("Time: " + (int) (timeLeft/60+.5), width-130, 15);

  textSize(25);
	textAlign(LEFT, TOP);
	text("Score: " + score , 50, 15);

  if (score == 8)
  {
    timeLeft=0;
  }
}

void mousePressed() {
    if (opened >= 2) {

      CheckMatch();
      return;
    }
    for (int i=0; i < bubbles.size(); i++) {
      Bubble b=bubbles.get(i);        
      if (b.CheckIfSelected(mouseX,mouseY)) {
            if  (b.isMatched()) {
                return;
            }
            else if (b.isVisible()) {
                  b.flip();
                  if (opened >= 1) {
                    opened = 0;
                  }
            }
            else {
                b.flip();
                opened = opened + 1;
            }
                                    
      }
              
    }
}    
// check if 2 bubbles matched
void CheckMatch() {
  
  ArrayList<Bubble> selectedBubbles = new ArrayList<Bubble>();

   for (int i=0; i < bubbles.size(); i++) {
      Bubble b=bubbles.get(i);
      if (b.isVisible() && !b.isMatched()) {
        selectedBubbles.add(b);
      }
   } 
   
    if (selectedBubbles.get(0).GetValue() == selectedBubbles.get(1).GetValue()){
      selectedBubbles.get(0).markMatched();
      selectedBubbles.get(1).markMatched();
      opened = 0;
      score = score + 1;
    }
    else {
     selectedBubbles.get(0).flip();
     selectedBubbles.get(1).flip();
     opened = 0;
    }
}


// randomize the bubble placemnets at the start every time
void shuffle() {
  for (int i=0; i < 50; i++) {
      Bubble s1 = bubbles.get((int)random(0,bubbles.size()));
      Bubble s2 = bubbles.get((int)random(0,bubbles.size()));
      int x1 = s1.GetX();
      int y1 = s1.GetY();
      int x2 = s2.GetX();
      int y2 = s2.GetY();
      s1.SetXY(x2,y2);
      s2.SetXY(x1,y1);
  } 
}