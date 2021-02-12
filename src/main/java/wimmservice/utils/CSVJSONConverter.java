package wimmservice.utils;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;

public class CSVJSONConverter {

    public static void csvToJson(File csvFile, File jsonFile) throws IOException {
        CsvSchema transactionLineSchema = CsvSchema.emptySchema().withHeader().withColumnSeparator(';');
        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<BankTransactionLine> banktransactionlines = csvMapper.readerFor(BankTransactionLine.class)
                .with(transactionLineSchema)
                .readValues(csvFile);

        new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .writeValue(jsonFile, banktransactionlines.readAll());
    }


    public static void main(String[] args) {

        File fileCsv = new File(args[0]);
        File fileJson = new File(args[1]);
        try {
            csvToJson(fileCsv,fileJson);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
