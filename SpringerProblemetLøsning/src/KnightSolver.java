
public class KnightSolver {
	private Board board;
	private static int nextX;
	private static int nextY;
	private static int count = 0;
	public KnightSolver(Board board) {
		this.board = board;
	}
	
	public boolean solve(int x, int y) {
		boolean validRoute = false;
		if(board.IsValid(x,y)) {
			if(board.isFinished() == false) {
			validRoute = solve(x+1, y+2);
				if(!validRoute) {
					validRoute = solve(x-1, y+2);
				}
				
				if(!validRoute) {
					validRoute = solve(x+2, y+1);
				}

				if(!validRoute) {
					validRoute = solve(x+2, y-1);
				}
				
				if(!validRoute) {
					validRoute = solve(x-2, y+1);
				}

				
				if(!validRoute) { 
					validRoute = solve(x-2, y-1);
				}
				
				if(!validRoute) { 
					validRoute = solve(x+1, y-2);
				}
				
				if(!validRoute) { 
					validRoute = solve(x-1, y-2);
				}
			}
			if(board.isFinished()!= true) {
				board.resetCoordinate(x, y);
			}
		}
		if(board.isFinished() == true) {
			count ++;
			if(count != 1) {
				System.out.print("\nFrom(" + x + ", " + y + ")To(" + nextX + ", " + nextY + ")");
			}
			nextX = x;
			nextY = y;
			return true;
		}
		else {
			return false;
		}
	}
	
	public Board getBoard(){
		return board;
	}
}