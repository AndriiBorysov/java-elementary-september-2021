package com.aborysov;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        IStudentStringConverter converter1 = randomConverter();

        Student student = new Student("Иван", 21, new BigDecimal("3.14"));

        String result1 = converter1.convert(student);
        System.out.println(result1);
    }

    private IStudentStringConverter randomConverter() {
        double random = Math.random();
        if (random > 0.66) {
            return new StudentJsonConverter();
        } else if (random > 0.33) {
            return new StudentXmlConverter();
        } else {
            return new StudentKeyValueConverter();
        }
    }
}
