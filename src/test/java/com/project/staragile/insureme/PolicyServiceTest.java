package com.project.staragile.insureme;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.expectThrows;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

@SpringBootTest
public class PolicyServiceTest {

    @Autowired
    private PolicyService policyService;

    @Test
    public void testCreatePolicy() {
        Policy policy = new Policy();
        policy.setPolicyId("P2001");
        policy.setPolicyHolder("Vedika");
        policy.setPolicyType("Life");
        policy.setPremiumAmount(2500.00);
        policy.setStartDate(LocalDate.now());
        policy.setEndDate(LocalDate.now().plusYears(1));

        Policy saved = policyService.createPolicy(policy);
        assertNotNull(saved.getPolicyId(), "Policy ID should not be null");
        assertEquals(saved.getPolicyHolder(), "Vedika");
    }

    @Test
    public void testUpdatePolicy() {
        Policy policy = policyService.viewPolicy("P1001");
        policy.setPremiumAmount(1800.00);
        Policy updated = policyService.updatePolicy("P1001", policy);
        assertEquals(updated.getPremiumAmount(), 1800.00);
    }

    @Test
    public void testDeletePolicy() {
        policyService.deletePolicy("P1002");
        expectThrows(RuntimeException.class, () -> policyService.viewPolicy("P1002"));
    }
}
