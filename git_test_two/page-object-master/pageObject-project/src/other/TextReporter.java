package other;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TextReporter extends Reporter {
    protected FileWriter fw;
    protected String fileName;
    protected String basicFileName;
    private String documentRoot;

    //Конструктор по умолчанию
    public TextReporter(String reason) throws IOException {
        fw = new FileWriter(fileName = basicFileName = reason + ".txt", true);
    }

    public void switchContext(String documentRoot) throws IOException {
        fw.close();
        File file = new File(fileName);
        file.renameTo(new File(fileName = documentRoot + "\\" + basicFileName));
        fw = new FileWriter(fileName);
        this.documentRoot = documentRoot;
    }

    public void writeLog(String type, String message) throws IOException {
        super.writeLog(type, message);
        fw.write(timestamp() + " " + type + " " + message + "\n");
        fw.flush();
    }

    public void startTest(String promo, String test) throws IOException {
        super.startTest(promo, test);
        fw.write("*** " + test + " on " + promo + " started ***\n");
        fw.flush();
    }

    public void endTest()
            throws IOException {
        fw.write("*** " + currentTest + " on " + currentPromo + " finished with status " + getStatus() + " ***\n");
        setResultInTheTable(currentPromo, currentTest, getStatus());
        fw.flush();
    }

    public String getReportPath() throws IOException {
        return (new File(fileName)).getCanonicalPath();
    }

    public void setResultInTheTable(String promo, String test, String result) throws IOException {
        try {
            File tableReport = new File(this.documentRoot + "\\" + promo + "TableReport.txt");

            if (!tableReport.exists()) {
                tableReport.createNewFile();
                fw.write("Создан новый файл с результирующей таблицей" + " \n");
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss");
            String txtDate = dateFormat.format(new Date());

            FileOutputStream  output = new FileOutputStream(tableReport, true);
            output.write(("Промо " + promo + " - тест " + test + " -- " + result.toUpperCase() + " " + txtDate + " \n").getBytes());
            output.flush();
            output.close();
        }
        catch (Exception e) {
            fw.write("Ошибка записи в результирующую таблицу" + e.getMessage() + " \n");
        }
    }
}

