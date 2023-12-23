int currentStep = current[0]; //1
int level = current[1];
if(currentStep == target){
return level;
}
for( int i = 1; i < 7; i++ ){ //roll the dice 6 time i.e 1 to 6
int nextLabel = currentStep + i; //next label i.e position 1 to 6 no from dice
//1 + 1 = 2
if( nextLabel <= target ){ //2 <37
​
int row = cell[nextLabel].getKey(); // get the value form cell row 5
int col = cell[nextLabel].getValue();// col 0
​
int destination = ( board[row][col] != -1 ) ? board[row][col] : nextLabel;
​
if(!visited.contains(destination)){
visited.add( destination );
q.add(new int[]{ destination , level + 1 });
}
}
}
}
return -1;
}
}