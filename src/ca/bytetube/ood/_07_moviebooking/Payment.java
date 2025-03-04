package ca.bytetube.ood._07_moviebooking;

import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    private String id;
    private double amount;
    private PaymentMethod method;
    private PaymentStatus status;
    private LocalDateTime paymentTime;

    public Payment(double amount, PaymentMethod method) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.method = method;
        this.status = PaymentStatus.PENDING;
    }

    public boolean process() {
        // 实现支付处理逻辑
        try {
            // 模拟支付过程
            Thread.sleep(1000);
            this.status = PaymentStatus.SUCCESS;
            this.paymentTime = LocalDateTime.now();
            return true;
        } catch (Exception e) {
            this.status = PaymentStatus.FAILED;
            return false;
        }
    }

    // getters and setters
}
