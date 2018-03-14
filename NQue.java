import java.util.Scanner;

public class NQue{
	
    final int N;
    long solution;
    int[] position;
    int row;
    StringBuilder line = new StringBuilder();
    String title = "Solution #";
    
    NQue(int size){
		N = size;
		position = new int[N];
		solution = 0;
		row =0;
    	for(int i=0; i<N; i++) {
    		line = line.append("0 ");
    	}
	}

    boolean notInUse(int index){
    	int i;
        for (i = 0; i < index; i++)
        	if (position[index] == position[i] || position[index]+index == position[i]+i || position[index]-index == position[i]-i)
        		return false;

        return true;
    }

    long solveNQ(){

        while(row < N) {
        	if(position[row] == N) { //Check to see if all the moves 
        		if(row-- == 0) 
        			break;
        		position[row]++;
        		continue;
        	}
        	
    		if(notInUse(row)) {	
        		if(++row == N) { //Check to see if all Queens are placed safely
        		    solution++;
        		    print();
        		    row--;
        		    position[row]++;
        		}
        		else {
        			position[row]=0; //reset next row
        		}
    		}
    		else {
    			position[row]++;//try next position
    		}
        }
        return solution;
    }
    
    public void print() {
    	StringBuilder table = new StringBuilder();
    	table.append(title).append(solution).append("\n");
    	for(int queen:position)
    		table.append(new StringBuilder(line).replace(queen*2, queen*2+1,"1").append("\n"));    		
    	System.out.println(table);
    }
 
    public static void main(String args[]){
    	NQue Queen;
    	int size;
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please enter your board size!");
    	while(sc.hasNextInt()) {   		
	    	size = sc.nextInt();	        
	    	Queen = new NQue(size);
	    	//long before = System.currentTimeMillis();
	        System.out.println("Total Number of Solution: " + Queen.solveNQ());
	        //System.out.println("Excuting time: " + (System.currentTimeMillis()-before) + "ms");
	    	System.out.println("Please enter your board size!");
    	}
    	sc.close();
    }
}
