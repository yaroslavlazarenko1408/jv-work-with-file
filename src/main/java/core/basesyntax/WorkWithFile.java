package core.basesyntax;

import java.io.*;

public class WorkWithFile {
    public void getStatistic(String fromFileName, String toFileName) {
        File fileFrom = new File(fromFileName);
        File fileTo = new File(toFileName);
        int supply = 0;
        int buy = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileFrom));
            String value = reader.readLine();
            while (value != null){
                if(value.charAt(0) == 's'){
                    String supplyNum = value.substring(7);
                    supply += Integer.parseInt(supplyNum);
                }
                if(value.charAt(0) == 'b'){
                    String buyNum = value.substring(4);
                    buy += Integer.parseInt(buyNum);
                }
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileTo, false));
            writer.write("supply," + supply + System.lineSeparator());
            writer.write("buy," + buy + System.lineSeparator());
            int result = supply - buy;
            writer.write("result," + result);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file", e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException("Can`t close file", e);
            }
        }
    }
}
