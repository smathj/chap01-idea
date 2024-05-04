package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {

        // 코드 정리 : 상수를 변수로
        int addedMonths = payData.getPayAmount() == 100_000 ? 12 : payData.getPayAmount() / 10_000;

        if (payData.getFirstBillingDate() != null) {

            // 후보 만료일
            LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);

            // 첫 납부일의 말일
            int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();

            if (dayOfFirstBilling != candidateExp.getDayOfMonth()) {

                // 조건. 후보 만료일의 말일과 < 첫 납부일의 말일
                final int dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth();
                if (dayLenOfCandiMon < dayOfFirstBilling) {
                    return candidateExp.withDayOfMonth(dayLenOfCandiMon);
                }

                // 일자만 바꿔서 새로운 인스턴스 생성
                return candidateExp.withDayOfMonth(dayOfFirstBilling);
            } else {
                return candidateExp;
            }

        } else {
            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }


}
