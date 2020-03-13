import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FliMapper extends Mapper<> {
    private static final int CANCELLED=19;
    
    @Override
    protected void map(LongWritable key, Text value, Mapper.Context context){

        String[] line = value.toString().split(",");

    }
}



