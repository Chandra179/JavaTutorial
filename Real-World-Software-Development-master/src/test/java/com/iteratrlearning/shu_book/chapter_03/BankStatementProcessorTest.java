package com.iteratrlearning.shu_book.chapter_03;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.Test;

public class BankStatementProcessorTest {

	@Test
	public void shouldFilterTransactionsInFebruary() {

		final BankTransaction februarySalary = new BankTransaction(LocalDate.of(2019, Month.FEBRUARY, 14), 2_000,
				"Salary");
		final BankTransaction marchRoyalties = new BankTransaction(LocalDate.of(2019, Month.MARCH, 20), 500,
				"Royalties");
		final BankTransaction sundayBonus = new BankTransaction(LocalDate.of(2022, Month.MAY, 29), 9999, "Royalties");

		final List<BankTransaction> bankTransactions = List.of(februarySalary, marchRoyalties, sundayBonus);

		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

		final List<BankTransaction> transactions = bankStatementProcessor
				.findTransactions(new BankTransactionIsInFebruaryAndExpensive());

		final double transactionsTotalInMonth = bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY);
		System.out.println(transactionsTotalInMonth);

		final double transactionsTotalInWeeks = bankStatementProcessor.calculateTotalInDay(DayOfWeek.SUNDAY);
		System.out.println(transactionsTotalInWeeks);

		// USING PREDICATE & STREAM
//		final List<BankTransaction> transactions = bankStatementProcessor
//				.findTransactions(bankTransaction -> bankTransaction.getDate().getMonth() == Month.FEBRUARY
//						&& bankTransaction.getAmount() >= 1_000);

		assertThat(transactions, contains(februarySalary));
		assertThat(transactions, hasSize(1));
	}

	class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter {
		@Override
		public boolean test(final BankTransaction bankTransaction) {
			return bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1_000;
		}
	}
}