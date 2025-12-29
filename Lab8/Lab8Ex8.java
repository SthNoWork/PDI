class Report {
    String reportName;
    String createdDate;
    String format;

    Report(String reportName, String createdDate, String format) {
        this.reportName = reportName;
        this.createdDate = createdDate;
        this.format = format;
    }
}

interface ReportGenerator {
    void generate();
    void export();
    void preview();
}

class PDFReportGenerator implements ReportGenerator {
    Report report;

    PDFReportGenerator(Report report) {
        this.report = report;
    }

    public void generate() {
        System.out.println("Generating PDF: " + report.reportName);
    }

    public void export() {
        System.out.println("Exporting PDF");
    }

    public void preview() {
        System.out.println("Previewing PDF");
    }
}

class ExcelReportGenerator implements ReportGenerator {
    Report report;

    ExcelReportGenerator(Report report) {
        this.report = report;
    }

    public void generate() {
        System.out.println("Generating Excel: " + report.reportName);
    }

    public void export() {
        System.out.println("Exporting Excel");
    }

    public void preview() {
        System.out.println("Previewing Excel");
    }
}

interface ReportDelivery {
    void send();
}

class EmailDelivery implements ReportDelivery {
    Report report;
    String recipient;

    EmailDelivery(Report report, String recipient) {
        this.report = report;
        this.recipient = recipient;
    }

    public void send() {
        System.out.println("Sending " + report.reportName + " to " + recipient);
    }
}

public class Lab8Ex8 {
    public static void main(String[] args) {
        Report pdfReport = new Report("Sales Report", "2025-12-29", "PDF");
        ReportGenerator pdfGen = new PDFReportGenerator(pdfReport);
        ReportDelivery emailPdf = new EmailDelivery(pdfReport, "alice@example.com");

        pdfGen.generate();
        pdfGen.export();
        pdfGen.preview();
        emailPdf.send();

        Report excelReport = new Report("Inventory Report", "2025-12-29", "Excel");
        ReportGenerator excelGen = new ExcelReportGenerator(excelReport);
        ReportDelivery emailExcel = new EmailDelivery(excelReport, "bob@example.com");

        excelGen.generate();
        excelGen.export();
        excelGen.preview();
        emailExcel.send();
    }
}
