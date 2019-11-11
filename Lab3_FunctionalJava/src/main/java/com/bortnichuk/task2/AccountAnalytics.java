package com.bortnichuk.task2;

import com.bortnichuk.task2.exception.EntityNotFoundException;
import com.bortnichuk.task2.model.Account;
import com.bortnichuk.task2.model.Sex;

import java.math.BigDecimal;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class AccountAnalytics {

    private Collection<Account> accounts;

    public static AccountAnalytics of(Collection<Account> accounts) {
        return new AccountAnalytics(accounts);
    }

    private AccountAnalytics(Collection<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * Returns {@link Optional} that contains an {@link Account} with the max value of balance
     *
     * @return account with max balance wrapped with optional
     */
    public Optional<Account> findRichestPerson() {
        return accounts.stream().max(Comparator.comparing(Account::getBalance));
    }

    /**
     * Returns a {@link List} of {@link Account} that have a birthday month equal to provided.
     *
     * @param birthdayMonth a month of birth
     * @return a list of accounts
     */
    public List<Account> findAccountsByBirthdayMonth(Month birthdayMonth) {
        return accounts.stream()
                .filter(
                        account -> account
                                .getBirthday()
                                .getMonth()
                                .equals(birthdayMonth))
                .collect(Collectors.toList());
    }

    /**
     * Returns a map that separates all accounts into two lists - male and female. Map has two keys {@code true} indicates
     * male list, and {@code false} indicates female list.
     *
     * @return a map where key is true or false, and value is list of male, and female accounts
     */
    public Map<Boolean, List<Account>> partitionMaleAccounts() {
        return accounts.stream()
                .collect(Collectors.partitioningBy(account -> account.getSex().equals(Sex.MALE)));
    }

    /**
     * Returns a {@link Map} that stores accounts grouped by its email domain. A map key is {@link String} which is an
     * email domain like "gmail.com". And the value is a {@link List} of {@link Account} objects with a specific email domain.
     *
     * @return a map where key is an email domain and value is a list of all account with such email
     */
    public Map<String, List<Account>> groupAccountsByEmailDomain() {
        return accounts.stream()
                .collect(groupingBy(account -> account.getEmail()
                        .substring(account.getEmail().indexOf("@") + 1)));
    }

    /**
     * Returns a number of letters in all first and last names.
     *
     * @return total number of letters of first and last names of all accounts
     */
    public int getNumOfLettersInFirstAndLastNames() {
        return accounts.stream()
                .mapToInt(account -> account.getFirstName().length() + account.getLastName().length())
                .sum();
    }

    /**
     * Returns a total balance of all accounts.
     *
     * @return total balance of all accounts
     */
    public BigDecimal calculateTotalBalance() {
        return accounts.stream()
                .map(Account::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Returns a {@link List} of {@link Account} objects sorted by first and last names.
     *
     * @return list of accounts sorted by first and last names
     */
    public List<Account> sortByFirstAndLastNames() {
        return accounts.stream()
                .sorted(Comparator.comparing(Account::getFirstName)
                        .thenComparing(Account::getLastName))
                .collect(Collectors.toList());
    }

    /**
     * Checks if there is at least one account with provided email domain.
     *
     * @param emailDomain
     * @return true if there is an account that has an email with provided domain
     */
    public boolean containsAccountWithEmailDomain(String emailDomain) {
        return accounts.stream()
                .anyMatch(account -> account.getEmail().split("@")[1]
                        .equals(emailDomain));
    }

    /**
     * Returns account balance by its email. Throws {@link EntityNotFoundException} with message
     * "Cannot find Account by email={email}" if account is not found.
     *
     * @param email account email
     * @return account balance
     */
    public BigDecimal getBalanceByEmail(String email) {
        return accounts.stream()
                .filter(account -> account.getEmail().equals(email))
                .findFirst()
                .map(Account::getBalance)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find Account by email=" + email));
    }

    /**
     * Collects all existing accounts into a {@link Map} where a key is account id, and the value is {@link Account} instance
     *
     * @return map of accounts by its ids
     */
    public Map<Long, Account> collectAccountsById() {
        return accounts.stream()
                .collect(Collectors.toMap(
                        Account::getId,
                        account -> account
                ));
    }

    /**
     * Filters accounts by the year when an account was created. Collects account balances by its emails into a {@link Map}.
     * The key is {@link Account#getEmail()} and the value is {@link Account#getBalance()}
     *
     * @param year the year of account creation
     * @return map of account by its ids the were created in a particular year
     */
    public Map<String, BigDecimal> collectBalancesByIdForAccountsCreatedOn(int year) {
        return accounts.stream()
                .filter(account -> account.getCreationDate().getYear() == year)
                .collect(Collectors.toMap(
                        Account::getEmail,
                        Account::getBalance
                ));
    }

    /**
     * Returns a {@link Map} where key is {@link Account#getLastName()} and values is a {@link Set} that contains first names
     * of all accounts with a specific last name.
     *
     * @return a map where key is a first name and value is a set of first names
     */
    public Map<String, Set<String>> groupFirstNamesByLastNames() {
        return accounts.stream()
                .collect(groupingBy(Account::getLastName , mapping(Account::getFirstName, toSet())));
    }

    /**
     * Returns a {@link Map} where key is a birthday month, and value is a {@link String} that stores comma and space
     * -separated first names (e.g. "Polly, Dylan, Clark"), of all accounts that have the same birthday month.
     *
     * @return a map where a key is a birthday month and value is comma-separated first names
     */
    public Map<Month, String> groupCommaSeparatedFirstNamesByBirthdayMonth() {
        return accounts.stream()
                .collect(groupingBy(
                        a -> a.getBirthday().getMonth(),
                        mapping(Account::getFirstName, joining(", "))
                ));
    }

    /**
     * Returns a {@link Map} where key is a {@link Month} of {@link Account#getCreationDate()}, and value is total balance
     * of all accounts that have the same value creation month.
     *
     * @return a map where key is a creation month and value is total balance of all accounts created in that month
     */
    public Map<Month, BigDecimal> groupTotalBalanceByCreationMonth() {
        return accounts.stream()
                .collect(groupingBy(
                        account -> account.getCreationDate().getMonth(),
                        mapping(Account::getBalance, reducing(BigDecimal.ZERO, BigDecimal::add))
                ));
    }

    /**
     * Returns a {@link Map} where key is a letter {@link Character}, and value is a number of its occurrences in
     * {@link Account#getFirstName()}.
     *
     * @return a map where key is a letter and value is its count in all first names
     */
    public Map<Character, Long> getCharacterFrequencyInFirstNames() {
        return accounts.stream()
                .map(Account::getFirstName)
                .flatMapToInt(String::chars)
                .mapToObj(ch -> (char)ch)
                .collect(groupingBy(ch -> ch, counting()));
    }

    /**
     * Returns a {@link Map} where key is a letter {@link Character}, and value is a number of its occurrences ignoring
     * case, in all {@link Account#getFirstName()} and {@link Account#getFirstName()}. All letters should stored in lower case.
     *
     * @return a map where key is a letter and value is its count ignoring case in all first and last names
     */
    public Map<Character, Long> getCharacterFrequencyIgnoreCaseInFirstAndLastNames() {
        return accounts.stream()
                .flatMap(account -> Stream.of(account.getFirstName(), account.getLastName()))
                .map(String::toLowerCase)
                .flatMapToInt(String::chars)
                .mapToObj(ch -> (char)ch)
                .collect(groupingBy(ch->ch, counting()));
    }

}