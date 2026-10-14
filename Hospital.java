package HospitalAssigment;

class Patient {
    String patientName;
    double consultationFee;

    public Patient(String patientName, double consultationFee) {
        this.patientName = patientName;
        this.consultationFee = consultationFee;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void showDetails() {
        System.out.println("Patient Name: " + patientName);
        System.out.println("Consult Fee: $" + consultationFee);
    }
}
//Outpatient
class Outpatient extends Patient {
    double labFee;

    Outpatient(String patientName, double consultationFee,
                      double labFee) {
        super(patientName, consultationFee);
        this.labFee = labFee;
    }

    // Calculate
    public double calculateBill() {
        return labFee + getConsultationFee();
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Lab Charge: $" + labFee);
        System.out.println("Total Bill: $" + calculateBill());
    }
}

// Inpatient
class Inpatient extends Patient {
    double dailyRoomRate;
    int daysAdmitted;

    public Inpatient(String patientName, double consultationFee,
                     double dailyRoomRate, int daysAdmitted) {
        super(patientName, consultationFee);
        this.dailyRoomRate = dailyRoomRate;
        this.daysAdmitted = daysAdmitted;
    }

    // Calculate Total Bill
    public double calculateBill() {
        return (daysAdmitted * dailyRoomRate)
                + getConsultationFee();
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Daily Room Rate: $" + dailyRoomRate);
        System.out.println("Number of Days: " + daysAdmitted);
        System.out.println("Total Bill: $" + calculateBill());
    }
}

// Main Class
public class Hospital {

    public static void main(String[] args) {

        Inpatient admitted = new Inpatient("Abdikarim", 40, 20, 4);
        Outpatient visitor = new Outpatient("Mohamed", 40, 15);

        System.out.println("  IN-PATIENT \n ");
        admitted.showDetails();
        System.out.println("\n OUT-PATIENT \n ");
        visitor.showDetails();
    }
}
