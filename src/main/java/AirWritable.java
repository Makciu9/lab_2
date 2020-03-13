import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

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

    @Override
    public int compareTo(Object o) {
        AirWritable m = (AirWritable) o;
        int m_flag = m.flag;
        int m_code = m.code;

        if(this.code > m_code){
            return 1;
        }

        if(this.code < m_code){
            return -1;
        }

        if(this.flag > m_flag){
            return 1;
        }

        if(this.flag < m_flag){
            return -1;
        }
        return 0;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(flag);
        dataOutput.writeInt(code);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        flag = dataInput.readInt();
        code = dataInput.readInt();
    }

}
