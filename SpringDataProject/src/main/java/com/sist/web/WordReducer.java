package com.sist.web;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordReducer extends Reducer<Text, IntWritable, Text, IntWritable>{

	private IntWritable val=new IntWritable();

	//숫자갯수 누적
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		int sum=0;
		for(IntWritable i:values)
		{
			//get: 정수형, set: 문자형
			sum+=i.get();
		}
		val.set(sum);
		context.write(key, val);
	}
	
}
