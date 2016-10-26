import com.company.FormatException;
import com.company.Formatter;
import com.company.IFormatter;
import com.company.destination.IDestination;
import com.company.destination.StringDestination;
import com.company.source.ISource;
import com.company.source.StringSource;

public class Main {

    public static void main(String[] args) {
        //инициализируем источник
        ISource source = new StringSource("hjghdfg {d;d{f;}g}h;");
        //инициализируем приемник
        IDestination destination = new StringDestination();
        // инициализируем класс форматирования
        IFormatter formatter = new Formatter();
        // вызываем метод форматирования с параметрами: файл-источник и файл-приемник
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
