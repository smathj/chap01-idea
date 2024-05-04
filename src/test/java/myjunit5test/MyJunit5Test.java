package myjunit5test;

import org.junit.jupiter.api.*;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("나의 JUnit5 테스트")
public class MyJunit5Test {

    @BeforeAll
    public static void beforeAll() {
        System.out.println();
        System.out.println();
        System.out.println("######### 모든 테스트 시작 전에 호출 됩니다 #########");
        System.out.println("MyJunit5Test.beforeAll");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("######### 모든 테스트 시작 후에 호출 됩니다 #########");
        System.out.println("MyJunit5Test.afterAll");
        System.out.println();
        System.out.println();
    }

    @BeforeEach
    public void boforeEach() {
        System.out.println();
        System.out.println("------- 각 테스트 별로 시작 전에 호출 됩니다 -------");
        System.out.println("MyJunit5Test.boforeEach");
    }
    @AfterEach
    public void afterEach() {
        System.out.println("------- 각 테스트 별로 종료 후에 호출 됩니다 -------");
        System.out.println();
        System.out.println("MyJunit5Test.afterEach");
    }

    @Test
    @DisplayName("assertTrue - 참 단정")
    void test1() {
        System.out.println("MyJunit5Test.test1");
        assertTrue(true);
    }

    @Test
    @DisplayName("assertFalse - 거짓 단정")
    void test2() {
        System.out.println("MyJunit5Test.test2");
        assertFalse(false);
    }

    @Test
    @DisplayName("assertNull - Null 단정")
    void test3() {
        System.out.println("MyJunit5Test.test3");
        assertNull(null);
    }

    @Test
    @DisplayName("assertNotNull - Not Null 단정")
    void test4() {
        System.out.println("MyJunit5Test.test4");
        assertNotNull("낫널");
    }

    @Test
    @DisplayName("fail - 테스트 실패로 단정")
    void test5() {
        System.out.println("MyJunit5Test.test5");
        Random random = new Random();
        for (int i = 1; i < 30; i++) {
            int value = random.nextInt(11);
            if (value == 10) {
                System.out.println("10 이 등장하면 테스트 실패로 처리");
                fail();
            }
        }
    }

    @Test
    @DisplayName("assertEquals - 같음을 단정")
    void test6() {
        System.out.println("MyJunit5Test.test6");
        int expectValue = 10;
        int paramValue = 10;
        assertEquals(expectValue, paramValue);
    }

    @Test
    @DisplayName("assertNotEquals - 다름을 단정 1")
    void test7() {
        System.out.println("MyJunit5Test.test7");
        int expectValue = 10;
        int paramValue = 100;
        assertNotEquals(expectValue, paramValue);
    }
    @Test
    @DisplayName("assertNotEquals - 다름을 단정 2")
    void test7_2() {
        System.out.println("MyJunit5Test.test7_2");
        class MyObj {
            String name;
            public MyObj(String name) {
                this.name = name;
            }
        }
        MyObj myObj1 = new MyObj("사탕");
        MyObj myObj2 = new MyObj("사탕");
        assertNotEquals(myObj1, myObj2);
    }


    @Test
    @DisplayName("assertSame - 객체가 같음을 단정")
    void test8() {
        System.out.println("MyJunit5Test.test8");
        class MyObj {
            String name;
            public MyObj(String name) {
                this.name = name;
            }
        }
        MyObj myObj1 = new MyObj("사탕");
        assertSame(myObj1, myObj1);

        String text = "텍스트";
        String text2 = "텍스트";
        assertSame(text, text2);

        Long l1 = 1L;
        Long l2 = 1L;
        assertSame(l1, l2);
    }


    @Test
    @DisplayName("assertNotSame - 객체가 같음을 단정")
    void test9() {
        System.out.println("MyJunit5Test.test9");
        class MyObj {
            String name;
            public MyObj(String name) {
                this.name = name;
            }
        }
        MyObj myObj1 = new MyObj("사탕");
        MyObj myObj2 = new MyObj("사탕");
        assertNotSame(myObj1, myObj2);
    }


    @Test
    @DisplayName("assertThrows - 특정 예외가 발생했음을 단정")
    void test10() {
        System.out.println("MyJunit5Test.test10");
        assertThrows(RuntimeException.class, () -> {
            System.out.println("임의의 서비스 호출");
            System.out.println("임의의 레포지토리 호출");
            System.out.println("RuntimeException 예외가 발생합니다");
            throw new RuntimeException();
        });
    }

    @Test
    @DisplayName("assertThrows - 특정 예외가 발생했음을 단정")
    void test11() {
        System.out.println("MyJunit5Test.test11");
        assertDoesNotThrow(() -> {
            System.out.println("임의의 서비스 호출");
            System.out.println("임의의 레포지토리 호출");
            System.out.println("예외 없이 잘 진행");
        });
    }






}
