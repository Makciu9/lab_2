import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import static java.lang.Integer.parseInt;

public class FliMapper extends Mapper<> {
    private static final int CANCELLED = 19;
    private static final int DEST_AEROPORT_ID = 14;
    private static final int ARR_DELAY_NEW = 18;

    @Override
    protected void map(LongWritable key, Text value, Context context) {

        String[] line = value.toString().split(",");
        if (parseInt(line[CANCELLED]) == 0) {
            if (!line[DEST_AEROPORT_ID].equals("")
                    && (!line[ARR_DELAY_NEW].equals(""))
                    && parseInt(line[ARR_DELAY_NEW]) > 0) {
                AirWritable m_write = new AirWritable();
                m_write.setFlag(1);
                m_write.setCode(parseInt(line[DEST_AEROPORT_ID]));
                Text time = new Text(line[ARR_DELAY_NEW]);
                context.write(m_write, time);
            }
        }
    }
}








