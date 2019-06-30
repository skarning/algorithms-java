
public class Board {
	private int n;
	private int[][] board;
	private final int TRIED = 1;
	
	public Board(int n) {
		this.n = n;
		board = new int[n][n];
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				board[i][j] =  0;
		
	}
	
	public boolean IsValid(int x, int y) {
			if(x >= 0 && x < n && y < n &&  y >= 0 && board[x][y] != TRIED) {
				board[x][y] = TRIED;
				return true;
			}
			else
				return false;
	} 
	
	public void tryPosition(int x, int y) {
		board[x][y] = TRIED;
	}
	
	public boolean isFinished() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	
	public void printBoard() {
		for(int i = 0; i < n; i++) {
			System.out.println();
			for(int j = 0; j < n; j++) {
				System.out.print(board[i][j]);
			}
		}
		System.out.println();
	}
	
	public void resetCoordinate(int x, int y) {
		if(x >= 0 && x < n && y < n &&  y >= 0) {
			board[x][y] = 0;
		}
	}
}