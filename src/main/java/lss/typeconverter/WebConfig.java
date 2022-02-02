package lss.typeconverter;

import lss.typeconverter.converter.IntegerToStringConverter;
import lss.typeconverter.converter.IpPortToStringConverter;
import lss.typeconverter.converter.StringToIntegerConverter;
import lss.typeconverter.converter.StringToPortConverter;
import lss.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToPortConverter());
        registry.addConverter(new IpPortToStringConverter());
        registry.addFormatter(new MyNumberFormatter());
    }

}
