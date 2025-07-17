//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void windowPosSum(int[] a, int n) {
    for(int i=0;i<a.length;i++){
        if(a[i]<0){
            continue;
        }
        for(int j=1;j<=n;j++){
            if(i+j>a.length-1){
                break;
            }
            a[i]=a[i]+a[i+j];
        }
    }
    }
 public static void main(String[] args){
     int[] a = {1, 2, -3, 4, 5, 4};
     int n = 3;
     windowPosSum(a, n);
     for(int i=0;i<a.length;i++) System.out.println(a[i]);
 }
}