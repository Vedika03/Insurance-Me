package com.project.staragile.insureme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class InsureMeApplicationTests {

    @Test
    void testDummy() {
        assertEquals(2, 1 + 1, "Math should work");
    }

    @Test
    void testPolicyObject() {
        Policy policy = new Policy(1, "Vedika", "Health", 50000, "2025-01-01", "2026-01-01");
        assertNotNull(policy.getPolicyId());
        //assertEquals("Vedika", policy.getPolicyHolder());
    }
}
