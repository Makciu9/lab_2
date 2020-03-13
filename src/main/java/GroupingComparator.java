import org.apache.hadoop.io.WritableComparable;

public class GroupingComparator {
    protected GroupingComparator(){
     super(AirWritable, true);
    }
    public int compare(WritableComparable one, WritableComparable two){
        AirWritable o = (AirWritable) one;
        AirWritable t = (AirWritable) two;
        return o.getCode() - t.getCode();
    }
}
