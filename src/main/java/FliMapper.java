import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class FliMapper extends Mapper<LongWritable, Text, AirWritable, Text> {
    private static final int CANCELLED = 19;
    private static final int DEST_AEROPORT_ID = 14;
    private static final int ARR_DELAY_NEW = 18;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] line = value.toString().split(",");
        if(!line[0].equals("\"YEAR\"")){
        if (Double.parseDouble(line[CANCELLED]) == (double) 0) {
            if (!line[DEST_AEROPORT_ID].equals("")
                    && (!line[ARR_DELAY_NEW].equals(""))
                    && Double.parseDouble(line[ARR_DELAY_NEW]) > (double) 0 ) {
                AirWritable m_write = new AirWritable();
                m_write.setFlag(1);
                m_write.setCode(parseInt(line[DEST_AEROPORT_ID]));
                Text time = new Text(line[ARR_DELAY_NEW]);
                context.write(m_write, time);
            }
            }
        }
    }
}








