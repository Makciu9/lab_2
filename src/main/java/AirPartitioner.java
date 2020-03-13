import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;



public class AirPartitioner extends Partitioner<AirWritable, Text> {

    @Override
    public int getPartition(AirWritable key, Text text, int i) {
        return key.getCode() % i;
    }
}
