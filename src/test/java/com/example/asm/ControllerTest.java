package com.example.asm;

import com.example.asm.controller.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ControllerTest {

    @Autowired
    private AppointmentController appointmentController;

    @Autowired
    ConsultantAvailabilityController consultantAvailabilityController;

    @Autowired
    ConsultantController consultantController;

    @Autowired
    DashboardController dashboardController;

    @Autowired
    JobSeekerController jobSeekerController;

    @Autowired
    ReportController reportController;

    @Autowired
    UserController userController;

    @Test
    public void contextLoads() {
        assertThat(this.appointmentController).isNotNull();
        assertThat(this.consultantAvailabilityController).isNotNull();
        assertThat(this.consultantController).isNotNull();
        assertThat(this.dashboardController).isNotNull();
        assertThat(this.jobSeekerController).isNotNull();
        assertThat(this.reportController).isNotNull();
        assertThat(this.userController).isNotNull();
    }
}
