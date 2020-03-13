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
        Double min = Double.parseDouble(iter.next().toString());
        Double max = Double.MIN_VALUE;
        Double currVal;
        Double sum;
        while (iter.hasNext()) {
            currVal =Double.parseDouble(iter.next().toString());

            if (currVal > max){
                max = currVal;
            }

            if (currVal < min){
                min = currVal;
            }
            sum += currVal;
            counter++;

        }
    }
}