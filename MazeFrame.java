import java.util.ArrayList;
import javax.swing.JFrame;

public class MazeFrame
{
	public static void main(String[] args) throws InterruptedException
	{
		int width = 15;
		int height = 10;
		JFrame frame = new JFrame();
		Maze maze = new Maze(width, height);
		ArrayList<Pair<Integer,Integer>> solution = new ArrayList<Pair<Integer,Integer>>();
		MazeComponent mc = new MazeComponent(maze, solution);
		frame.setSize(800,800);
		frame.setTitle("Maze");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mc);
		frame.setVisible(true);
		
		
		solution.add(new Pair<Integer,Integer>(0,0));
		Thread.sleep(50);
		solveMaze(solution, mc, maze,0,0);
		mc.repaint();
		
	}
	
	/** Solve Maze: recursively solve the maze
	 * 
	 * @param solution   : The array list solution is needed so that every recursive call,
	 *                     a new (or more) next position can be added or removed.
	 * @param mc         : This is the MazeComponent. We need that only for the purpose of
	 *                     animation. We need to call mc.repaint() every time a new position
	 *                     is added or removed. For example,
	 *                       :
	 *                     solution.add(...);
	 *                     mc.repaint();
	 *                     Thread.sleep(sleepTime);
	 *                       :
	 *                     solution.remove(...);
	 *                     mc.repaint();
	 *                     Thread.sleep(sleepTime);
	 *                       :
	 * @param maze       : The maze data structure to be solved. 
	 * @return a boolean value to previous call to tell the previous call whether a solution is
	 *         found.
	 * @throws InterruptedException: We need this because of our Thread.sleep(50);
	 */
	
	public static boolean solveMaze(ArrayList<Pair<Integer,Integer>> solution, MazeComponent mc, Maze maze, int xCoor, int yCoor) throws InterruptedException
	{
			System.out.println("xCoor: " + xCoor);
			System.out.println("yCoor: " + yCoor);
			//boolean result = false;
		    
			if (xCoor == maze.getHeight()-1 && yCoor == maze.getWidth()-1)
		    {
		        	 return true;  // maze is solved
		    }
			else
			{
		    		//north
					if(!maze.isNorthWall(xCoor, yCoor) && solution.size() > 1 && (solution.get(solution.size()-2).fst()!=xCoor-1 || solution.get(solution.size()-2).snd()!=yCoor))
		    	 	{
					  System.out.println("north wall is valid");
		    		  solution.add(new Pair<Integer,Integer>(xCoor-1,yCoor));
		    		  mc.repaint();
		    		  Thread.sleep(50);
			    	  if(solveMaze(solution,mc,maze,xCoor-1,yCoor)==true)
			    	  {
			    		  return true;
			    	  }
			    	  else
			    	  {
			    		solution.remove(solution.size()-1);
			    		mc.repaint();
			    		Thread.sleep(1000);
			    	  }
		    	 	}
		    	 	if(!maze.isNorthWall(xCoor, yCoor) && solution.size() <= 1)
		    	 	{
					  System.out.println("north wall is valid7");
		    		  solution.add(new Pair<Integer,Integer>(xCoor-1,yCoor));
		    		  mc.repaint();
		    		  Thread.sleep(1000);
			    	  if(solveMaze(solution,mc,maze,xCoor-1,yCoor)==true)
			    	  {
			    		  return true;
			    	  }
			    	  else
			    	  {
			    		solution.remove(solution.size()-1);
			    		mc.repaint();
			    		Thread.sleep(50);
			    	  }
		    	 	}
		    	 	//east
		    	 	if(!maze.isEastWall(xCoor, yCoor) && solution.size() > 1 && (solution.get(solution.size()-2).fst()!=xCoor || solution.get(solution.size()-2).snd()!=yCoor+1))
		    	 	{
		    	 		System.out.println("east wall is valid");
		    	 		solution.add(new Pair<Integer,Integer>(xCoor,yCoor+1));
		    	 		mc.repaint();
		    	 		Thread.sleep(50);
		    	 		if(solveMaze(solution,mc,maze,xCoor,yCoor+1)==true)
		    	 		{
		    	 			return true;
		    	 		}
		    	 		else 
		    	 		{
		    	 			solution.remove(solution.size()-1);
		    	 			mc.repaint();
		    	 			Thread.sleep(50);
		    	 		}
		    	 	}
		    	 	if(!maze.isEastWall(xCoor, yCoor) && solution.size() <= 1)
		    	 	{
		    	 		System.out.println("east wall is valid");
		    	 		solution.add(new Pair<Integer,Integer>(xCoor,yCoor+1));
		    	 		mc.repaint();
		    	 		Thread.sleep(50);
		    	 		if(solveMaze(solution,mc,maze,xCoor,yCoor+1)==true)
		    	 		{
		    	 			return true;
		    	 		}
		    	 		else 
		    	 		{
		    	 			solution.remove(solution.size()-1);
		    	 			mc.repaint();
		    	 			Thread.sleep(50);
		    	 		}
		    	 	}
		    	 	
		    	 	//south
		    	 	if(!maze.isSouthWall(xCoor,yCoor) && solution.size() > 1 && (solution.get(solution.size()-2).fst()!=xCoor+1 || solution.get(solution.size()-2).snd()!=yCoor))
		    	 	{
		    	 		System.out.println("south wall is valid");
		    	 		solution.add(new Pair<Integer,Integer>(xCoor+1,yCoor));
		    	 		mc.repaint();
		    	 		Thread.sleep(50);
		    	 		if(solveMaze(solution,mc,maze,xCoor+1,yCoor)==true)
		    	 		{
		    	 			return true;
		    	 		}
		    	 		else 
		    	 		{
		    	 			solution.remove(solution.size()-1);
		    	 			mc.repaint();
		    	 			Thread.sleep(50);
		    	 		}
		    	 	}
		    	 	if(!maze.isSouthWall(xCoor,yCoor) && solution.size() <= 1)
		    	 	{
		    	 		System.out.println("south wall is valid");
		    	 		solution.add(new Pair<Integer,Integer>(xCoor+1,yCoor));
		    	 		mc.repaint();
		    	 		Thread.sleep(50);
		    	 		if(solveMaze(solution,mc,maze,xCoor+1,yCoor)==true)
		    	 		{
		    	 			return true;
		    	 		}
		    	 		else 
		    	 		{
		    	 			solution.remove(solution.size()-1);
		    	 			mc.repaint();
		    	 			Thread.sleep(50);
		    	 		}
		    	 	}
			    	//west
		    	 	if(!maze.isWestWall(xCoor, yCoor) && solution.size() > 1 && (solution.get(solution.size()-2).fst()!=xCoor || solution.get(solution.size()-2).snd()!=yCoor-1))
		    	 	{
		    	 		System.out.println("west wall is valid");
		    	 		solution.add(new Pair<Integer,Integer>(xCoor,yCoor-1));
		    	 		mc.repaint();
		    	 		Thread.sleep(50);
		    	 		if(solveMaze(solution,mc,maze,xCoor,yCoor-1)==true)
		    	 		{
		    	 			return true;
		    	 		}
		    	 		else
		    	 		{
		    	 			solution.remove(solution.size()-1);
		    	 			mc.repaint();
		    	 			Thread.sleep(50);
		    	 		}
		    	 	}
		    	 	if(!maze.isWestWall(xCoor, yCoor) && solution.size() <= 1)
		    	 	{
		    	 		System.out.println("west wall is valid");
		    	 		solution.add(new Pair<Integer,Integer>(xCoor,yCoor-1));
		    	 		mc.repaint();
		    	 		Thread.sleep(50);
		    	 		if(solveMaze(solution,mc,maze,xCoor,yCoor-1)==true)
		    	 		{
		    	 			return true;
		    	 		}
		    	 		else
		    	 		{
		    	 			solution.remove(solution.size()-1);
		    	 			mc.repaint();
		    	 			Thread.sleep(50);
		    	 		}
		    	 	}
		    	 	return false;
		    	 }
				
		}
			
	
}

