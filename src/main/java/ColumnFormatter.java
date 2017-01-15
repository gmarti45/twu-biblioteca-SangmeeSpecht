/**
 * Created by sspecht on 1/13/17.
 */
public class ColumnFormatter {
    public String formatColumns(String title, String author, String year) {
        String recordRow = String.format("%-50s", title);
        recordRow += String.format("%-25s", author);
        recordRow += year;
        recordRow += "\n";
        return recordRow;
    }


    public String returnFormattedHeader() {
        return formatColumns("Title", "Author","Year Published");
    }
}
