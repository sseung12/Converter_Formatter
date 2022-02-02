package lss.typeconverter.converter;

import lss.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringToPortConverterTest {


    @Test
    void convert_ip() {

        StringToPortConverter converter = new StringToPortConverter();
        String source = "127.0.0.1:8080";
        IpPort result = converter.convert(source);
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }

    @Test
    void ipPortToString() {
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort source = new IpPort("127.0.0.1", 8080);
        String result = converter.convert(source);
        assertThat(result).isEqualTo("127.0.0.1:8080");
    }

    @Test
    void conversionService() {
        DefaultConversionService conversionService =
                new DefaultConversionService();

        conversionService.addConverter(new StringToPortConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        assertThat(conversionService.convert("10",
                Integer.class)).isEqualTo(10);
        assertThat(conversionService.convert(10,
                String.class)).isEqualTo("10");
        IpPort ipPort = conversionService.convert("127.0.0.1:8080",
                IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));
        String ipPortString = conversionService.convert(new IpPort("127.0.0.1",
                8080), String.class);
        assertThat(ipPortString).isEqualTo("127.0.0.1:8080");

    }
}