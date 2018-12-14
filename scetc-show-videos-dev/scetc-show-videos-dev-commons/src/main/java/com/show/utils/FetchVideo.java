package com.show.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FetchVideo {
	private String ffmpegEXE;

	public FetchVideo(String ffmpegEXE) {
		super();
		this.ffmpegEXE = ffmpegEXE;
	}

	/**
	 * 获取截图信息
	 * 
	 * @param mp4InputPath
	 * @param coverOutputPath
	 * @throws IOException
	 */
	public void getcover(String mp4InputPath, String coverOutputPath) {
		// ffmpeg.exe -i test.mp4 spring.avi
		// ffmpeg.exe -i bgm.mp3 -i video.mp4 -t 6 -y xu.mp4
		List<String> command = new ArrayList<>();
		// ffmpeg.exe -ss 00:00:01 -i spring.mp4 -vframes 1 new.jpg
		command.add(ffmpegEXE);
		command.add("-ss");
		command.add("00:00:01");// mp3
		command.add("-y");
		command.add("-i");
		command.add(mp4InputPath);// mp3
		command.add("-vframes");
		command.add("1");// video
		command.add(coverOutputPath);

		for (String c : command) {
			System.out.println(c);
		}
		ProcessBuilder builder = new ProcessBuilder(command);
		Process process;
		try {
			process = builder.start();

			InputStream errorStream = process.getErrorStream();
			InputStreamReader reader = new InputStreamReader(errorStream);
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			while ((line = br.readLine()) != null) {

			}
			if (br != null) {
				br.close();
			}
			if (reader != null) {
				reader.close();
			}
			if (errorStream != null) {
				errorStream.close();
			}
		} catch (IOException e) {
			if (e.toString().contains("ClientAbortException"))// 这个异常是用户错误点击发生的不需要捕获
			{
				// 什么也不做
			} else {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

	}

	public static void main(String[] args) {

		FetchVideo ffmpeg = new FetchVideo("G:\\ffmepg视频处理方案\\ffmpeg-20180704-3b10bb8-win64-static\\bin\\ffmpeg.exe");
		ffmpeg.getcover("G:\\ffmepg视频处理方案\\ffmpeg-20180704-3b10bb8-win64-static\\bin\\spring.mp4",
				"G:\\ffmepg视频处理方案\\ffmpeg-20180704-3b10bb8-win64-static\\bin\\123.jpg");
		System.out.println("转换成功");

	}
}
