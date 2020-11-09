/**
 * Created  meteor on 2020/8/28
 * 常见排序算法
 **/
public class SotrOrder {


    public static void main(String[] args) {
        long[] ary = {9, 1, 5, 8, 3, 7, 4, 6, 2};

        insterValueSort(ary);
        for (long temp : ary) {
            System.err.println(temp);
        }
    }


    // 冒泡排序
    private static void bubbleSort(long[] ary) {
        int i = 0;
        for (; i < ary.length; i++) {
            for (int j = i + 1; j < ary.length; j++) {
                //  I 小于j 则交互
                if (ary[i] > ary[j]) {
                    swap(ary, i, j);
                }
            }
        }
    }

    // 选择排序法
    private static void selectiongSort(long[] ary) {
        // 取一个指针指向最低
        int i = 0, min = 0;
        for (; i < ary.length; i++) {
            //默认当前是最小的
            min = i;
            for (int j = 1 + i; j < ary.length; j++) {
                // 如果当前最小的大于下一个数则最小指针变动
                if (ary[min] > ary[j]) {
                    min = j;
                }
            }
            // 如果有比他大的则对调
            if (min != i) {
                swap(ary, i, min);
            }
        }
    }

    /**
     * 插值排序
     *
     * @param ary
     */
    private static void insterValueSort(long[] ary) {
        int i = 1;
        for (; i < ary.length; i++) {
            //比较值
            long sentinel = ary[i];
            int lastIndex = i - 1;
            for (; lastIndex > -1; lastIndex--) {
                long temp = ary[lastIndex];
                if (sentinel < temp) {
                    swap(ary, lastIndex + 1, lastIndex);
                }
            }
        }
    }



    private static void swap(long[] ary, int i, int j) {
        //
        long temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }


    public static void shellSort(long[] ary) {



    }


}
