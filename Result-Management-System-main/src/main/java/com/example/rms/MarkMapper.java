package com.example.rms;

public class MarkMapper {
	public static MarkDto mapToMarkDto(Mark mark) {
		return new MarkDto(mark.getId(),mark.getmonth(),mark.getdays(),mark.getyear());
	}
	
	public static Mark mapToMark(MarkDto mark) {
		return new Mark(mark.getId(),mark.getmonth(),mark.getdays(),mark.getyear());
	}
}
