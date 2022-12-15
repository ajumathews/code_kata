import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Main {

    public static void main(String[] args) {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try{
            Scheduler scheduler = schedulerFactory.getScheduler();
            JobDetail job = JobBuilder.newJob(SimpleJob.class)
                    .withIdentity("myJob", "group1")
                    .usingJobData("jobSays", "Hello World!")
                    .usingJobData("myFloatValue", 3.141f).build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("myTrigger", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(40)
                            .repeatForever())
                    .build();

            scheduler.scheduleJob(job,trigger);

            scheduler.start();

        }catch (SchedulerException e){
            System.out.println(e.toString());
        }
    }

}
