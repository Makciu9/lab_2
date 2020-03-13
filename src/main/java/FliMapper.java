import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import static java.lang.Integer.parseInt;

public class FliMapper extends Mapper<> {
    private static final int CANCELLED=19;
    private static final int DEST_AEROPORT_ID=14;

    @Override
    protected void map(LongWritable key, Text value, Mapper.Context context){

        String[] line = value.toString().split(",");
        if(parseInt(line[CANCELLED]) == 0){
            if(!line[DEST_AEROPORT_ID].equals("")
                    && line[]){

            }
        }

    }
}



