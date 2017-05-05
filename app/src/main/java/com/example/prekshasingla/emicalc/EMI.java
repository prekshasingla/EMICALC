package com.example.prekshasingla.emicalc;

/**
 * Created by prekshasingla on 05/05/17.
 */
public class EMI {
    Integer TENURE;
    Float EMI;
    float TOTAL;

    public EMI(float TOTAL, Integer TENURE, Float EMI) {
        this.TENURE = TENURE;
        this.EMI = EMI;
        this.TOTAL = TOTAL;
    }
}
