import java.util.ArrayList;

public class NumberJumble {

    public static void main(String[] args) {
        // 1. Create ArrayList of Integer objects name it list. 
 //    This should be the only ArrayList you create in this lab.
        ArrayList<Integer> list = new ArrayList<Integer>();
        printListInfo("1. Empty list", list);

        // 2. Fill list with 11 Integer objects with values from 500 to 510 (inclusive)
        //    This should be the only place you specify the actual integer values 500 to 510.
        for (int i = 500; i <= 510; i++) {
            list.add(i);
        }
        printListInfo("2. Filled list", list);

        // 3. Rotate list Left.  The first element must be placed at the end.
        //    Do NOT use the rotate() method nor a loop! 
        int firstElement = list.remove(0);
        list.add(firstElement);
        printListInfo("3. Rotated left list ", list);

        // 4. Rotate list Right.  The last element must be placed at the front.
        //    Do NOT use the rotate() method nor a loop! 
        int lastElement = list.remove(list.size() - 1);
        list.add(0, lastElement);
        printListInfo("4. Rotated right list", list);

        // 5. Reverse the elements in list.  Use a loop!
        for (int i = 0; i < list.size() / 2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(list.size() - 1 - i));
            list.set(list.size() - 1 - i, temp);
        }
        printListInfo("5. Reversed list", list);

        // 6. "Double" each element in the list by inserting a second
        //    Integer object immediately after the original Integer object.
        //    e.g. [1,2,3] would become [1,1,2,2,3,3]
        //    Use a loop!
        ArrayList<Integer> doubledList = new ArrayList<Integer>();
        for (int num : list) {
            doubledList.add(num);
            doubledList.add(num);
        }
        list = doubledList;
        printListInfo("6. Doubled up list", list);

        // 7. Replace each of element of the list with a new Integer object
        //    whose value is one-third the original value.
        //    Use a loop!  
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) / 3);
        }
        printListInfo("7. Divided by 3 list", list);

        // 8. Remove all consecutive duplicate elements.  Use a loop!
        ArrayList<Integer> noConsecutiveDuplicatesList = new ArrayList<Integer>();
        for (int num : list) {
            if (noConsecutiveDuplicatesList.isEmpty() || num != noConsecutiveDuplicatesList.get(noConsecutiveDuplicatesList.size() - 1)) {
                noConsecutiveDuplicatesList.add(num);
            }
        }
        list = noConsecutiveDuplicatesList;
        printListInfo("8. No consecutive duplicates list", list);
    }

    private static void printListInfo(String heading, ArrayList<Integer> list) {
        System.out.println(heading);
        System.out.println("Size: " + list.size());
        System.out.println("List: " + list.toString());
        System.out.println();
    }
}