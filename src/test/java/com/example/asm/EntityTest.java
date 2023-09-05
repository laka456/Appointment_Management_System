package com.example.asm;

import com.example.asm.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EntityTest {

    @Test
    public void user() {
        User user = new User();
        assertThat(user).isNotNull();
        assertThat(user.getId()).isGreaterThanOrEqualTo(0);
        assertThat(user.getName()).isNullOrEmpty();
        assertThat(user.getUsername()).isNullOrEmpty();
        assertThat(user.getPassword()).isNullOrEmpty();
        assertThat(user.getRole()).isNull();
    }

    @Test
    public void job_seeker() {
        JobSeeker seeker = new JobSeeker();
        assertThat(seeker).isNotNull();
        assertThat(seeker.getId()).isGreaterThanOrEqualTo(0);
        assertThat(seeker.getName()).isNullOrEmpty();
        assertThat(seeker.getJob_type()).isNullOrEmpty();
        assertThat(seeker.getGender()).isNullOrEmpty();
        assertThat(seeker.getEmail()).isNull();
        assertThat(seeker.getCountry()).isNull();
        assertThat(seeker.getAddress()).isNull();
        assertThat(seeker.getPhone()).isNull();
    }

    @Test
    public void consultant_availability() {
        ConsultantAvailability consultantAvailability = new ConsultantAvailability();
        assertThat(consultantAvailability).isNotNull();
        assertThat(consultantAvailability.getId()).isGreaterThanOrEqualTo(0);
        assertThat(consultantAvailability.getDate()).isNull();
        assertThat(consultantAvailability.getStartTime()).isNullOrEmpty();
        assertThat(consultantAvailability.getEndTime()).isNullOrEmpty();
    }

    @Test
    public void consultant() {
        Consultant consultant = new Consultant();
        assertThat(consultant).isNotNull();
        assertThat(consultant.getId()).isGreaterThanOrEqualTo(0);
        assertThat(consultant.getCountry()).isNull();
        assertThat(consultant.getJob_type()).isNullOrEmpty();
        assertThat(consultant.getAvailability()).isNullOrEmpty();
    }

    @Test
    public void appointment() {
        Appointment appointment = new Appointment();
        assertThat(appointment).isNotNull();
        assertThat(appointment.getId()).isGreaterThanOrEqualTo(0);
        assertThat(appointment.getConsultant()).isNull();
        assertThat(appointment.getType()).isNullOrEmpty();
        assertThat(appointment.getDate()).isNull();
        assertThat(appointment.getSeeker()).isNull();
        assertThat(appointment.getStartTime()).isNull();
        assertThat(appointment.getEndTime()).isNull();
    }
}
