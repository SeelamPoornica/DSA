import java.util.Arrays;
class Item{
    int weight,profit;
    double ratio;
    Item(int weight,int profit){
        this.weight=weight;
        this.profit=profit;
        this.ratio=(double)profit/weight;
    }
}
public class Knapsack{
    public static double getMaxProfit(Item[] items,int m){
        Arrays.sort(items,(a,b)->Double.compare(b.ratio,a.ratio));
        double profit = 0;
        for(Item item:items){
            if(item.weight<m){
                m-=item.weight;
                profit+=item.profit;
            }
            else{
                double fraction=(double)m/item.weight;
                profit+=item.profit*fraction;
                break;
            }
        }
        return profit;
    }
    public static void main(String[] args){
        Item[] items={
            new Item(10,60),
            new Item(20,100),
            new Item(30,120)
        };
        double max=getMaxProfit(items, 50);
        System.out.println("Maximum profit in knapsack :"+max);
    }
}