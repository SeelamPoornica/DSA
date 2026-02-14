import java.util.Arrays;
class Job{
    int id,deadline,profit;
    Job(int id,int deadline,int profit){
        this.id=id;
        this.deadline=deadline;
        this.profit=profit;
    }
}
public class JobScheduling {
    public static void scheduleJob(Job[] jobs){
        Arrays.sort(jobs,(a,b)->(b.profit-a.profit));
        int n=jobs.length;
        int profit=0;
        int[] result=new int[n];
        boolean[] solts=new boolean[n];
        for(Job job:jobs){
            for(int i=job.deadline-1;i>=0;i--){
                if(!solts[i]){
                    solts[i]=true;
                    result[i]=job.id;
                    profit+=job.profit;
                    break;
                }
            }
        }
        System.out.println("Job selected:");
        for(int job:result){
            if(job!=0){
                System.out.print(job+"  ");
            }
        }
        System.out.println("\nTotal profit ="+profit);
    }
    public static void main(String[] args){
        Job[] jobs={
            new Job(1,2,100),
            new Job(2,1,19),
            new Job(3,2,27),
            new Job(4,1,25),
            new Job(5,3,15)
        };
        scheduleJob(jobs);
    }
}
