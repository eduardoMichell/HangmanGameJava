package br.univali.edu.game.parts;

public class Doll {
    private int parts;

    public Doll() {
        this.parts = 7;
    }

    /**
     * Getter of Parts
     * @return parts
     */
    public int getParts() {
        return parts;
    }

    /**
     * Setter of Parts
     * @param parts new parts
     */
    public void setParts(int parts) {
        this.parts = parts;
    }

    /**
     * Check if the doll has no more parts
     * @return return true if parts is equals 1 or false if its not
     */
    public boolean isDeath(){
        return parts == 1;
    }

    /**
     * Decrement a part if you miss a letter
     */
    public void missedLetter(){
        parts--;
    }

    /**
     * Print a doll
     * @param missed parts that will be printed
     */
    public void printDoll(int missed){
        char leg = (char) 92;


       if(missed == 6) {
           System.out.println(" O ");
       }
       if(missed == 5){
           System.out.println(" O ");
           System.out.println(" | ");
       }
       if(missed == 4){
           System.out.println(" O ");
           System.out.println("/| ");
       }
       if(missed == 3){
           System.out.println(" O ");
           System.out.println("/|" + leg);
       }
       if(missed == 2){
           System.out.println(" O ");
           System.out.println("/|" + leg);
           System.out.println(" /");
       }
       if(missed == 1){
           System.out.println(" O ");
           System.out.println("/|" + leg);
           System.out.println(" /" + leg);
       }
    }


}
