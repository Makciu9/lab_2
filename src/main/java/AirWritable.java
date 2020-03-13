import org.apache.hadoop.io.WritableComparable;

public class AirWritable implements WritableComparable {
    private int flag;
    private int code;

    public void setCode(int code) {
        this.code = code;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getCode() {
        return code;
    }

    public int getFlag() {
        return flag;
    }


}
