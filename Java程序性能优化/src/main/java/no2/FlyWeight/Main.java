package no2.FlyWeight;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public class Main {
    public static void main(String[] args) {
        ReportFactory reportFactory = new ReportFactory();
        IReportManager a = reportFactory.getFinancialReport("A");
        a.createReportID();
        IReportManager b = reportFactory.getEmployeeReportMap("B");
        b.createReportID();
    }
}
