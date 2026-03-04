
public class BMICalculator {


    public BMIStatus calculateBMI(double weight, double height) {
        // Convert height from cm to m
        double heightInMeters = height / 100.0;

        // Calculate BMI: BMI = weight(kg) / (height(m) x height(m))
        double bmi = weight / (heightInMeters * heightInMeters);

        // Return status based on BMI value
        return BMIStatus.fromBMI(bmi);
    }


    public double calculateBMIValue(double weight, double height) {
        // Convert height from cm to m
        double heightInMeters = height / 100.0;

        // Calculate BMI
        return weight / (heightInMeters * heightInMeters);
    }
}

