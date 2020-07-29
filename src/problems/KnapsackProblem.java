package problems;

public class KnapsackProblem {
    public static int maxVal(int w, int[] values, int weights[], int index, int sumV, int sumW) {
        if (index == values.length) {
            return sumV;
        }
        if (weights[index]+sumW > w) {
            return sumV;
        }

        return Math.max(maxVal(w,values,weights,index+1,sumV+values[index], sumW+weights[index]),
                maxVal(w,values,weights,index+1,sumV, sumW));

    }

    public static void main(String[] args) {
        System.out.println("hello");
        int[] values = new int[]{60,100,120};
        int[] weights = new int[]{10,20,30};
        // rank --> 6, 5, 4
        System.out.println(maxVal(50, values, weights, 0, 0, 0));

    }
}
