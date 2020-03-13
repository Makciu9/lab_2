public class FliMapper extends Mapper<> {
}



● public class WordMapper extends Mapper<> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws
            IOException, InterruptedException {
        String line = value.toString();
        String[] words =
                StringTools.split(StringTools.removeAllNonSymbols(line).toLowerCase());
        for (String word : words) {
            context.write(new Text(word), new IntWritable(1));
        }
    }
}