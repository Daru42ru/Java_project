package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    void shouldTrowIllegalArgumentExceptionIfNegativeRateForSavingAccount() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    1_000,
                    500,
                    5_000,
                    -1
            );
        });
    }


    @Test
    void shouldTrowIllegalArgumentExceptionIfNegativeMinBalanceForSavingAccount() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    1_000,
                    -1,
                    5_000,
                    5
            );
        });
    }


    @Test
    void shouldTrowIllegalArgumentExceptionIfInitialBalanceLessMinBalanceForSavingAccount() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    999,
                    1_000,
                    5_000,
                    5
            );
        });
    }


    @Test
    void shouldTrowIllegalArgumentExceptionIfMaxBalanceLessMinBalanceForSavingAccount() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    999,
                    5
            );
        });
    }


    @Test
    void shouldTrowIllegalArgumentExceptionIfMaxBalanceEqualsMinBalanceForSavingAccount() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    1_000,
                    2_000,
                    2_000,
                    5
            );
        });
    }

    @Test
    void shouldBalanceChangeToPurchaseAmountAtPayForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_500,
                500,
                7_000,
                5
        );
        account.pay(500);

        Assertions.assertEquals(1_500 - 500, account.getBalance());
    }

    @Test
    void shouldNotBalanceChangeIfAmountIsZeroAtPayForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_000,
                500,
                5_000,
                5
        );
        account.pay(0);

        Assertions.assertEquals(1_000, account.getBalance());
    }


    @Test
    void shouldNotBalanceChangeIfAmountIsNegativeAtPayForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_000,
                500,
                5_000,
                5
        );
        account.pay(-1);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    void shouldReturnFalseAtPayIfAmountIsNegativeForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_000,
                500,
                5_000,
                5
        );
        Assertions.assertFalse(account.pay(-1));
    }

    @Test
    void shouldNotChangeBalanceIfAfterAmountBalanceLessMinBalanceAtPayForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_500,
                500,
                5_000,
                5
        );

        account.pay(1_001);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    void shouldReturnFalseAtPayIfAfterAmountBalanceLessMinBalanceForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_500,
                500,
                5_000,
                5
        );
        Assertions.assertFalse(account.pay(1_001));
    }

    @Test
    void shouldBalanceChangeToAmountIfAfterAmountBalanceEqualsMinBalanceAtPayForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_500,
                500,
                5_000,
                5
        );

        account.pay(1_000);

        Assertions.assertEquals(1_500 - 1_000, account.getBalance());
    }


    //Ошибка
    @Test
    void shouldReturnTrueAtPayIfAfterAmountBalanceEqualsMinBalanceForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_500,
                500,
                5_000,
                5
        );
        Assertions.assertTrue(account.pay(1_000));
    }


    @Test
    void shouldReturnTrueAtAddLessThanMaxBalanceForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_000,
                500,
                5_000,
                5
        );
        Assertions.assertTrue(account.add(2_000));
    }

    @Test
    void shouldNotChangeBalanceAtAddIfAmountEqualsZeroForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_500,
                500,
                5_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    void shouldReturnFalseAtAddIfAmountEqualsZeroForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_500,
                500,
                5_000,
                5
        );
        Assertions.assertFalse(account.add(0));
    }

    @Test
    void shouldNotChangeBalanceAtAddIfAmountNegativeForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_500,
                500,
                5_000,
                5
        );

        account.add(-1);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    void shouldReturnFalseAtAddIfAmountNegativeForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_500,
                500,
                5_000,
                5
        );
        Assertions.assertFalse(account.add(-1));
    }

    @Test
    void shouldNotChangeBalanceAtAddIfAfterAmountBalanceMoreMaxBalanceForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_500,
                500,
                5_000,
                5
        );

        account.add(3_501);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    void shouldReturnFalseAtAddIfAfterAmountBalanceMoreThanMaxBalanceForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_500,
                500,
                5_000,
                5
        );
        Assertions.assertFalse(account.add(3_501));
    }

    @Test
    public void shouldAddEqualsMaxBalanceForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_500,
                500,
                5_000,
                5
        );

        account.add(3_500);

        Assertions.assertEquals(2_000 + 3_500, account.getBalance());
    }

    @Test
    void shouldReturnTrueAtAddIfAfterAmountBalanceEqualsMaxBalanceForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_500,
                500,
                5_000,
                5
        );
        Assertions.assertTrue(account.add(3_500));
    }

    @Test
    public void shouldAddLessThanMaxBalanceForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_500,
                500,
                5_000,
                5
        );

        account.add(1_000);

        Assertions.assertEquals(1_500 + 1_000, account.getBalance());
    }

    @Test
    void shouldCalculatePercentOnBalanceForSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_500,
                500,
                5_000,
                5
        );
        Assertions.assertEquals(75, account.yearChange());
    }

    @Test
    void shouldCalculatePercentOnBalanceIfResultIsNotIntegerForSavingAccount() {
        SavingAccount account = new SavingAccount(
                2_175,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(108, account.yearChange());
    }

    @Test
    void shouldCalculatePercentOnBalanceWithResultOneForSavingAccount() {
        SavingAccount account = new SavingAccount(
                500,
                500,
                5_000,
                5
        );
        Assertions.assertEquals(25, account.yearChange());
    }

    @Test
    void shouldCalculatePercentOnBalanceWithResultLessThanOneSavingAccount() {
        SavingAccount account = new SavingAccount(
                10,
                500,
                5_000,
                5
        );
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    void shouldCalculatePercentOnBalanceWhenBalanceIsZeroSavingAccount() {
        SavingAccount account = new SavingAccount(
                0,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    void shouldCalculatePercentOnBalanceWhenRateIsZeroSavingAccount() {
        SavingAccount account = new SavingAccount(
                1_500,
                500,
                5_000,
                0
        );
        Assertions.assertEquals(0, account.yearChange());
    }
}



