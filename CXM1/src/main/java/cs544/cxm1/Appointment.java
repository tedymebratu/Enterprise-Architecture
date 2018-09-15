package cs544.cxm1;

import javax.persistence.*;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private int id;
    private String appdate;
    @Embedded
    private Payment payment;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Patient patient;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Doctor doctor;

    public Appointment() {
    }

    public String getAppdate() {
        return appdate;
    }

    public void setAppdate(String appdate) {
        this.appdate = appdate;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
