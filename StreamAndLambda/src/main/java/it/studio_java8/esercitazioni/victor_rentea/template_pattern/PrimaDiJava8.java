package it.studio_java8.esercitazioni.victor_rentea.template_pattern;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import org.jooq.lambda.Unchecked;
import it.studio_java8.esercitazioni.victor_rentea.template_pattern.repository.OrderRepository;
import it.studio_java8.esercitazioni.victor_rentea.template_pattern.repository.UserRepository;

public class PrimaDiJava8 {
    public static void main(String[] args) {
        OrderExporter orderExporter = new OrderExporter();
        orderExporter.export("orderCsv");

        UserExporter userExporter = new UserExporter();
        userExporter.export("userCsv");
    }
}


abstract class FileExporter {

    public File export(String fileName) {
        File file = new File("export/" + fileName);

        try (Writer writer = new FileWriter(file)) {
            writerContent(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    protected abstract void writerContent(Writer writer) throws IOException;
}


class OrderExporter extends FileExporter {
    public OrderRepository repository;

    @Override
    protected void writerContent(Writer writer) throws IOException {
        writer.write("UserId;Name\n");

        repository.findAll()
                .stream()
                .map(o -> o.getId() + ";" + o.getName() + "\n")
                .forEach(Unchecked.consumer(writer::write));
    }
}


class UserExporter extends FileExporter {
    public UserRepository repository;

    @Override
    protected void writerContent(Writer writer) throws IOException {
        writer.write("UserId;Name\n");

        repository.findAll()
                .stream()
                .map(u -> u.getId() + ";" + u.getCodiceFsicale() + "\n")
                .forEach(Unchecked.consumer(writer::write));
    }
}
