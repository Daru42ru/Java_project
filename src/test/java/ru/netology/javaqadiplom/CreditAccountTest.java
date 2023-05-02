package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    // Пополнение кредитного счёта
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.add(2_000);

        Assertions.assertEquals(2_500, account.getBalance());
    }
    @Test
    // Пополнение кредитного счёта на 0 рублей
    public void shouldNotAddZeroBalance() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(500, account.getBalance());
    }
    @Test
    // Сумма покупки меньше баланс+лимит
    public void shouldPayIfAmountLess() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(-2_500, account.getBalance());
    }
    @Test
    // Сумма покупки равна баланс+лимит
    public void shouldPayIfAmountEqual() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(5_500);

        Assertions.assertEquals(-5_000, account.getBalance());
    }
    @Test
    // Сумма покупки больше баланс+лимит
    public void shouldPayIfAmountMore() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(5_500, account.getBalance());
    }
    @Test
    // Сумма покупки равна 0
    public void shouldNotPayAmountZero() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(0);

        Assertions.assertEquals(500, account.getBalance());
    }
    @Test
    // Начисление процентов при отрицательном балансе
    public void shouldAccruePercentIfBalanceNegative() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(1_000);

        Assertions.assertEquals(-75, account.yearChange());
    }
    @Test
    // Начисление процентов при положительном балансе
    public void shouldNotAccruePercentIfBalancePositive() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }
    @Test
    // Начисление процентов при нуливом балансе
    public void shouldNotAccruePercentIfBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }
    @Test
    // Исключение при отрицательной ставке
    public void shouldNotNegativePercent() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(0,5000, -15);
        });
    }
    @Test
    // Исключение при отрицательном лимите
    public void shouldNotNegativeLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(0,-5000, 15);
        });
    }
    @Test
    // Исключение при отрицательном балансе (создание карты)
    public void shouldNotNegativeBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(-500,5000, 15);
        });
    }
}
