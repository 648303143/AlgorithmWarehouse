/**
 * @author zzzZqy
 * @create 2021-09-28 21:10
 */
/*
创建一个长度为6的int型数组,要求数组元素的值都在1-30之间,且是随机赋值,
同时,要求元素的值各不相同
 */
public class InterviewQuestions1 {
    public static void main(String[] args) {
        //方式一：
//		int[] arr = new int[6];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int) (Math.random() * 30) + 1;//获得[1,30]的随机数
//
//			boolean flag = false;//标志是否有相同元素
//			while (true) { //不断循环比较直到元素都不相同
//				for (int j = 0; j < i; j++) {
//					if (arr[i] == arr[j]) {
//                        flag = true;
//                        arr[i] = (int) (Math.random() * 30) + 1;//若与前面元素相同,
//                                                                //则重新获取随机数
//						break;//跳出for循环,从数组第一个元素重新开始比较
//					}else{
//					    flag = false;
//                    }
//				}
//				if (flag) {
//					continue;//若有相同元素,继续下一次循环
//				}
//				break;//若没有相同元素,循环停止
//			}
//		}
//
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}


        //方式二：
//		int[] arr = new int[6];
//		for (int i = 0; i < arr.length; i++) {// [0,1) [0,30) [1,31)
//			arr[i] = (int) (Math.random() * 30) + 1;
//
//			boolean flag = false;
//			while (true) {
//				for (int j = 0; j < i; j++) {
//					if (arr[i] == arr[j]) {
//						flag = true;
//						break;
//					}
//				}
//				if (flag) {
//					arr[i] = (int) (Math.random() * 30) + 1;
//					flag = false;
//					continue;
//				}
//				break;
//			}
//		}
//
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}

        //方式三：
        int[] arr = new int[6];

        for (int i = 0; i < arr.length; i++) {// [0,1) [0,30) [1,31)
            arr[i] = (int) (Math.random() * 30) + 1;

            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
