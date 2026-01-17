import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Lab11Ex7 {

    static class Record {
        String[] data;
        double average;

        Record(String[] data, double average) {
            this.data = data;
            this.average = average;
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Path inputFile = Paths.get("CandidatePerformanceTest.csv");
        Path outputFile = Paths.get("CandidatePerformanceTest_sorted.csv");

        List<Record> records = new ArrayList<>();

        String headerLine1;
        String headerLine2;
        String[] headers;

        try (BufferedReader reader = Files.newBufferedReader(inputFile)) {

            headerLine1 = readFullCSVRecord(reader);
            headerLine2 = readFullCSVRecord(reader);
            headers = parseCSV(headerLine2);

            int avgCol = -1;
            int mathCol = -1, engCol = -1, compCol = -1;

            for (int i = 0; i < headers.length; i++) {
                String h = headers[i].replace("\"", "").trim().toLowerCase();
                if (h.equals("average"))
                    avgCol = i;
                if (h.equals("math"))
                    mathCol = i;
                if (h.equals("english"))
                    engCol = i;
                if (h.equals("computer"))
                    compCol = i;
            }

            String line;
            while ((line = readFullCSVRecord(reader)) != null) {

                if (line.trim().isEmpty())
                    continue;

                String[] values = parseCSV(line);
                double average;

                if (avgCol >= 0) {
                    average = Double.parseDouble(values[avgCol].trim());
                } else {
                    double m = Double.parseDouble(values[mathCol].trim());
                    double e = Double.parseDouble(values[engCol].trim());
                    double c = Double.parseDouble(values[compCol].trim());
                    average = (m + e + c) / 3.0;
                }

                records.add(new Record(values, average));
            }
        }

        List<Record> sortedRecords = mergeSort(records);

        try (BufferedWriter writer = Files.newBufferedWriter(outputFile)) {

            if (headerLine1 != null && !headerLine1.trim().isEmpty()) {
                writer.write(headerLine1);
                writer.newLine();
            }

            boolean hasAverage = false;
            for (String h : headers) {
                if (h.replace("\"", "").trim().equalsIgnoreCase("average")) {
                    hasAverage = true;
                }
            }

            writer.write(hasAverage ? headerLine2 : headerLine2 + ",Average");
            writer.newLine();

            for (Record r : sortedRecords) {
                if (hasAverage) {
                    writer.write(String.join(",", r.data));
                } else {
                    writer.write(String.join(",", r.data) + "," +
                            String.format("%.2f", r.average));
                }
                writer.newLine();
            }
        }

        System.out.println("Sorted file written to " + outputFile);
        sc.close();
    }

    static String readFullCSVRecord(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line == null)
            return null;

        StringBuilder record = new StringBuilder(line);
        int quoteCount = countQuotes(line);

        while (quoteCount % 2 != 0) {
            String nextLine = reader.readLine();
            if (nextLine == null)
                break;
            record.append("\n").append(nextLine);
            quoteCount += countQuotes(nextLine);
        }

        return record.toString();
    }

    static int countQuotes(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '"')
                count++;
        }
        return count;
    }

    static List<Record> mergeSort(List<Record> list) {
        if (list.size() <= 1)
            return list;

        int mid = list.size() / 2;
        List<Record> left = mergeSort(new ArrayList<>(list.subList(0, mid)));
        List<Record> right = mergeSort(new ArrayList<>(list.subList(mid, list.size())));

        return merge(left, right);
    }

    static List<Record> merge(List<Record> left, List<Record> right) {
        List<Record> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).average >= right.get(j).average) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        while (i < left.size())
            result.add(left.get(i++));
        while (j < right.size())
            result.add(right.get(j++));

        return result;
    }

    static String[] parseCSV(String line) {
        List<String> fields = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    current.append('"');
                    i++;
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (c == ',' && !inQuotes) {
                fields.add(current.toString());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }

        fields.add(current.toString());
        return fields.toArray(new String[0]);
    }
}
