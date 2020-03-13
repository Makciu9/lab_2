import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupingComparator extends WritableComparator {
    protected GroupingComparator(){
     super(AirWritable.class, true);
    }
    public int compare(WritableComparable one, WritableComparable two){
        AirWritable o = (AirWritable) one;
        AirWritable t = (AirWritable) two;
        return o.getCode() - t.getCode();
    }
}
