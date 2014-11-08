import java.util.Random;
// No other import statement is allowed

public class Maze
{
	// TO DO: Instance Variable
	int height;
	int width;
	int [][][]board;
	
	/**
	 * Constructor
	 * @param aWidth the number of chambers in each row
	 * @param aHeight the number of chamber in each column
	 */
	public Maze(int aWidth, int aHeight)
	{
		width = aWidth;
		height = aHeight;
		board = new int [width][height][4];
		if (getWidth()==1 || getHeight()==1){
			return;
		}
		// TO DO: Constructor
	}

	/**
	 * getWidth
	 * @return the width of this maze
	 */
	public int getWidth()
	{
		// TO DO
		return width;
	}
	
	/**
	 * getHeight
	 * @return the height of this maze
	 */
	public int getHeight()
	{
		// TO DO
		return height;
	}
	
	/**
	 * isNorthWall
	 * @param row the row identifier of a chamber
	 * @param column the column identifier of a chamber
	 * @return true if the chamber at row row and column column
	 * contain a north wall. Otherwise, return false
	 */
	public boolean isNorthWall(int row, int column)
	{
		// TO DO
	}
	
	/**
	 * isEastWall
	 * @param row the row identifier of a chamber
	 * @param column the column identifier of a chamber
	 * @return true if the chamber at row row and column column
	 * contain an east wall. Otherwise, return false
	 */
	public boolean isEastWall(int row, int column)
	{
		// TO DO
	}
	
	/**
	 * isSouthWall
	 * @param row the row identifier of a chamber
	 * @param column the column identifier of a chamber
	 * @return true if the chamber at row row and column column
	 * contain a south wall. Otherwise, return false
	 */
	public boolean isSouthWall(int row, int column)
	{
		// TO DO
	}
	
	/**
	 * isWestWall
	 * @param row the row identifier of a chamber
	 * @param column the column identifier of a chamber
	 * @return true if the chamber at row row and column column
	 * contain a west wall. Otherwise, return false
	 */
	public boolean isWestWall(int row, int column)
	{
		// TO DO
	}
}
