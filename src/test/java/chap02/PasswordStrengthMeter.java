package chap02;
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
public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {
        if(s == null || s.isEmpty()) return PasswordStrength.INVALID;

        int metCounts = getMetCriteriaCounts(s);

        if(metCounts <= 1) return PasswordStrength.WEAK;
        if(metCounts == 2) return PasswordStrength.NORMAL;


        return PasswordStrength.STRONG; // 3개 만족
    }

    /**
     * 조건 계산 메서드
     */
    private int getMetCriteriaCounts(String s) {
        int metCounts = 0;
        // 길이가 8글자 이상 인지 판별
        if (s.length() >= 8) metCounts++;
        // 숫자 판별
        if (meetsContainingNumberCriteria(s)) metCounts++;
        // 대문자 판별
        if (meetsContainingUppercaseCriteria(s)) metCounts++;
        return metCounts;
    }


    /**
     * 숫자 포함 여부
     */
    private static boolean meetsContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }


    /**
     * 대문자 포함 여부
     */
    private boolean meetsContainingUppercaseCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }
}
