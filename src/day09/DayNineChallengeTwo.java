package day09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class identifies the all the basins in a grid map with heights provided.
 * The only things used as border for one basis is the edge of the grid, or coordinates with
 * a height 9. To get the size of one basin, we need to determine the how many coordinates are inter-connected
 * with one another, which means that any coordinates only border either 9, edge of the grid or
 * the coordinates that are already in this basin.
 */
public class DayNineChallengeTwo {
    //A container to hold the coordinates of all the points that have been iterated so it belongs to only one basin
    //sets only allow unique elements, coordinates are unique
    private static HashSet<String> coordinatesTraversed = new HashSet<>();
    //parallel array could also be used, but it would be troublesome to get the size of the rows since it's required to
    //determine if the row is last row.
    private static List<int[]> matrix;

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/day9Input.txt"));
            List<Integer> basins = new ArrayList<>();
            matrix = new ArrayList<>();
            //populate the matrix
            while (scanner.hasNextLine()) {
                //small trick using "" to divide String into a series of chars
                int[] row = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
                //matrix has a series of arrays
                matrix.add(row);
            }
            //iterate the matrix, if the coordinate has already been calculated, continue, if not, get that basin, enter the coordinate
            for (int i = 0; i < matrix.size(); i++) {
                int[] row = matrix.get(i);
                //every element inside the matrix will be iterated
                for (int j = 0; j < row.length; j++) {
                    if (coordinatesTraversed.contains(i + " " + j))
                        continue;
                    basins.add(getBasinSize(i, j));
                }
            }
            //sort basin by natural ordering
            Collections.sort(basins);
            int product = 1;
            for (int i = basins.size() - 1; i > basins.size() - 4; i--) {
                product *= basins.get(i);
            }
            System.out.println(product);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int getBasinSize(int i, int j) {
        //if coordinates have already been traversed, that means it already belongs to a basin
        if (coordinatesTraversed.contains(i + " " + j)) {
            return 0;
        } else {
            //if not, add it to the coordinates traversed set so it won't be added to another basin
            coordinatesTraversed.add(i + " " + j);
        }
        //if it's the element is 9, return 0.
        if (matrix.get(i)[j] == 9) {
            return 0;
        }
        //initial size, the current coordinate itself
        int basinSize = 1;
        //recursively call this method to make the coordinates above, below, to the left and to the right go through the same process
        //each time the coordinate passes the condition, it will be added to the current size, the method returns 0 when
        //the 9 is reached or when the coordinates already belong to the current basin. The coordinate in the basin that this method could
        //reach could only have been added by the current basin, which is different from the condition statement from the main.
        //key point, all the coordinates that don't have a value of 9 could be reached by the current basin.
        if (i != 0)
            basinSize += getBasinSize(i - 1, j);
        if (j != 0)
            basinSize += getBasinSize(i, j - 1);
        if (i != matrix.size() - 1)
            basinSize += getBasinSize(i + 1, j);
        if (j != matrix.get(i).length - 1)
            basinSize += getBasinSize(i, j + 1);
        return basinSize;
    }

}
