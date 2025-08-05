import javax.swing.JOptionPane;

/**
 * This class demonstrates bubble sort algorithm in descending order and displays array elements
 * Uses JOptionPane for user input
 */
public class bubblesortArray {
    /**
     * Main method - entry point of the program
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            // Get the number of elements from user
            String sizeInput = JOptionPane.showInputDialog(
                "How many numbers do you want to enter?");
            
            // Check if user cancelled
            if (sizeInput == null) {
                JOptionPane.showMessageDialog(null, "Program cancelled by user.");
                return;
            }
            
            // Convert string to integer
            int size = Integer.parseInt(sizeInput);
            
            // Validate size
            if (size <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter a positive number!");
                return;
            }
            
            // Create array with user-specified size
            int array[] = new int[size];
            
            // Get each array element from user
            for (int i = 0; i < size; i++) {
                String numberInput = JOptionPane.showInputDialog(
                    "Enter number " + (i + 1) + ":");
                
                // Check if user cancelled
                if (numberInput == null) {
                    JOptionPane.showMessageDialog(null, "Program cancelled by user.");
                    return;
                }
                
                array[i] = Integer.parseInt(numberInput);
            }
            
            // Display original array
            String originalArray = "Original array: ";
            for (int num : array) {
                originalArray += num + " ";
            }
            JOptionPane.showMessageDialog(null, originalArray);

            // Sort the array
            bubbleSort(array);

            // Display sorted array
            String sortedArray = "Sorted array (descending): ";
            for (int num : array) {
                sortedArray += num + " ";
            }
            JOptionPane.showMessageDialog(null, sortedArray);
            
            // Also print to console
            System.out.println("Sorted array: ");
            for(int i : array) {
                System.out.print(i + " ");
            }
            System.out.println(); // Add newline after printing all elements
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers only!");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Program cancelled by user.");
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Array index error: " + e.getMessage());
        }
    }

    /**
     * Sorts an array in descending order using the bubble sort algorithm
     * @param array the array to be sorted
     */
    public static void bubbleSort(int array[]) {
        int n = array.length;
        boolean swapped;

        // Outer loop for each pass
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // If the current element is smaller than the next, swap them (for descending order)
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no elements were swapped, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
    /**
     * Method to print the elements of the array
     * @param array the array to be printed
     */
    public static void printArray(int array[]) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    /**
     * Method to swap two elements in the array
     * @param array the array containing the elements to be swapped
     * @param i index of the first element
     * @param j index of the second element
     */
    public static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}