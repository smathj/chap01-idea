package chap04.autodebit;

public interface AutoDebitInfoRepository {
    void save(AutoDebitInfo info);

    AutoDebitInfo findOne(String userId);
}
