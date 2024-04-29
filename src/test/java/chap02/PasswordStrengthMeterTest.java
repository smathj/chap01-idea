package chap02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 암호 강도 측정기 PasswordStrengthMeter
 * 암호 강도 PasswordStrength
 *
 * -------- 조건 --------
 * 길이가 8글자 이상
 * 0~9 사이의 숫자를 포함
 * 대문자 포함
 * ---------------------
 * 3개 규칙 강함
 * 2개 규칙 보통
 * 1개 이하 약함
 * ---------------------
 */
public class PasswordStrengthMeterTest {

//    @Test
//    public void name() {
//
//    }

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    /**
     * 공통 검증 메서드
     * @param password 암호
     * @param expStr 암호 강도(등급)
     */
    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    @Test
    @DisplayName("1. 암호가 모든 조건을 충족하면서 암호 강도는 강한 경우")
    void meetsAllCriteria_Then_Strong() {
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);

    }

    @Test
    @DisplayName("2. 길이만 8글자 미만이고 나머지 조건을 충족하는 경우")
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("Ab12!c", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("3. 숫자를 포함하지 않고 나머지 조건은 충족하는 경우")
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("4. 값이 null인 경우")
    void nullInput_Then_Invalid() {
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    @DisplayName("4-1. 값이 빈 문자열 인 경우")
    void emptyInput_Then_Invalid() {
        assertStrength("", PasswordStrength.INVALID);
    }



    @Test
    @DisplayName("5. 대문자를 포함하지 않고 나머지 충족하는 경우")
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("6. 길이가 8글자 이상인 조건만 충족하는 경우")
    void meetsOnlyLengthCriteria_Then_Weak() {
        assertStrength("abdefghi", PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("7. 숫자 포함 조건만 충족하는 경우")
    void meetsOnlyNumCriteria_Then_Weak() {
        assertStrength("12345", PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("8. 대문자 포함 조건만 충족하는 경우")
    void meetsOnlyUpperCriteria_Then_Weak() {
        assertStrength("ABZEF", PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("9. 아무 조건도 충족하지 않은 경우")
    void meetsNoCriteria_Then_Weak() {
        assertStrength("abc", PasswordStrength.WEAK);
    }

}
