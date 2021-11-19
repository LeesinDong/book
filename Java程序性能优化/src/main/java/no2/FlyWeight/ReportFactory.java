package no2.FlyWeight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public class ReportFactory {
    private Map<String, IReportManager> financialReportMap = new HashMap<>();
    private Map<String, IReportManager> employeeReportMap = new HashMap<>();

    public IReportManager getFinancialReport(String tenantId) {
        IReportManager reportManager = financialReportMap.get(tenantId);
        if (reportManager == null) {
            reportManager = new FinancialReport();
            financialReportMap.put(tenantId, reportManager);
        }
        return reportManager;
    }

    public IReportManager getEmployeeReportMap(String tenantId) {
        IReportManager manager = employeeReportMap.get(tenantId);
        if (manager == null) {
            manager = new EmplyeeReportManager();
            employeeReportMap.put(tenantId, manager);
        }
        return manager;
    }
}
