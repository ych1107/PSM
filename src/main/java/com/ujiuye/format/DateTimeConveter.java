package com.ujiuye.format;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class DateTimeConveter implements Converter<String, Date> {
	@Override
	public Date convert(String source) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date result = sim.parse(source);
			return result;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
