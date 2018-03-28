//Max Tran CSE 143, April 9, 2016
/*this program is used to keep track of an inventory of letters of the alphabet.
the input is a string and the program will compute the number of alphabet letters*/

public class LetterInventory {
   //the number of letter in the alphabet
   private static final int ALPHABET_SIZE = 26;
   //the number of alphabet letters in the string
   private int sum = 0;
   //the array to represent the count of the number of the alphabet
   private int[] count;
   
   // constructor to define the default behavior for the LetterInventory class
   public LetterInventory (String data){
      count = new int[ALPHABET_SIZE];
      data = data.toLowerCase();
      for(int i = 0; i <data.length();i++){
         if(Character.isLetter(data.charAt(i))){
            count[data.charAt(i)-97]++;
            sum++;
         }
      }
   }
   
   //this method is used to return the number of letter in the input string.
   public int get(char letter){
      if(!Character.isLetter(letter)){
         throw new IllegalArgumentException("non-alphabetic character: " + letter);
      }  
      return count[Character.toLowerCase(letter)-97];
   }
   
   //this method is used to replace the number of letters in the alphabet by a new number
   public void set(char letter, int value){
      if ((int)(letter-'a') < ALPHABET_SIZE && (int) (letter - 'a') >= 0 && value >= 0){
         sum += value - count[(int)(letter - 'a')];
         count[(int) (letter - 'a')] = value;
      } else {
         throw new IllegalArgumentException("Value too low or incorrect character. Letter: " + letter +", Value: " +value);
      }
   }
   
   //this method returns the number of alphabet letters in the string.
   public int size(){
      return sum;
   }
   
   //this methods will return true if its empty and false if its not.
   public boolean isEmpty(){
      return sum == 0;
   }
   
   // this method to represent the LetterInventory class on a console
   public String toString(){
      String inventory = "[";
      for(int i = 0;i < ALPHABET_SIZE;i++){
         char ch = (char)(i+97);;
         for(int j=0; j<count[i];j++){ 
            inventory += ch;
         }
      }
      return inventory +"]";
   }
   
   /*this method allows you to combine two different LetterInventory to get a new LetterInventory 
   which is a result of adding the two string together*/
   public LetterInventory add(LetterInventory other) {
      String fusion = "";
      LetterInventory total = new LetterInventory(fusion);
      for(int i = 0; i < ALPHABET_SIZE;i++){
         total.count[i] = this.count[i]+other.count[i];
      }
      total.sum = this.sum + other.sum;
      return total;
   }
   
   /*this method allows you to subtract one LetterInventory from the other to get a new LetterInventory
   with new sum, toString, etc...*/
   public LetterInventory subtract(LetterInventory other){
      String fusion = "";
      LetterInventory difference = new LetterInventory(fusion);
      for(int i = 0; i < ALPHABET_SIZE;i++){
         difference.count[i] = this.count[i] - other.count[i];
         if(difference.count[i]<0){
            return null;
         }
      }
      difference.sum = this.sum - other.sum;
      return difference;
   }
}