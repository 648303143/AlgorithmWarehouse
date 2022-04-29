# master公式
**T(N) = aT(N/b) + O(N^d)**

- N/b：子过程的样本量
- a：子过程的调用次数 
- O(N^d)：其他计算的时间复杂度 

满足如上公式的程序都可以根据master公式计算时间复杂度：

- log(b，a) > d ：时间复杂度为O(N^log(b，a))
- log(b，a) = d ：时间复杂度为O(N^d * logN)
- log(b，a) < d ：时间复杂度为O(N^d)

> 只有子问题等规模的递归才可以用master公式求时间复杂度