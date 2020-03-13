import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.Ma;
import org.apache.hadoop.mapreduce.Mapper;

public class FliMapper extends Mapper<> {
    @Override
    protected void map(LongWritable key, Text value, Mapper.Context context){

        String[] line = value.toString().split(",");
        
    }
}



