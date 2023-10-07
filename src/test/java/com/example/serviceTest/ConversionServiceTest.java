package com.example.serviceTest;

import com.example.service.ConversionService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
public class ConversionServiceTest {

    @InjectMocks
    private ConversionService conversionService;

    @Test
    public void test_doConversion_directConvert() {
        String sourceUnit = "BBL";
        String targetUnit = "MT";
        Double sourceAmount = 304.0;
        Double expected = 40.0;
        Double converted = conversionService.doConversion(sourceUnit, targetUnit, sourceAmount);

        assertThat(converted).isNotNull();
        assertThat(converted).isEqualTo(expected);
    }

    @Test
    public void test_doConversion_indirectConvert() {
        String sourceUnit = "BBL";
        String targetUnit = "KG";
        Double sourceAmount = 152.0;
        Double expected = 20000.0;
        Double converted = conversionService.doConversion(sourceUnit, targetUnit, sourceAmount);

        assertThat(converted).isNotNull();
        assertThat(converted).isEqualTo(expected);
    }

    @Test
    public void test_doConversion_bidirectionalConvert() {
        String sourceUnit = "MT";
        String targetUnit = "BBL";
        Double sourceAmount = 40.0;
        Double expected = 304.0;
        Double converted = conversionService.doConversion(sourceUnit, targetUnit, sourceAmount);

        assertThat(converted).isNotNull();
        assertThat(converted).isEqualTo(expected);
    }

    @Test
    public void test_doConversion_invalidTargetUnit() {
        String sourceUnit = "MT";
        String targetUnit = "MT";
        Double sourceAmount = 40.0;
        Double expected = 304.0;

        assertThrows(IllegalArgumentException.class, () -> {
            conversionService.doConversion(sourceUnit, targetUnit, sourceAmount);
        });
    }
    @Test
    public void test_doConversion_invalidSourceUnit() {
        String sourceUnit = "KM";
        String targetUnit = "MT";
        Double sourceAmount = 40.0;
        Double expected = 304.0;

        assertThrows(IllegalArgumentException.class, () -> {
            conversionService.doConversion(sourceUnit, targetUnit, sourceAmount);
        });
    }


}
