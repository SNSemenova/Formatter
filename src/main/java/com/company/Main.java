package com.company;

import com.company.destination.IDestination;
import com.company.destination.StringDestination;
import com.company.source.ISource;
import com.company.source.StringSource;

/**
 *Launches formatter.
 */
public final class Main {
    /**
     * Phrivate constructor.
     */
    private Main() {
    //not called
    }
    /**
     * Takes code and formats it.
     * @param args  command line argument
     */
    public static void main(final String[] args) {
        //инициализируем источник
        ISource source = new StringSource("hjghdfg {d;d{f;}g}h;");
        //инициализируем приемник
        IDestination destination = new StringDestination();
        // инициализируем класс форматирования
        IFormatter formatter = new Formatter();
        try {
            formatter.format(source, destination);
        } catch (FormatException e) {
            e.printStackTrace();
        }
        //закрываем файл-источник
        source.close();
        //закрываем файл-приемник
        destination.close();
        System.out.println(destination.toString());
        // "hjghdfg {\n    d;\n    d{\n        f;\n}\n     g\n}h;"
    }
}
