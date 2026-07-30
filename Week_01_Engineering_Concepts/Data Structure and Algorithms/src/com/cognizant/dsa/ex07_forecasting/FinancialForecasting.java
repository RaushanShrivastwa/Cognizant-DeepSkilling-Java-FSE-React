package com.cognizant.dsa.ex07_forecasting;

// ==========================================================
// 1. FORECASTING CALCULATOR ENGINE
// ==========================================================
class ForecastEngine {

    /**
     * Recursive method to calculate future value.
     * Formula: Future Value = Past Value * (1 + Growth Rate)
     * * @param presentValue The starting financial value
     * @param growthRate The constant annual inflation/growth rate (e.g., 0.05 for 5%)
     * @param years The number of compounding time-periods remaining
     * @return The final forecasted asset valuation
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // BASE CASE: If years reach zero, compounding stops, return the value as-is
        if (years <= 0) {
            return presentValue;
        }

        // RECURSIVE CASE: Calculate value for (years - 1) compounded by the current year's growth
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }
}

// ==========================================================
// 2. MAIN TEST RUNNER
// ==========================================================
public class FinancialForecasting {
    public static void main(String[] args) {
        System.out.println("=== Testing Exercise 7: Financial Forecasting ===");

        double initialInvestment = 10000.0; // $10,000 principal
        double annualGrowthRate = 0.07;     // 7% annual interest compound
        int targetYears = 10;               // Projection timeline

        System.out.println("Initial Investment : $" + initialInvestment);
        System.out.println("Projected Growth   : " + (annualGrowthRate * 100) + "% annually");
        System.out.println("Forecasting Window : " + targetYears + " Years");

        // Execute recursive computation pipeline
        double estimatedFutureValue = ForecastEngine.calculateFutureValue(initialInvestment, annualGrowthRate, targetYears);

        System.out.println("\n--- Forecast Result ---");
        System.out.printf("Estimated Asset Value after %d years: $%.2f\n", targetYears, estimatedFutureValue);
        System.out.println("------------------------");
    }
}