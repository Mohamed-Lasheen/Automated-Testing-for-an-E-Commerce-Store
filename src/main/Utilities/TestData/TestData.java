package TestData;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestData {
    public static String fakeAccount = "NotReal" + new Random().nextInt(1000) + "@gmail.com";
    public static String fakePassword= "MtPasswords" + new Random().nextInt(1000) + "!@#";

    public static Object[][] getCheckoutTestData() {
        List<Object[]> testData = new ArrayList<>();
        String csvFile = "src/test/java/test-data/checkout-data.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                testData.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return testData.toArray(new Object[0][0]);
    }
}
