package org.example;

import org.assertj.core.util.Streams;
import org.example.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/*
* 테스트생성키 ? comd + n
* 주석키 comd + /
* 주석키 comd + shift + /
* */
public class CalculatorTest {



    @DisplayName("덧셈 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateTest(int operand1,String operator ,int operand2, int result) {

        int calculateResult = Calculator.calculate(new PositiveNumber(operand1),operator,new PositiveNumber(operand2));

        assertThat(calculateResult).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult(){
        return Stream.of(
                arguments(1,"+",2,3),
                arguments(1,"-",2,-1),
                arguments(4,"*",2,8),
                arguments(4,"/",2,2)
        );

    }

//    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
//    @Test
//    void calculateExceptionTest(){
//        assertThatCode(() -> Calculator.calculate(new PositiveNumber(10),"/", new PositiveNumber(0)))
//                .isInstanceOf(IllegalAccessError.class)
//                .hasMessage("0또는 음수를 전달할 수 없습니다.");
//    }



//    @DisplayName("덧셈 연산을 수행한다.")
//    @Test
//    void additionTest() {
//        int result = Calculator.calculate(1,"+",2);
//
//        assertThat(result).isEqualTo(3);
//    }
//
//    @DisplayName("뺄셈 연산을 수행한다.")
//    @Test
//    public void subtractionTest() {
//        int result = Calculator.calculate(1,"-",2);
//
//        assertThat(result).isEqualTo(-1);
//
//    }
}
