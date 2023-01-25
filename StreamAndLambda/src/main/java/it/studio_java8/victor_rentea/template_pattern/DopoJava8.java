package it.studio_java8.victor_rentea.template_pattern;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.function.Consumer;
import org.jooq.lambda.Unchecked;
import it.studio_java8.esercitazioni.victor_rentea.template_pattern.repository.OrderRepository;
import it.studio_java8.esercitazioni.victor_rentea.template_pattern.repository.UserRepository;

public class DopoJava8 {
    public static void main(String[] args) {
        FileExporter2 fileExporter = new FileExporter2();
        OrderExporterWriter orderExporterWriter = new OrderExporterWriter();
        UserExporterWriter userExporterWriter = new UserExporterWriter();

        fileExporter.export("orderCsv", Unchecked.consumer(orderExporterWriter::writerContent));
        fileExporter.export("userCsv", Unchecked.consumer(userExporterWriter::writerContent));
    }
}


class FileExporter2 {

    public File export(String fileName, Consumer<Writer> contentWriter) {
        File file = new File("export/" + fileName);

        try (Writer writer = new FileWriter(file)) {
            contentWriter.accept(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }
}


class OrderExporterWriter {
    public OrderRepository repository;

    public void writerContent(Writer writer) throws IOException {
        writer.write("UserId;Name\n");

        repository.findAll()
                .stream()
                .map(o -> o.getId() + ";" + o.getName() + "\n")
                .forEach(Unchecked.consumer(writer::write));
    }
}


class UserExporterWriter {
    public UserRepository repository;

    public void writerContent(Writer writer) throws IOException {
        writer.write("UserId;Name\n");

        repository.findAll()
                .stream()
                .map(u -> u.getId() + ";" + u.getCodiceFsicale() + "\n")
                .forEach(Unchecked.consumer(writer::write));
    }
}
