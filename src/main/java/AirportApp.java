import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.jobcontrol.Job;
import org.apache.hadoop.mapred.lib.MultipleInputs;
import org.apache.hadoop.mapreduce.Mapper;

import javax.xml.soap.Text;
import java.nio.file.Path;

public class AirportApp {
    public static void main(String[] args) throws  {
        if (args.length != 3) {
            System.err.println("Usage: AirportApp <input Air> <input Fli> <output path>");
            System.exit(-1);
        }

        Job job = Job.getInstance();
        job.setJarByClass(AirportApp.class);
        job.setJobName("Airports JoinJob");

        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, AirMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, FliMapper.class);

        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        job.setPartitionerClass(AirPartitioner.class);
        job.setGroupingComparatorClass(GroupingComparator.class);
        job.setReducerClass(JoinReducer.class);

        job.setMapOutputKeyClass(TextPair.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
