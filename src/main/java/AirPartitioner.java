import org.apache.hadoop.mapreduce.Partitioner;

import javax.xml.soap.Text;

public class AirPartitioner extends Partitioner<AirWritable> {

    @Override
    public int getPartition(AirWritable key, int i) {
        return key.getCode() % i;
    }

    @Override
    public int getPartition(Object o, Object o2, int i) {
        return 0;
    }
}
