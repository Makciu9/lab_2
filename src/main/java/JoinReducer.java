import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<AirWritable, Text, String, String> {
    @Override
    protected void reduce(AirWritable key, Iterable<Text> values, Context context) throws
            IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        String AirportName = iter.next().toString();
        if(iter.hasNext()){
        int counter = 0;
        Double min = Double.MAX_VALUE;
        Double max = Double.MIN_VALUE;
        Double currVal;
        while (iter.hasNext()) {
            currVal = parseFloat( )

        }
    }
}