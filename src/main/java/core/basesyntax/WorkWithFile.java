package core.basesyntax;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WorkWithFile {
    private static final int SUPPLY_COMMA_POSITION = 7;
    private static final int BUY_COMMA_POSITION = 4;
    public void getStatistic(String fromFileName, String toFileName) {
        int supply = 0;
        int buy = 0;

        try (BufferedReader reader = new BufferedReader(
                new FileReader(fromFileName))) {
            String value = reader.readLine();

            while (value != null) {
                if (value.charAt(0) == 's') {
                    supply += Integer.parseInt(value.substring(SUPPLY_COMMA_POSITION));
                }

                if (value.charAt(0) == 'b') {
                    buy += Integer.parseInt(value.substring(BUY_COMMA_POSITION));
                }

                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(toFileName, false))) {
            writer.write("supply," + supply + System.lineSeparator());
            writer.write("buy," + buy + System.lineSeparator());
            writer.write("result," + (supply - buy));
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
