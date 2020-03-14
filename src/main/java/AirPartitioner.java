import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;



public class AirPartitioner extends Partitioner<AirWritable, Text> {

    @Override
    public int getPartition(AirWritable airWritable, Text text, int i) {
        return airWritable.getCode() % i;
    }
}
