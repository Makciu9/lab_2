import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class AirportMapper {

        private static final int CODE = 0;
        private static final int DESCRIPTION = 1;

        @Override
        protected void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {

            String[] line = value.toString().replace("\"","").split(",(!?)");

                    AirWritable m_write = new AirWritable();
                    m_write.setFlag(0);
                    m_write.setCode(parseInt(line[CODE]));
                    Text time = new Text(line[DESCRIPTION]);
                    context.write(m_write, time);
                }
}



